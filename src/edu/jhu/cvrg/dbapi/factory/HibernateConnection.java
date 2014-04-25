package edu.jhu.cvrg.dbapi.factory;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

//import org.cvrgrid.philips.jaxb.beans.Globalmeasurements.Print;
import org.hibernate.HibernateException;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.Parameter;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
//import org.hsqldb.error.Error;
//import org.postgresql.util.PSQLException;

import edu.jhu.cvrg.dbapi.dto.AdditionalParameters;
import edu.jhu.cvrg.dbapi.dto.Algorithm;
import edu.jhu.cvrg.dbapi.dto.AnalysisJobDTO;
import edu.jhu.cvrg.dbapi.dto.AnnotationDTO;
import edu.jhu.cvrg.dbapi.dto.DocumentRecordDTO;
import edu.jhu.cvrg.dbapi.dto.FileInfoDTO;
import edu.jhu.cvrg.dbapi.dto.ParameterValidator;
import edu.jhu.cvrg.dbapi.dto.Service;
import edu.jhu.cvrg.dbapi.dto.UploadStatusDTO;
import edu.jhu.cvrg.dbapi.enums.EnumFileType;
import edu.jhu.cvrg.dbapi.factory.hibernate.AWS_Algorithm;
import edu.jhu.cvrg.dbapi.factory.hibernate.AWS_AlgorithmPerson;
import edu.jhu.cvrg.dbapi.factory.hibernate.AWS_Organization;
import edu.jhu.cvrg.dbapi.factory.hibernate.AWS_OrganizationContact;
import edu.jhu.cvrg.dbapi.factory.hibernate.AWS_Parameter;
import edu.jhu.cvrg.dbapi.factory.hibernate.AWS_ParameterOption;
import edu.jhu.cvrg.dbapi.factory.hibernate.AWS_ParameterType;
import edu.jhu.cvrg.dbapi.factory.hibernate.AWS_ParameterValidator;
import edu.jhu.cvrg.dbapi.factory.hibernate.AWS_Person;
import edu.jhu.cvrg.dbapi.factory.hibernate.AWS_Service;
import edu.jhu.cvrg.dbapi.enums.EnumUploadState;
import edu.jhu.cvrg.dbapi.factory.hibernate.AnalysisJob;
import edu.jhu.cvrg.dbapi.factory.hibernate.AnnotationInfo;
import edu.jhu.cvrg.dbapi.factory.hibernate.Coordinate;
import edu.jhu.cvrg.dbapi.factory.hibernate.DocumentRecord;
import edu.jhu.cvrg.dbapi.factory.hibernate.FileInfo;
import edu.jhu.cvrg.dbapi.factory.hibernate.UploadStatus;
import edu.jhu.cvrg.dbapi.util.DBUtilityProperties;
//import edu.jhu.cvrg.waveform.model.Algorithm;

public class HibernateConnection extends Connection {

	private static SessionFactory sessionFactory;
	
	
	public HibernateConnection() {
		super(ConnectionType.HIBERNATE);
	}
	
	@Override
	protected void init() {
		if(sessionFactory == null || props.hasChanges()){
			
			if(sessionFactory != null){
				sessionFactory.close();
			}
			
			Configuration cfg = new Configuration();
			
			cfg.addAnnotatedClass(DocumentRecord.class);
			cfg.addAnnotatedClass(AnnotationInfo.class);
			cfg.addAnnotatedClass(Coordinate.class);
			cfg.addAnnotatedClass(FileInfo.class);
			cfg.addAnnotatedClass(UploadStatus.class);
			cfg.addAnnotatedClass(AnalysisJob.class);

			cfg.addAnnotatedClass(AWS_Service.class);
			cfg.addAnnotatedClass(AWS_Parameter.class);
			cfg.addAnnotatedClass(AWS_Algorithm.class);
			cfg.addAnnotatedClass(AWS_AlgorithmPerson.class);
			cfg.addAnnotatedClass(AWS_Organization.class);
			cfg.addAnnotatedClass(AWS_OrganizationContact.class);
			cfg.addAnnotatedClass(AWS_ParameterOption.class);
			cfg.addAnnotatedClass(AWS_ParameterType.class);
			cfg.addAnnotatedClass(AWS_ParameterValidator.class);
			cfg.addAnnotatedClass(AWS_Person.class);

			
			cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL82Dialect");
			cfg.setProperty("hibernate.connection.username", props.getProperty(DBUtilityProperties.HIBERNATE_DB_USERNAME));
			cfg.setProperty("hibernate.connection.password", props.getProperty(DBUtilityProperties.HIBERNATE_DB_PASSWORD));
			cfg.setProperty("hibernate.connection.driver_class", props.getProperty(DBUtilityProperties.HIBERNATE_DRIVER_CLASS));
	    	cfg.setProperty("hibernate.connection.url", props.getProperty(DBUtilityProperties.HIBERNATE_DB_URL));
	    	
	    	cfg.setProperty("hibernate.show_sql", props.getProperty(DBUtilityProperties.HIBERNATE_SHOW_SQL));
	    	cfg.setProperty("hibernate.c3p0.min_size", props.getProperty(DBUtilityProperties.HIBERNATE_C3P0_MIN_SIZE));
	    	cfg.setProperty("hibernate.c3p0.max_size", props.getProperty(DBUtilityProperties.HIBERNATE_C3P0_MAX_SIZE));
	    	cfg.setProperty("hibernate.c3p0.timeout", props.getProperty(DBUtilityProperties.HIBERNATE_C3P0_TIMEOUT));
	    	cfg.setProperty("hibernate.c3p0.max_statements", props.getProperty(DBUtilityProperties.HIBERNATE_C3P0_MAX_STATEMENTS));
	    	
	    	ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();        
	        sessionFactory = cfg.buildSessionFactory(serviceRegistry);
	    }
	}

	@Override
	public Long storeDocument(long userID, long groupID, long companyID,
			String recordName, String subjectID, int originalFormat,
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
		
		AnnotationInfo ann = new AnnotationInfo(null, annotation.getRecordID(), startCoordId, endCoordId, annotation.getCreatedBy(), annotation.getAnnotationType(), annotation.getName(), annotation.getBioportalReferenceLink(), 
													  annotation.getBioportalOntology(), annotation.getBioportalClassId(), annotation.getLead(), annotation.getUnitMeasurement(), annotation.getDescription(), 
													  annotation.getValue(), annotation.getAnalysisJobId());
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
	public List<FileInfoDTO> getFileListByUser(long userId) {
		
		List<FileInfoDTO> ret = new ArrayList<FileInfoDTO>();
		
		Session session = sessionFactory.openSession();
		
		Query q = session.createQuery("select d.filesInfo from DocumentRecord d where d.userId = :userid");
		
		q.setParameter("userid", userId);
		
		@SuppressWarnings("unchecked")
		List<FileInfo> l = q.list();
		
		for (int i = 0; i < l.size(); i++) {
			FileInfo entity = l.get(i);
			ret.add(new FileInfoDTO(entity.getDocumentRecordId(), entity.getFileId(), entity.getAnalysisJobId()));
		}
		
		session.close();
		
		return ret;
	}
	
	@Override
	public List<FileInfoDTO> getFileListByDocumentRecordId(long docId) {
		
		List<FileInfoDTO> ret = new ArrayList<FileInfoDTO>();
		
		Session session = sessionFactory.openSession();
		
		Query q = session.createQuery("select f from FileInfo f where f.documentRecordId = :docId and f.analysisJobId is null");
		
		q.setParameter("docId", docId);
		
		@SuppressWarnings("unchecked")
		List<FileInfo> l = q.list();
		
		for (int i = 0; i < l.size(); i++) {
			FileInfo entity = l.get(i);
			ret.add(new FileInfoDTO(entity.getDocumentRecordId(), entity.getFileId(), entity.getAnalysisJobId()));
		}
		
		session.close();
		
		return ret;
	}
	
	@Override
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
		
		@SuppressWarnings("unchecked")
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
		
		@SuppressWarnings("unchecked")
		List<DocumentRecord> l = q.list();
		
		if(l.size() > 0){
			DocumentRecord entity = l.get(0);
			ret = new DocumentRecordDTO(entity.getDocumentRecordId(), entity.getRecordName(), entity.getUserId(), entity.getSubjectId(), EnumFileType.getTypeById(entity.getOriginalFormat()), entity.getSamplingRate(), entity.getFileTreePath(),entity.getLeadCount(), entity.getNumberOfPoints(), entity.getDateOfUpload(), entity.getAge(), entity.getGender(), entity.getDateOfRecording(), entity.getAduGain());
		}
		session.close();
		
		return ret;
	}
	
	/**
	 * Gets an array of the counts of annotations from the metadata storage
	 * database on a per lead basis.
	 * 
	 * @return - a comma separated list with the following columns<BR>
	 *         Lead number(term), Total annotation count, Manual annotations
	 *         count, Automated annotation count..
	 */
	@Override
	public int[][] getAnnotationCountPerLead(Long docId, int qtdLead){
		int[][] annPerLead ;
		
		Session session = sessionFactory.openSession();
		
		int[][] annPerLeadManual = _getAnnotationCount(true, docId, session);
		int[][] annPerLeadAuto = _getAnnotationCount(false, docId, session);
		
		annPerLead = new int[qtdLead][4];
		
		for(int i = 0; i < annPerLead.length; i++){
			
			int leadName = i + 1;
			
			if(annPerLeadAuto != null){
				for (int j = 0; j < annPerLeadAuto.length; j++) {
					if(annPerLeadAuto[j][0] == leadName){
						annPerLead[i][3] = annPerLeadAuto[j][1];
						break;
					}
				}
			}
			
			if(annPerLeadManual != null){
				for (int j = 0; j < annPerLeadManual.length; j++) {
					if(annPerLeadManual[j][0] == leadName){
						annPerLead[i][2] = annPerLeadManual[j][1];
						break;
					}
				}	
			}
						
			annPerLead[i][1] = annPerLead[i][3] + annPerLead[i][2];
			annPerLead[i][0] = leadName;
		}
		
		session.close();
		
		return annPerLead;
	}
	
	
	private int[][] _getAnnotationCount(boolean manual, Long docId, Session session){
		int[][] annPerLead  = null;
		
		StringBuilder hql = new StringBuilder();
		
		hql.append("select leadIndex, count(annotationId) from AnnotationInfo where documentRecordId = :docId and leadindex is not null and ");
		
		if(manual){
			hql.append(" createdBy = 'manual' ");
		}else{
			hql.append(" (createdBy <> 'manual' or createdBy is null) ");
		}
		
		hql.append(" group by leadIndex order by 1");
		
		Query q = session.createQuery(hql.toString()).setParameter("docId", docId);
		
		@SuppressWarnings("unchecked")
		List<Object[]> result = q.list();
		
		if(result != null && result.size() > 0){
			annPerLead = new int[result.size()][2];
			int i  = 0;
			for (Object[] objects : result) {
				annPerLead[i][0] = ((Integer)objects[0]) + 1;
				annPerLead[i][1] = ((Long)objects[1]).intValue();
				i++;
			}
		}
		return annPerLead;	
	}
	
	@Override
	public List<AnnotationDTO> getLeadAnnotationNode(Long userId, Long docId, Integer leadIndex){
		List<AnnotationDTO> annotations = null;
		
		Session session = sessionFactory.openSession();
		
		StringBuilder hql = new StringBuilder();
		
		hql.append("select a from DocumentRecord d ")
			.append("inner join d.annotationInfos as a ")
			.append("left  join a.startCoordinate as cStart ")
			.append("where d.documentRecordId = :docId and d.userId = :userId and a.leadIndex ");
		
		if(leadIndex != null){
			hql.append(" = :leadIndex ");	
		}else{
			hql.append(" is null ");
		}
		
		hql.append("order by cStart.xCoordinate ");
		
		Query q = session.createQuery(hql.toString());
		
		q.setParameter("docId", docId);
		q.setParameter("userId", userId);
		
		if(leadIndex != null){
			q.setParameter("leadIndex", leadIndex);
		}
		
		@SuppressWarnings("unchecked")
		List<AnnotationInfo> result = q.list();
		
		if(result != null && result.size() > 0 ){
			annotations = new ArrayList<AnnotationDTO>();
			
			for (AnnotationInfo entity : result) {
				annotations.add(new AnnotationDTO(entity));	
			}
		}
		
		session.close();
		
		return annotations;
	}
	
	@Override
	public AnnotationDTO getAnnotationById(Long userId, Long annotationId){
		AnnotationDTO annotation = null;
		
		Session session = sessionFactory.openSession();
		
		Query q = session.createQuery("select a from DocumentRecord d inner join d.annotationInfos a where a.annotationId = :annotationId and d.userId = :userId ");
		
		q.setParameter("annotationId", annotationId);
		q.setParameter("userId", userId);
		
		@SuppressWarnings("unchecked")
		List<AnnotationInfo> result = q.list();
		
		if(result != null && result.size() > 0 ){
			for (AnnotationInfo entity : result) {
				annotation = new AnnotationDTO(entity);
				break;
			}
		}
		
		session.close();
		
		return annotation;
	}
	

	@Override
	public boolean updateUploadStatus(long documentRecordId, EnumUploadState uploadPhase, Long time, Boolean status, String message) {
		
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		UploadStatus entity = null;
		try{
			entity = (UploadStatus) session.load(UploadStatus.class, documentRecordId);
			if(uploadPhase!= null){
				switch (uploadPhase) {
					case VALIDATION: 	entity.setValidationTime(time); break;
					case TRANSFER_READ: 	entity.setTransferReadTime(time); break;
					case WRITE: 		entity.setWriteTime(time); 		break;
					case ANNOTATION: 	entity.setAnnotationTime(time); break;
				}	
			}
		}catch(ObjectNotFoundException e){
			entity = new UploadStatus();
			entity.setDocumentRecordId(documentRecordId);
			if(uploadPhase!= null){
				switch (uploadPhase) {
					case VALIDATION: 	entity.setValidationTime(time); break;
					case TRANSFER_READ: 	entity.setTransferReadTime(time); break;
					case WRITE: 		entity.setWriteTime(time); 		break;
					case ANNOTATION: 	entity.setAnnotationTime(time); break;
				}
			}
		}
		
		if(status != null){
			entity.setStatus(status);
		}
		
		if(message != null){
			entity.setMessage(message);
		}
		
		session.persist(entity);
		
		session.getTransaction().commit();
		session.close();
		
		return true;
	}
	
	public List<UploadStatusDTO> getUploadStatusByUser(long userId){
		
		List<UploadStatusDTO> ret = null;
		
		Session session = sessionFactory.openSession();
		
		Query q = session.createQuery("select u " +
				"from DocumentRecord d " +
				"  inner join d.uploadStatus u " +
				"where d.userId = :userId " +
				"  and u.status is null " +
				"order by " +
				"  u.documentRecordId desc");
		
		q.setParameter("userId", userId);
		
		List<UploadStatus> entities = q.list();
		
		if(entities != null && !entities.isEmpty()){
			ret = new ArrayList<UploadStatusDTO>();
			
			for (UploadStatus uploadStatus : entities) {
				UploadStatusDTO dto = new UploadStatusDTO(uploadStatus.getDocumentRecordId(), uploadStatus.getAnnotationTime(), uploadStatus.getTransferReadTime(), uploadStatus.getValidationTime(), uploadStatus.getWriteTime(), uploadStatus.getStatus(), uploadStatus.getMessage());
				dto.setRecordName(uploadStatus.getDocumentRecord().getRecordName());
				ret.add(dto);
			}
		}
		
		session.close();
		return ret;
	}

	public List<UploadStatusDTO> getUploadStatusByUserAndDocId(long userId, Set<Long> docIds){
		
		List<UploadStatusDTO> ret = null;
		
		Session session = sessionFactory.openSession();
		
		StringBuilder hql = new StringBuilder();
		hql.append("select u from DocumentRecord d inner join d.uploadStatus u where d.userId = :userId ");
		
		if(docIds != null){
			hql.append(" and d.documentRecordId in (:docIds) ");
		}
		
		hql.append(" order by u.documentRecordId desc ");
	
		Query q = session.createQuery(hql.toString());
		q.setParameter("userId", userId);
		
		if(docIds != null){
			q.setParameterList("docIds", docIds);	
		}
		
		List<UploadStatus> entities = q.list();
		
		if(entities != null && !entities.isEmpty()){
			ret = new ArrayList<UploadStatusDTO>();
			
			for (UploadStatus uploadStatus : entities) {
				UploadStatusDTO dto = new UploadStatusDTO(uploadStatus.getDocumentRecordId(), uploadStatus.getAnnotationTime(), uploadStatus.getTransferReadTime(), uploadStatus.getValidationTime(), uploadStatus.getWriteTime(), uploadStatus.getStatus(), uploadStatus.getMessage());
				dto.setRecordName(uploadStatus.getDocumentRecord().getSubjectId());
				ret.add(dto);
			}
		}
		
		session.close();
		return ret;
	}
	
	@Override
	public boolean storeUploadStatus(UploadStatusDTO status) {
		
		boolean ret = false;
		
		if(status != null){
			Session session = sessionFactory.openSession();
			
			session.beginTransaction();
			
			UploadStatus entity;
			
			try{
				entity = (UploadStatus) session.load(UploadStatus.class, status.getDocumentRecordId());
				entity.setValidationTime(status.getValidationTime());
				entity.setTransferReadTime(status.getTransferReadTime());
				
				if(status.getWriteTime() != null){
					entity.setWriteTime(status.getWriteTime());
				}
				
				if(status.getAnnotationTime() != null){
					entity.setAnnotationTime(status.getAnnotationTime());
				}
				
				if(status.getStatus() != null){
					entity.setStatus(status.getStatus());
				}
				
				if(status.getMessage() != null){
					entity.setMessage(status.getMessage());
				}
				
			}catch(ObjectNotFoundException e){
				entity = new UploadStatus(status.getDocumentRecordId(), status.getAnnotationTime(), status.getTransferReadTime(), status.getValidationTime(), status.getWriteTime(), status.getStatus(), status.getMessage());
			}
			
			session.persist(entity);
			ret = true;
			
			session.getTransaction().commit();
			session.close();
		}
	
		return ret;
	}
	//*********** Algorithm database interaction methods **********************
	@Override
	public List<Service> getAvailableServiceList(long userId) {
		
		List<Service> ret = new ArrayList<Service>();
		try{
			Session session = sessionFactory.openSession();
			Query qs = session.createQuery(
					 "SELECT s "
					+"FROM  "
					+"  AWS_Service s "
					+"ORDER BY  "
					+"  s.serviceid");
			
			@SuppressWarnings("unchecked")
			List<AWS_Service> servList = qs.list();
			for (AWS_Service aws_S : servList) {
				Service serv = aws_S.getServiceBean();
				ret.add(serv);
			}
	
			session.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return ret;
	}
	

	/** Gets, via Hibernate, an Array of all the Algorithms the specified user has access to.
	 * @param userId - login id of the user, currently ignored but included because we are likely to need it here in the future.
	 * @author Michael Shipway
	 */
//	@Override
//	public List<Algorithm> getAvailableAlgorithmList(long userId) {
		
//		List<Algorithm> ret = new ArrayList<Algorithm>();
//		try{
//			Session session = sessionFactory.openSession();
//			Query qa = session.createQuery(
//					 "FROM " +
//					" AWS_Algorithm a ");
//								
//			@SuppressWarnings("unchecked")
//			List<Object> l = qa.list();
//			String qstring  = qa.getQueryString();
//			String[] aNamPa = qa.getNamedParameters();
			
//			for (int i = 0; i < l.size(); i++) {
//				Object[] obj = (Object[]) l.get(i);						
//				Algorithm alg = new Algorithm();
//				
//				alg.setId((Integer)obj[0]);
//				alg.setServiceID((Integer)obj[1]);
//				alg.setServiceMethod((String) obj[2]);
//				alg.setDisplayShortName((String) obj[3]);
//				alg.setToolTipDescription((String) obj[4]);
//				alg.setDisplayLongDescription((String)obj[5]);
//				// obj[6] should be the same as obj[1]
//				alg.setDisplayServiceName((String)obj[7]);
//				alg.setServiceName((String)obj[8]);
//				alg.setUrl((String)obj[9]);
//				alg.setURLreference("URLreference not in database yet.");
//				alg.setLicence("Licence not in database yet.");
//				alg.setVersionIdAlgorithm("VersionIdAlgorithm not in database yet.");
//				alg.setVersionIdWebService("VersionIdWebService not in database yet.");
//				alg.setWfdbAnnotationOutput(true);
////				alg.setParameters(getAlgorithmParameterArray(alg.getId()));
//				
//				ret.add(alg);
//			}
			
//			session.close();
//		}catch(Exception ex){
//			ex.printStackTrace();
//		}
//		return ret;
//	}
	
	public List<Algorithm> getAvailableAlgorithmList(long userId) {
		
		List<Algorithm> ret = new ArrayList<Algorithm>();
		try{
			Session session = sessionFactory.openSession();
			Query qa = session.createQuery(
					 "SELECT "
					+"  a.algorithmid,  "
					+"  a.serviceid,  "
					+"  a.serviceMethod,  "
					+"  a.uiName, "
					+"  a.shortDescription, "
					+"  a.completeDescription,  "
					+"  s.serviceid,  "
					+"  s.uiName,  "
					+"  s.wsName,  "
					+"  s.url  "
					+"FROM  "
					+"  AWS_Algorithm a,"
					+"  AWS_Service s "
					+"WHERE  "
					+"  a.serviceid = s.serviceid "
					+"ORDER BY  "
					+"  a.algorithmid");
								
			@SuppressWarnings("unchecked")
			List<Object> l = qa.list();
			
			for (int i = 0; i < l.size(); i++) {
				Object[] obj = (Object[]) l.get(i);						
				Algorithm alg = new Algorithm();
				
				alg.setId((Integer)obj[0]);
				alg.setServiceID((Integer)obj[1]);
				alg.setServiceMethod((String) obj[2]);
				alg.setDisplayShortName((String) obj[3]);
				alg.setToolTipDescription((String) obj[4]);
				alg.setDisplayLongDescription((String)obj[5]);
				// obj[6] should be the same as obj[1]
				alg.setDisplayServiceName((String)obj[7]);
				alg.setServiceName((String)obj[8]);
				alg.setUrl((String)obj[9]);
				alg.setURLreference("URLreference not in database yet.");
				alg.setLicence("Licence not in database yet.");
				alg.setVersionIdAlgorithm("VersionIdAlgorithm not in database yet.");
				alg.setVersionIdWebService("VersionIdWebService not in database yet.");
				alg.setWfdbAnnotationOutput(true);
				alg.setParameters(getAlgorithmParameterArray(alg.getId()));
				
				ret.add(alg);
			}
			
			session.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return ret;
	}

	
	/** Gets, via Hibernate, an ArrayList of all the Additional (optional) parameters which this specified algorithm can receive.
	 * @param algorithmId - primary key of the algorithm in the persistence database.
	 * @author Michael Shipway
	 */
	@Override
	public ArrayList<AdditionalParameters> getAlgorithmParameterArray(int algorithmId) {
		
		ArrayList<AdditionalParameters> ret = new ArrayList<AdditionalParameters>();
		try{
			Session session = sessionFactory.openSession();
			Query qap = session.createQuery(
					 "SELECT " +
					 " p.parameterid, " +
					 " p.uiName, " +
					 " p.shortDescription, " +
					 " p.completeDescription, " +
					 " p.defaultValue, " +
					 " p.required, " +
					 " p.multipleSelect, " +
					 " t.uiName, " +
					 " p.parameterValidationid, " +
					 " v.message, " +
					 " v.min, " +
					 " v.max, " +
					 " v.regex, " +
					 " v.validatorType " +
					 "FROM " +
					 " AWS_Parameter p," +
					 " AWS_ParameterType t, " +
					 " AWS_ParameterValidator v " +
					 "WHERE p.algorithmid= :algorithmId" + 
					 " AND p.parameterTypeid = t.parameterTypeid " +
					 " AND p.parameterValidationid = v.parameterValidationid " +
					 "ORDER BY p.parameterid");
			
			qap.setParameter("algorithmId", algorithmId);
			
			@SuppressWarnings("unchecked")
			List<Object> l = qap.list();
			for (int i = 0; i < l.size(); i++) {
				Object[] obj = (Object[]) l.get(i);						
				AdditionalParameters param = new AdditionalParameters();
				
				param.setId((Integer)obj[0]);
				param.setDisplayShortName((String) obj[1]);
				param.setToolTipDescription((String) obj[2]);
				param.setLongDescription((String) obj[3]);
				param.setParameterDefaultValue((String) obj[4]);
				param.setOptional(!((Boolean)obj[5]));
				param.setMultipleSelect((Boolean)obj[6]); // If true, allow multiple selections in a dropdown list. Only relevent for select or data_column parameter types.'
				param.setType((String) obj[7]);
				
				ParameterValidator val = new ParameterValidator();
				val.setId((Integer) obj[8]);
				val.setMessage((String) obj[9]);
				if(val.getId() > -1){ // id should be "-1" if there is no validator entry.
					val.setMin((Float) obj[10]);
					val.setMax((Float) obj[11]);
					val.setRegex((String) obj[12]);
					val.setType((String) obj[13]);
				}
				param.setValidator(val);
				ret.add(param);
			}
			session.close();
		}catch(HibernateException hex){
			hex.printStackTrace();
			System.out.println("********** Hibernate Exception in getAlgorithmParameterArray()");
			System.out.println(hex.getMessage());
			System.out.println(hex.getLocalizedMessage());			
			System.out.println("********** Hibernate Exception end ************");
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return ret;
	}
	


	
	/** Store a single Algorithm
	 * 
	 * @param uiName - Human friendly name to be used by the UI when listing services.
	 * @param serviceID - Foreign key to the "service" table, which will contain the URL and description meta-data for a single web service.  
	 * @param serviceMethod - Name of the method which executes the algorithm, within the webservice. e.g. "sqrsWrapperType2".
	 * @param shortDescription - Short summary description suitable for displaying as a tooltip.
	 * @param completeDescription - Complete description of the algorithm suitable for using in a manual/help file.
	 * @return
	 */
	@Override
	public Integer storeAlgorithm(String uiName, Integer serviceID, String serviceMethod, 
			String shortDescription,
			String completeDescription) {
			
		int algID=-1;
		
		try{
			Session session = sessionFactory.openSession();		
			session.beginTransaction();
			
			AWS_Algorithm alg = new AWS_Algorithm(uiName, serviceID, serviceMethod, shortDescription, completeDescription);
			
			session.persist(alg);
			
			session.getTransaction().commit();
			session.close();
			
			algID = alg.getAlgorithmid();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return algID;
	}

	/** Store a single Algorithm Parameter
	 * 
	 * @param param - Algorithm parameter to be stored in the database.
	 * @param iAlgorithmID - Primary key of the algorithm this parameter pertains to.
	 * @return
	 */
	@Override
	public Integer storeAlgorithmParameter(AdditionalParameters param, int iAlgorithmID) {
			
		int algID=-1;
		
		try{
			Session session = sessionFactory.openSession();		
			session.beginTransaction();
			
			ParameterValidator ParamVal = param.getValidator();
			int valID = -1;
			if(ParamVal != null){
				int validatorType = 0;
				if(ParamVal.getType().equalsIgnoreCase("in_range")) validatorType = 1;
				if(ParamVal.getType().equalsIgnoreCase("length")) validatorType = 2;
	
				AWS_ParameterValidator aws_val = new AWS_ParameterValidator(validatorType, 
								ParamVal.getMessage(), ParamVal.getMin(), ParamVal.getMax(), ParamVal.getRegex());
				session.persist(aws_val);
				session.getTransaction().commit();
				valID = aws_val.getParameterValidationid();
			}
			int paramType = 0;
			if(param.getType().contains("text")) paramType = 1;
			if(param.getType().contains("integer")) paramType = 2;
			if(param.getType().contains("float")) paramType = 3;
			if(param.getType().contains("boolean")) paramType = 4;
			if(param.getType().contains("select")) paramType = 5;
			if(param.getType().contains("drill_down")) paramType = 6;
			
			AWS_Parameter aws_param = new AWS_Parameter(param.getDisplayShortName(), 
							iAlgorithmID, 
							valID, 
							param.getDisplayShortName(), 
							param.getLongDescription(), 
							param.getParameterFlag(), 
							param.getParameterDefaultValue(), 
							paramType, 
							!param.getOptional(), 
							false);
			
			session.persist(aws_param);
			session.getTransaction().commit();
			System.out.println("Algorithm parameter database entry " + param.getDisplayShortName() + " wasCommitted(): " + session.getTransaction().wasCommitted());
			session.close();
			
			algID = aws_param.getAlgorithmid();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return algID;
	}
	
	
}
