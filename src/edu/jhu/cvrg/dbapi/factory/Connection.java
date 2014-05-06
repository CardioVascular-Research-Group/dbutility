package edu.jhu.cvrg.dbapi.factory;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import edu.jhu.cvrg.dbapi.dto.AdditionalParameters;
import edu.jhu.cvrg.dbapi.dto.Algorithm;
import edu.jhu.cvrg.dbapi.dto.AnalysisJobDTO;
import edu.jhu.cvrg.dbapi.dto.AnnotationDTO;
import edu.jhu.cvrg.dbapi.dto.DocumentRecordDTO;
import edu.jhu.cvrg.dbapi.dto.FileInfoDTO;
import edu.jhu.cvrg.dbapi.dto.Service;
import edu.jhu.cvrg.dbapi.dto.UploadStatusDTO;
import edu.jhu.cvrg.dbapi.enums.EnumUploadState;
import edu.jhu.cvrg.dbapi.util.DBUtilityProperties;

public abstract class Connection {

	protected Logger log = null;
	protected DBUtilityProperties props;
	
	private ConnectionType type;
	
	
	public Connection(ConnectionType type) {
		this.type = type;
		this.log = Logger.getLogger(this.getClass());
		this.props = DBUtilityProperties.getInstance();
		init();
	}

	protected abstract void init();
	
	public abstract Long storeDocument(long userID, long groupID, long companyID, String recordName, String subjectID, int originalFormat, double samplingRate, String fileTreePath, int leadCount, int numPoints, Calendar dateUploaded, int age, String gender, Calendar dateRecorded, double aduGain, String studyID, int fileSize, String datatype, long[] filesId);
	public abstract Long storeAnnotations(Set<AnnotationDTO> annotSet);
	public abstract Long storeAnnotation(AnnotationDTO annotation);
	public abstract boolean storeFilesInfo(long documentRecordId, long[] fileEntryId, Long analysisJobId);
	public abstract Long storeAnalysisJob(long documentRecord, int fileCount, int parameterCount, String serviceUrl, String serviceName, String serviceMethod, Date dateOfAnalysis, long userId);
	public abstract boolean updateUploadStatus(long documentRecordId, EnumUploadState uploadPhase, Long time, Boolean status, String message);
	public abstract boolean storeUploadStatus(UploadStatusDTO status);
	public abstract List<UploadStatusDTO> getUploadStatusByUser(long userId);
	public abstract List<UploadStatusDTO> getUploadStatusByUserAndDocId(long userId, Set<Long> docIds);
	
	
	public abstract List<FileInfoDTO> getFileListByUser(long userId);
	public abstract List<FileInfoDTO> getFileListByDocumentRecordId(long docId);
	
	public abstract AnalysisJobDTO getAnalysisJobById(long jobId);
	public abstract DocumentRecordDTO getDocumentRecordById(long documentRecordId);
	public abstract int[][] getAnnotationCountPerLead(Long docId, int qtdLead);
	public abstract List<AnnotationDTO> getLeadAnnotationNode(Long userId, Long docId, Integer leadIndex);
	public abstract AnnotationDTO getAnnotationById(Long userId, Long annotationId);
	
	public ConnectionType getType() {
		return type;
	}
	public void setType(ConnectionType type) {
		this.type = type;
	}

	public abstract List<Service> getAvailableServiceList(long userId);
	
	/** Gets, via Hibernate, an Array of all the Algorithms the specified user has access to.
	 * @param userId - login id of the user, currently ignored but included because we are likely to need it here in the future.
	 * @author Michael Shipway
	 */
	public abstract List<Algorithm> getAvailableAlgorithmList(long userId);
	public abstract Integer storeAlgorithm(String uiName, Integer serviceID, String serviceMethod, String shortDescription, String completeDescription);
	public abstract Integer storeAlgorithmParameter(AdditionalParameters param, int iAlgorithmID);

	/** Gets, via Hibernate, an ArrayList of all the Additional (optional) parameters which this specified algorithm can receive.
	 * @param algorithmId - primary key of the algorithm in the persistence database.
	 * @author Michael Shipway
	 */
	public abstract ArrayList<AdditionalParameters> getAlgorithmParameterArray(int algorithmId);

	/** Gets, via Hibernate, an ArrayList of all the Annotations of this document 
	 * which match the list of bioportalClassIds and where created by the specified createdBy.
	 * 
	 * @param userId - Id of the user who owns this data.
	 * @param docId - Document ID
	 * @param leadIndex - zero based lead index, as found in the original data file.
	 * @param createdBy - Either original file format identifier, algorithm identifier, or user ID in the case of manual annotations.
	 * @param bioportalOntologyID - Identifier of the Ontology, e.g. "ECGT"
	 * @param bioportalClassIdList - A List of bioportalClassId string, e.g. "ECGOntology:ECG_000000243".
	 * 
	 * @author Michael Shipway
	 */
	public abstract List<AnnotationDTO> getLeadAnnotationListConceptIDList(Long userId,
			Long docId, Integer leadIndex, String createdBy,
			String bioportalOntologyID, List<String> bioportalClassIdList);

}
