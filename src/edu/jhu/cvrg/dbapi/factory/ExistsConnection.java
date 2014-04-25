package edu.jhu.cvrg.dbapi.factory;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import edu.jhu.cvrg.dbapi.dto.AdditionalParameters;
import edu.jhu.cvrg.dbapi.dto.Algorithm;
import edu.jhu.cvrg.dbapi.dto.AnalysisJobDTO;
import edu.jhu.cvrg.dbapi.dto.AnnotationDTO;
import edu.jhu.cvrg.dbapi.dto.DocumentRecordDTO;
import edu.jhu.cvrg.dbapi.dto.FileInfoDTO;
import edu.jhu.cvrg.dbapi.dto.Service;
import edu.jhu.cvrg.dbapi.dto.UploadStatusDTO;
import edu.jhu.cvrg.dbapi.enums.EnumUploadState;
import edu.jhu.cvrg.dbapi.factory.exists.AnnotationUtility;
import edu.jhu.cvrg.dbapi.factory.exists.UploadUtility;
import edu.jhu.cvrg.dbapi.factory.exists.model.AnnotationData;
import edu.jhu.cvrg.dbapi.factory.exists.model.MetaContainer;
import edu.jhu.cvrg.dbapi.util.DBUtilityProperties;



public class ExistsConnection extends Connection{

	private UploadUtility uploadUtility = null;
	private AnnotationUtility annotationUtility = null;
	private SimpleDateFormat sdf;
	
	public ExistsConnection() {
		super(ConnectionType.EXISTS);
	}
	
	@Override
	protected void init() {
		sdf = new SimpleDateFormat("MM/dd/yyyy");		
	}
	
	@Override
	public Long storeDocument(long userID, long groupID, long companyID, String recordName, String subjectID, int originalFormat, double samplingRate, String fileTreePath, int leadCount, int numPoints, Calendar dateUploaded, int age, String gender, Calendar dateRecorded, double aduGain, String studyID, int fileSize, String datatype, long[] filesId) {
		/*
		 * NEW COLUMNS
		 * 	
		 * OLD COLUMNS IMPLEMENTED
		 * 		studyID	
		 * 		fileSize
		 * 		datatype
		 * 	
		 * */
		try {
			uploadUtility = this.getUploadUtility();
			
			MetaContainer metaData = new MetaContainer();
			
			if(dateUploaded != null){
				metaData.setDate(sdf.format(dateUploaded.getTime()));
			}
			
			if(dateRecorded != null){
				metaData.setFileDate(sdf.format(dateRecorded.getTime()));
			}
			
			metaData.setChannels(leadCount);
			metaData.setFileName(recordName);
			
			int location = recordName.indexOf(".");

			if (location != -1) {
				metaData.setRecordName(recordName.substring(0, location));
			} else {
				metaData.setRecordName(recordName);
			}
			
			metaData.setFileFormat(originalFormat);
			metaData.setNumberOfPoints(numPoints);
			metaData.setUserID(String.valueOf(userID));
			metaData.setSubjectAge(age);
			metaData.setSubjectGender(gender);
			metaData.setSubjectID(subjectID);
			metaData.setTreePath(fileTreePath);
			metaData.setFullFilePath(fileTreePath+File.separator);
			metaData.setSampFrequency(new Double(samplingRate).floatValue());
			
			metaData.setDatatype(datatype);
			metaData.setFileSize(fileSize);
			metaData.setStudyID(studyID);
			
			uploadUtility.storeFileMetaData(metaData);
			
			uploadUtility.close();
			return 1L;
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return 0L;
		
	}
	
	public Long storeAnnotation(AnnotationDTO annotation) {
		
		annotationUtility = this.getAnnotationUtility();
		
		AnnotationData annData = annotation.toExistsModel();
		
		Long ret = annotationUtility.storeLeadAnnotationNode(annData) ? 1L : null;
		
		annotationUtility.close();
		
		return ret;
	}

	public Long storeAnnotations(Set<AnnotationDTO> annotSet) {
		Long ret  = 0L;
		
		annotationUtility = this.getAnnotationUtility();
		
		for (AnnotationDTO annotation : annotSet) {
			AnnotationData annData = annotation.toExistsModel();
			
			if(annotationUtility.storeLeadAnnotationNode(annData)){
				ret++;
			} 
			
		}
		
		annotationUtility.close();
		
		return ret;
	}
	
	
	private UploadUtility getUploadUtility(){
		if(uploadUtility == null){
			uploadUtility = new UploadUtility(props.getProperty(DBUtilityProperties.EXISTS_DB_USER),
											  props.getProperty(DBUtilityProperties.EXISTS_DB_PASSWORD), 
											  props.getProperty(DBUtilityProperties.EXISTS_DB_URI),	
											  props.getProperty(DBUtilityProperties.EXISTS_DB_DRIVER),
											  props.getProperty(DBUtilityProperties.EXISTS_DB_MAIN_DATABASE));
		}
		
		if(uploadUtility.isClosed()){
			uploadUtility.initialize();
		}
		return uploadUtility;
	}
	
	
	private AnnotationUtility getAnnotationUtility(){
		if(annotationUtility == null){
			annotationUtility = new AnnotationUtility(props.getProperty(DBUtilityProperties.EXISTS_DB_USER),
													  props.getProperty(DBUtilityProperties.EXISTS_DB_PASSWORD), 
													  props.getProperty(DBUtilityProperties.EXISTS_DB_URI),	
													  props.getProperty(DBUtilityProperties.EXISTS_DB_DRIVER),
													  props.getProperty(DBUtilityProperties.EXISTS_DB_MAIN_DATABASE));
		}
		
		if(annotationUtility.isClosed()){
			annotationUtility.initialize();
		}
		return annotationUtility;
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

	@Override
	public List<Algorithm> getAvailableAlgorithmList(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer storeAlgorithm(String uiName, Integer serviceID,
			String serviceMethod, String shortDescription,
			String completeDescription) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer storeAlgorithmParameter(AdditionalParameters param,
			int iAlgorithmID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateUploadStatus(long documentRecordId, EnumUploadState uploadPhase, Long time, Boolean status, String message) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean storeUploadStatus(UploadStatusDTO status) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<UploadStatusDTO> getUploadStatusByUser(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UploadStatusDTO> getUploadStatusByUserAndDocId(long userId,
			Set<Long> docIds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Service> getAvailableServiceList(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<AdditionalParameters> getAlgorithmParameterArray(int algorithmId) {
		// TODO Auto-generated method stub
		return null;
	}


	
}
