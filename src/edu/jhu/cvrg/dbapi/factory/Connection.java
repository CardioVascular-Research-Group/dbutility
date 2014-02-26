package edu.jhu.cvrg.dbapi.factory;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import edu.jhu.cvrg.dbapi.dto.AnalysisJobDTO;
import edu.jhu.cvrg.dbapi.dto.AnnotationDTO;
import edu.jhu.cvrg.dbapi.dto.DocumentRecordDTO;
import edu.jhu.cvrg.dbapi.dto.FileInfoDTO;
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
	
	public abstract List<FileInfoDTO> getFileListByUser(long userId);
	public abstract List<FileInfoDTO> getFileListByDocumentRecordId(long docId);
	
	public abstract AnalysisJobDTO getAnalysisJobById(long jobId);
	public abstract DocumentRecordDTO getDocumentRecordById(long documentRecordId);
	public abstract int[][] getAnnotationCountPerLead(Long docId, int qtdLead);
	public abstract List<AnnotationDTO> getLeadAnnotationNode(Long userId, Long docId, int leadIndex);
	public abstract AnnotationDTO getAnnotationById(Long userId, Long annotationId);
	
	public ConnectionType getType() {
		return type;
	}
	public void setType(ConnectionType type) {
		this.type = type;
	}
	
}
