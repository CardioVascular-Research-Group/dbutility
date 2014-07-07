package edu.jhu.cvrg.dbapi.factory;

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

public class LiferayLocalConnection extends Connection{

	public LiferayLocalConnection() {
		super(ConnectionType.LIFERAY_LOCAL);
	}
	
	@Override
	protected void init() {
		// TODO Auto-generated method stub
		
	}
	

	@Override
	public Long storeDocument(long userID, long groupID, long companyID, String recordName, String subjectID, int originalFormat, double samplingRate, String fileTreePath, int leadCount, int numPoints, Calendar dateUploaded, int age, String gender, Calendar dateRecorded, double aduGain, String studyID, int fileSize, String datatype, long[] filesId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long storeAnnotations(Set<AnnotationDTO> annotSet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long storeAnnotation(AnnotationDTO annotation) {
		// TODO Auto-generated method stub
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
//
//
//	@Override
//	public boolean storeUploadStatus(UploadStatusDTO status) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public List<UploadStatusDTO> getUploadStatusByUser(long userId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//

	@Override
	public List<Service> getAvailableServiceList(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

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
	public ArrayList<AdditionalParameters> getAlgorithmParameterArray(int algorithmId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AnnotationDTO> getLeadAnnotationListConceptIDList(Long userId,
			Long docId, Integer leadIndex, String createdBy,
			String bioportalOntologyID, List<String> bioportalClassIdList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer updateAlgorithm(Integer algorithmid, String uiName,
			Integer serviceID, String serviceMethod, String shortDescription,
			String completeDescription) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer storeService(String uiName, String wsName, String url) {
		// TODO Auto-generated method stub
		return null;
	}
}
