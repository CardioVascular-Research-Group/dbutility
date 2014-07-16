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
	
/*************************************************  Algorithm Web Services related methods *************************************/
	/** Gets a list of all web services found in the database.
	 * 	 
	 * @param userId - login id of the user, currently ignored but included because we are likely to need it here in the future.
	 * @author Michael Shipway
	 */
	public abstract List<Service> getAvailableServiceList(long userId);
	
	/** Gets, via Hibernate, a List of all the Algorithms the specified user has access to.
	 * @param userId - login id of the user, currently ignored but included because we are likely to need it here in the future.
	 * @return List of 'Algorithm' objects
	 * @author Michael Shipway
	 */
	public abstract List<Algorithm> getAvailableAlgorithmList(long userId);
	
	/** Store a single Algorithm
	 * 
	 * @param uiName - Human friendly name to be used by the UI when listing services.
	 * @param serviceID - Foreign key to the "service" table, which will contain the URL and description meta-data for a single web service.  
	 * @param serviceMethod - Name of the method which executes the algorithm, within the webservice. e.g. "sqrsWrapperType2".
	 * @param shortDescription - Short summary description suitable for displaying as a tooltip.
	 * @param completeDescription - Complete description of the algorithm suitable for using in a manual/help file.
	 * @return New Algorithm's ID (Primary key in the database)
	 * @author Michael Shipway
	 */
	public abstract Integer storeAlgorithm(                      String uiName, Integer serviceID, String serviceMethod, String shortDescription, String completeDescription);
	
	/** Update a single Algorithm
	 * 
	 * @param uiName - Human friendly name to be used by the UI when listing services.
	 * @param serviceID - Foreign key to the "service" table, which will contain the URL and description meta-data for a single web service.  
	 * @param serviceMethod - Name of the method which executes the algorithm, within the webservice. e.g. "sqrsWrapperType2".
	 * @param shortDescription - Short summary description suitable for displaying as a tooltip.
	 * @param completeDescription - Complete description of the algorithm suitable for using in a manual/help file.
	 * @return - primary key of the algorithm entry.
	 * @author Michael Shipway
	 */
	public abstract Integer updateAlgorithm(Integer algorithmid, String uiName, Integer serviceID, String serviceMethod, String shortDescription, String completeDescription);

	/** Store a single Algorithm Parameter
	 * 
	 * @param param - Algorithm parameter to be stored in the database.
	 * @param iAlgorithmID - Primary key of the algorithm this parameter pertains to.
	 * @return  Algorithm Parameter's ID (Primary key in the database)
	 * @author Michael Shipway
	 */
	public abstract Integer storeAlgorithmParameter(AdditionalParameters param, int iAlgorithmID);
	
	/** Update a single Algorithm Parameter
	 * 
	 * @param param - Algorithm parameter to be stored in the database.
	 * @param iAlgorithmID - Primary key of the algorithm this parameter pertains to.
	 * @return Algorithm Parameter's ID (Primary key in the database)
	 * @author Michael Shipway
	 */
	public abstract Integer updateAlgorithmParameter(AdditionalParameters param, int iAlgorithmID); 



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
	 * @author Michael Shipway
	 */
	public abstract List<AnnotationDTO> getLeadAnnotationListConceptIDList(Long userId,
			Long docId, Integer leadIndex, String createdBy,
			String bioportalOntologyID, List<String> bioportalClassIdList);


	/** Gets, via Hibernate, an ArrayList of all the Annotations of this document 
	 * which match the list of annotation names and were created by the specified createdBy.
	 * 
	 * @param userId - Id of the user who owns this data.
	 * @param docId - Document ID
	 * @param leadIndex - zero based lead index, as found in the original data file.  If null, then it gets only whole record annotations.
	 * @param createdBy - Either original file format identifier, algorithm identifier, or user ID in the case of manual annotations.
	 * @param nameList - A List of display names of the annotation, e.g. "S-_AMPL" (node name from a Schiller file)
	 * 
	 * @author Michael Shipway
	 */
	public abstract List<AnnotationDTO> getLeadAnnotationbyNameList(Long userId,
			Long docId, Integer leadIndex, String createdBy,
			List<String> nameList);
	

	/** Store a single Web Service
	 * 
	 * @param uiName - Human friendly name to be used by the UI when listing services.
	 * @param wsName - The web service’s name to be used in the URL when calling the service.   e.g. "physionetAnalysisService"
	 * @param url - URL of the server containing the web services e.g. http://128.220.76.170:8080/axis2/services. <BR>
	 *        This is used together with “service.wsName” and "algorithm.method”. <BR>
	 *        e.g. http://128.220.76.170:8080/axis2/services/physionetAnalysisService/sqrsWrapperType2
	 * @return - the primary key of the new entry in the service table.
	 * @author Michael Shipway
	 */
	public abstract Integer storeService(String uiName, String wsName, String url);

	/** Update a single Web Service
	 * 
	 * @param service - Service to be Updated in the database.
	 * @return service id (Primary key in database)
	 * @author Michael Shipway
	 */
	public abstract Integer updateWebService(Service service);

	/***************************************************************************************************************************/
}
