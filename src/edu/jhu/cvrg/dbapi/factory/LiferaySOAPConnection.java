package edu.jhu.cvrg.dbapi.factory;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import edu.jhu.cvrg.dbapi.dto.AnalysisJobDTO;
import edu.jhu.cvrg.dbapi.dto.AnnotationDTO;
import edu.jhu.cvrg.dbapi.dto.DocumentRecordDTO;
import edu.jhu.cvrg.dbapi.dto.FileInfoDTO;
import edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.AnnotationInfoSoap;
import edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.CoordinateSoap;
import edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.model.DocumentRecordSoap;
import edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.service.http.AnnotationInfoServiceSoap;
import edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.service.http.AnnotationInfoServiceSoapServiceLocator;
import edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.service.http.CoordinateServiceSoap;
import edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.service.http.CoordinateServiceSoapServiceLocator;
import edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.service.http.DocumentRecordServiceSoap;
import edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.service.http.DocumentRecordServiceSoapServiceLocator;
import edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.service.http.FilesInfoServiceSoap;
import edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.service.http.FilesInfoServiceSoapServiceLocator;
import edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.service.http.Plugin_Database_AnnotationInfoServiceSoapBindingStub;
import edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.service.http.Plugin_Database_CoordinateServiceSoapBindingStub;
import edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.service.http.Plugin_Database_DocumentRecordServiceSoapBindingStub;
import edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.service.http.Plugin_Database_FilesInfoServiceSoapBindingStub;
import edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.service.http.Plugin_Database_UploadStatusServiceSoapBindingStub;
import edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.service.http.UploadStatusServiceSoap;
import edu.jhu.cvrg.dbapi.factory.liferay.soap.waveform.service.http.UploadStatusServiceSoapServiceLocator;


public class LiferaySOAPConnection extends Connection{

	public LiferaySOAPConnection() {
		super(ConnectionType.LIFERAY_SOAP);
	}
	
	@Override
	protected void init() {
		
	}
	
	@Override
	public Long storeDocument(long userID, long groupID, long companyID, String recordName, String subjectID, int originalFormat, double samplingRate, String fileTreePath, int leadCount, int numPoints, Calendar dateUploaded, int age, String gender, Calendar dateRecorded, double aduGain, String studyID, int fileSize, String datatype, long[] filesId) {
		
		DocumentRecordServiceSoap documentService = this.getDocumentService();
		FilesInfoServiceSoap filesInfoService = this.getFilesInfoService();
		
		try {
			
			
			DocumentRecordSoap doc = documentService.addDocumentRecord(userID, groupID, companyID, recordName, subjectID, String.valueOf(originalFormat), samplingRate, fileTreePath, leadCount, numPoints, dateUploaded, age, gender, dateRecorded, aduGain);
			
			if(filesId != null){
				for (long liferayFileId : filesId) {
					filesInfoService.addFilesInfo(userID, groupID, companyID, doc.getDocumentRecordID(), liferayFileId);	
				}
					
			}
						
			return doc.getDocumentRecordID();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	private DocumentRecordServiceSoap getDocumentService(){
		DocumentRecordServiceSoapServiceLocator locator = new DocumentRecordServiceSoapServiceLocator();
		
		try {
			DocumentRecordServiceSoap service = locator.getPlugin_Database_DocumentRecordService(new URL(props.getProperty("liferay.endpoint.url.db")+"Plugin_Database_DocumentRecordService"));
			
			((Plugin_Database_DocumentRecordServiceSoapBindingStub)service).setUsername(props.getProperty("liferay.ws.user"));
			((Plugin_Database_DocumentRecordServiceSoapBindingStub)service).setPassword(props.getProperty("liferay.ws.password"));
			
			return service;
			
		} catch (Exception e) {
			log.error("Error on DocumentService creation: "+e.getMessage());
		}
		
		return null;
	}
	
	private AnnotationInfoServiceSoap getAnnotationService(){
		AnnotationInfoServiceSoapServiceLocator locator = new AnnotationInfoServiceSoapServiceLocator();
		
		try {
			AnnotationInfoServiceSoap service = locator.getPlugin_Database_AnnotationInfoService(new URL(props.getProperty("liferay.endpoint.url.db")+"Plugin_Database_AnnotationInfoService"));
			
			((Plugin_Database_AnnotationInfoServiceSoapBindingStub)service).setUsername(props.getProperty("liferay.ws.user"));
			((Plugin_Database_AnnotationInfoServiceSoapBindingStub)service).setPassword(props.getProperty("liferay.ws.password"));
			
			return service;
			
		} catch (Exception e) {
			log.error("Error on AnnotationService creation: "+e.getMessage());
		}
		
		return null;
	}
	
	
	private CoordinateServiceSoap getCoordinateService(){
		CoordinateServiceSoapServiceLocator locator = new CoordinateServiceSoapServiceLocator();
		
		try {
			CoordinateServiceSoap service = locator.getPlugin_Database_CoordinateService(new URL(props.getProperty("liferay.endpoint.url.db")+"Plugin_Database_CoordinateService"));
			
			((Plugin_Database_CoordinateServiceSoapBindingStub)service).setUsername(props.getProperty("liferay.ws.user"));
			((Plugin_Database_CoordinateServiceSoapBindingStub)service).setPassword(props.getProperty("liferay.ws.password"));
			
			return service;
			
		} catch (Exception e) {
			log.error("Error on CoordinateService creation: "+e.getMessage());
		}
		
		return null;
	}
	
	private FilesInfoServiceSoap getFilesInfoService(){
		FilesInfoServiceSoapServiceLocator locator = new FilesInfoServiceSoapServiceLocator();
		
		try {
			FilesInfoServiceSoap service = locator.getPlugin_Database_FilesInfoService(new URL(props.getProperty("liferay.endpoint.url.db")+"Plugin_Database_FilesInfoService"));
			
			((Plugin_Database_FilesInfoServiceSoapBindingStub)service).setUsername(props.getProperty("liferay.ws.user"));
			((Plugin_Database_FilesInfoServiceSoapBindingStub)service).setPassword(props.getProperty("liferay.ws.password"));
			
			return service;
			
		} catch (Exception e) {
			log.error("Error on FilesInfoService creation: "+e.getMessage());
		}
		
		return null;
	}
	
	
	private UploadStatusServiceSoap getUploadStatusService(){
		UploadStatusServiceSoapServiceLocator locator = new UploadStatusServiceSoapServiceLocator();
		
		try {
			UploadStatusServiceSoap service = locator.getPlugin_Database_UploadStatusService(new URL(props.getProperty("liferay.endpoint.url.db")+"Plugin_Database_UploadStatusService"));
			
			((Plugin_Database_UploadStatusServiceSoapBindingStub)service).setUsername(props.getProperty("liferay.ws.user"));
			((Plugin_Database_UploadStatusServiceSoapBindingStub)service).setPassword(props.getProperty("liferay.ws.password"));
			
			return service;
			
		} catch (Exception e) {
			log.error("Error on FilesInfoService creation: "+e.getMessage());
		}
		
		return null;
	}

	@Override
	public Long storeAnnotations(Set<AnnotationDTO> annotSet) {
		AnnotationInfoServiceSoap annotationService = this.getAnnotationService();
		CoordinateServiceSoap coordinateService = this.getCoordinateService();
		
		Long ret = 0L;
		
		for (AnnotationDTO annotation : annotSet) {
			try {
				Long startCoordId = null; 
				Long endCoordId = null;
				if(annotation.getStartXcoord() != null && annotation.getStartYcoord() != null){
					CoordinateSoap startCoord = coordinateService.addCoordinate(annotation.getUserID(), annotation.getGroupID(), annotation.getCompanyID(), annotation.getStartXcoord(), annotation.getStartYcoord());
					startCoordId = startCoord.getPrimaryKey();
					endCoordId = startCoord.getPrimaryKey();
					
					if(annotation.getEndXcoord() != null && annotation.getEndYcoord() != null && (annotation.getStartXcoord() != annotation.getEndXcoord() || annotation.getStartYcoord() != annotation.getEndYcoord())){
						CoordinateSoap endCoord = coordinateService.addCoordinate(annotation.getUserID(), annotation.getGroupID(), annotation.getCompanyID(), annotation.getEndXcoord(), annotation.getEndYcoord());
						endCoordId = endCoord.getPrimaryKey();
					}
				}
				
				
				AnnotationInfoSoap ann = annotationService.addAnnotationInfo(annotation.getUserID(), annotation.getGroupID(), annotation.getCompanyID(), annotation.getRecordID(), annotation.getCreatedBy(), annotation.getAnnotationType(),
																			 annotation.getName(), annotation.getBioportalConceptID(), annotation.getBioportalRef(), annotation.getLead(), startCoordId, endCoordId, annotation.getUnitMeasurement(), 
																			 annotation.getDescription(), annotation.getValue(), annotation.getTimestamp());
				
				if(ann != null){
					ret++;
				}
				
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		
		
		return ret;
	}

	@Override
	public Long storeAnnotation(AnnotationDTO annotation) {
		AnnotationInfoServiceSoap annotationService = this.getAnnotationService();
		CoordinateServiceSoap coordinateService = this.getCoordinateService();
		try {
			Long startCoordId = null; 
			Long endCoordId = null;
			if(annotation.getStartXcoord() != null && annotation.getStartYcoord() != null){
				CoordinateSoap startCoord = coordinateService.addCoordinate(annotation.getUserID(), annotation.getGroupID(), annotation.getCompanyID(), annotation.getStartXcoord(), annotation.getStartYcoord());
				startCoordId = startCoord.getPrimaryKey();
				endCoordId = startCoord.getPrimaryKey();
				
				if(annotation.getEndXcoord() != null && annotation.getEndYcoord() != null && (annotation.getStartXcoord() != annotation.getEndXcoord() || annotation.getStartYcoord() != annotation.getEndYcoord())){
					CoordinateSoap endCoord = coordinateService.addCoordinate(annotation.getUserID(), annotation.getGroupID(), annotation.getCompanyID(), annotation.getEndXcoord(), annotation.getEndYcoord());
					endCoordId = endCoord.getPrimaryKey();
				}
			}
			
			AnnotationInfoSoap ann = annotationService.addAnnotationInfo(annotation.getUserID(), annotation.getGroupID(), annotation.getCompanyID(), annotation.getRecordID(), annotation.getCreatedBy(), annotation.getAnnotationType(),
																		 annotation.getName(), annotation.getBioportalConceptID(), annotation.getBioportalRef(), annotation.getLead(), startCoordId, endCoordId, annotation.getUnitMeasurement(), 
																		 annotation.getDescription(), annotation.getValue(), annotation.getTimestamp());
			
			return ann.getAnnotationID();
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean storeFilesInfo(long documentRecordId, long[] fileEntryId, Long analysisJobId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<FileInfoDTO> getFileListByUser(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long storeAnalysisJob(long documentRecord, int fileCount,
			int parameterCount, String serviceUrl, String serviceName,
			String serviceMethod, Date dateOfAnalysis, long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AnalysisJobDTO getAnalysisJobById(long jobId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocumentRecordDTO getDocumentRecordById(long documentRecordId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[][] getAnnotationCountPerLead(Long docId, int qtdLead) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FileInfoDTO> getFileListByDocumentRecordId(long docId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AnnotationDTO> getLeadAnnotationNode(Long userId, Long docId, Integer leadIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AnnotationDTO getAnnotationById(Long userId, Long annotationId) {
		// TODO Auto-generated method stub
		return null;
	}
}
