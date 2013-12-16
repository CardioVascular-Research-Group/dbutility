package edu.jhu.cvrg.dbapi.factory;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import edu.jhu.cvrg.dbapi.dto.AnalysisJobDTO;
import edu.jhu.cvrg.dbapi.dto.AnnotationDTO;
import edu.jhu.cvrg.dbapi.dto.DocumentRecordDTO;
import edu.jhu.cvrg.dbapi.dto.FileInfoDTO;
import edu.jhu.cvrg.dbapi.factory.hibernate.AnalysisJob;
import edu.jhu.cvrg.dbapi.factory.hibernate.AnnotationInfo;
import edu.jhu.cvrg.dbapi.factory.hibernate.Coordinate;
import edu.jhu.cvrg.dbapi.factory.hibernate.DocumentRecord;
import edu.jhu.cvrg.dbapi.factory.hibernate.FileInfo;
import edu.jhu.cvrg.dbapi.factory.hibernate.UploadStatus;
import edu.jhu.cvrg.dbapi.util.DBUtilityProperties;

public class HibernateConnection extends Connection {

	private static SessionFactory sessionFactory;
	
	
	public HibernateConnection() {
		super(ConnectionType.HIBERNATE);
	}
	
	@Override
	protected void init() {
		if(sessionFactory == null){
			Configuration cfg = new Configuration();
			
			cfg.addAnnotatedClass(DocumentRecord.class);
			cfg.addAnnotatedClass(AnnotationInfo.class);
			cfg.addAnnotatedClass(Coordinate.class);
			cfg.addAnnotatedClass(FileInfo.class);
			cfg.addAnnotatedClass(UploadStatus.class);
			cfg.addAnnotatedClass(AnalysisJob.class);
			
			cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL82Dialect");
			cfg.setProperty("hibernate.connection.username", props.getProperty(DBUtilityProperties.HIBERNATE_DB_USERNAME));
			cfg.setProperty("hibernate.connection.password", props.getProperty(DBUtilityProperties.HIBERNATE_DB_PASSWORD));
			cfg.setProperty("hibernate.connection.driver_class", props.getProperty(DBUtilityProperties.HIBERNATE_DRIVER_CLASS));
	    	cfg.setProperty("hibernate.connection.url", props.getProperty(DBUtilityProperties.HIBERNATE_DB_URL));
	    	
	    	cfg.setProperty("hibernate.show_sql", props.getProperty(DBUtilityProperties.HIBERNATE_SHOW_SQL));
	    	cfg.setProperty("hibernate.c3p0.min_size", "5");
	    	cfg.setProperty("hibernate.c3p0.max_size", "20");
	    	cfg.setProperty("hibernate.c3p0.timeout", "1800");
	    	cfg.setProperty("hibernate.c3p0.max_statements", "50");
	    	
	    	ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();        
	        sessionFactory = cfg.buildSessionFactory(serviceRegistry);
	    }
	}

	@Override
	public Long storeDocument(long userID, long groupID, long companyID,
			String recordName, String subjectID, String originalFormat,
			double samplingRate, String fileTreePath, int leadCount,
			int numPoints, Calendar dateUploaded, int age, String gender,
			Calendar dateRecorded, double aduGain, String studyID,
			int fileSize, String datatype, long[] filesId) {
		
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		DocumentRecord record = new DocumentRecord(null, recordName, userID, subjectID, originalFormat, samplingRate, fileTreePath, leadCount, numPoints, 
																   dateUploaded != null ? dateUploaded.getTime() : null, age, gender, dateRecorded != null ? dateRecorded.getTime():null, aduGain);
		
		session.save(record);
		
		_storeFilesInfo(record.getDocumentRecordId(), filesId, null, session);
		
		session.getTransaction().commit();
		session.close();
		
		return record.getDocumentRecordId();
	}

	@Override
	public Long storeAnnotations(Set<AnnotationDTO> annotSet) {
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Long counter = 0L;
		
		try{
			
			for (AnnotationDTO annotationInfo : annotSet) {
				try{
					AnnotationInfo ret = _storeAnnotation(annotationInfo, session);
					
					if(ret != null){
						counter++;
						if(counter % 100 == 0){
							session.flush();
							session.clear();
						}
					}
				}catch (Exception e){
					e.printStackTrace();
				}
			}
			
		}finally{
			session.getTransaction().commit();
			session.close();
		}
		
		return counter;
	}

	@Override
	public Long storeAnnotation(AnnotationDTO annotation) {
		
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		AnnotationInfo ann = _storeAnnotation(annotation, session);
		
		session.getTransaction().commit();
		session.close();
		
		return ann.getAnnotationId();
		
	}

	private AnnotationInfo _storeAnnotation(AnnotationDTO annotation,Session session) {
		
		Long startCoordId = null; 
		Long endCoordId = null;
		if(annotation.getStartXcoord() != null && annotation.getStartYcoord() != null){
			
			startCoordId = addCoordinate(session, annotation.getStartXcoord(), annotation.getStartYcoord());
			endCoordId = startCoordId;
			
			if(annotation.getEndXcoord() != null && annotation.getEndYcoord() != null && (annotation.getStartXcoord() != annotation.getEndXcoord() || annotation.getStartYcoord() != annotation.getEndYcoord())){
				endCoordId = addCoordinate(session, annotation.getEndXcoord(), annotation.getEndYcoord());
			}
		}
		
		AnnotationInfo ann = new AnnotationInfo(null, annotation.getRecordID(), startCoordId, endCoordId, annotation.getCreatedBy(), annotation.getAnnotationType(), annotation.getName(), annotation.getBioportalRef(), 
													  annotation.getBioportalID(), annotation.getLead(), annotation.getUnitMeasurement(), annotation.getDescription(), 
													  annotation.getValue());
		session.save(ann);
		return ann;
	}

	private void _storeFilesInfo(long documentRecordId, long[] fileEntryId, Long analysisJobId, Session session) {
		
		if(fileEntryId != null){
			for (Long id : fileEntryId) {
				FileInfo file = new FileInfo(id, documentRecordId, analysisJobId);
				session.save(file);
			}
		}
		
	}
	
	private Long addCoordinate(Session session, Double x, Double y) {
		
		Coordinate coord = new Coordinate(null, x, y);
		
		session.save(coord);
		
		return coord.getCoordinateId();
	}

	@Override
	public boolean storeFilesInfo(long documentRecordId, long[] fileEntryId, Long analysisJobId) {
		
		boolean ret = false;
		try{
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			_storeFilesInfo(documentRecordId, fileEntryId, analysisJobId, session);
			
			session.getTransaction().commit();
			session.close();
			ret = true;
		}catch (HibernateException e){
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return ret;
	}

	@Override
	public List<FileInfoDTO> getFileIdListByUser(long userId) {
		
		List<FileInfoDTO> ret = new ArrayList<FileInfoDTO>();
		
		Session session = sessionFactory.openSession();
		
		Query q = session.createQuery("select d.filesInfo from DocumentRecord d where d.userId = :userid");
		
		q.setParameter("userid", userId);
		
		List<FileInfo> l = q.list();
		
		for (int i = 0; i < l.size(); i++) {
			FileInfo entity = l.get(i);
			ret.add(new FileInfoDTO(entity.getDocumentRecordId(), entity.getFileId(), entity.getAnalysisJobId()));
		}
		
		session.close();
		
		return ret;
	}
	
	public Long storeAnalysisJob(long documentRecord, int fileCount, int parameterCount, String serviceUrl, String serviceName, String serviceMethod, Date dateOfAnalysis, long userId){
		
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		AnalysisJob job = new AnalysisJob(null, documentRecord, fileCount, parameterCount, serviceUrl, serviceName, serviceMethod, dateOfAnalysis, userId);
		
		session.save(job);
		
		session.getTransaction().commit();
		session.close();
		
		return job.getAnalysisJobId();
	}

	@Override
	public AnalysisJobDTO getAnalysisJobById(long jobId) {
		
		AnalysisJobDTO ret = null;
		
		Session session = sessionFactory.openSession();
		
		Query q = session.createQuery("select a from AnalysisJob a where a.analysisJobId = :jobId");
		
		q.setParameter("jobId", jobId);
		
		List<AnalysisJob> l = q.list();
		
		if(l.size() > 0){
			AnalysisJob entity = l.get(0);
			ret = new AnalysisJobDTO(entity.getAnalysisJobId(), entity.getDocumentRecordId(), entity.getFileCount(), entity.getParameterCount(), entity.getServiceName(), entity.getServiceUrl(), entity.getServiceMethod(), entity.getDateOfAnalysis(), entity.getUserId());
		}
		session.close();
		
		return ret;
	}
	
	@Override
	public DocumentRecordDTO getDocumentRecordById(long documentRecordId) {
		
		DocumentRecordDTO ret = null;
		
		Session session = sessionFactory.openSession();
		
		Query q = session.createQuery("select d from DocumentRecord d where d.documentRecordId = :documentRecordId");
		
		q.setParameter("documentRecordId", documentRecordId);
		
		List<DocumentRecord> l = q.list();
		
		if(l.size() > 0){
			DocumentRecord entity = l.get(0);
			ret = new DocumentRecordDTO(entity.getDocumentRecordId(), entity.getRecordName(), entity.getUserId(), entity.getSubjectId(), entity.getOriginalFormat(), entity.getSamplingRate(), entity.getFileTreePath(),entity.getLeadCount(), entity.getNumberOfPoints(), entity.getDateOfUpload(), entity.getAge(), entity.getGender(), entity.getDateOfRecording(), entity.getAduGain());
		}
		session.close();
		
		return ret;
	}
	
}
