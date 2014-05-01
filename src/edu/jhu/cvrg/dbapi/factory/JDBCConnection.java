package edu.jhu.cvrg.dbapi.factory;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
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
import edu.jhu.cvrg.dbapi.util.DBUtilityProperties;

public class JDBCConnection extends Connection{

	
	private java.sql.Connection conn;
	
	public JDBCConnection() {
		super(ConnectionType.JDBC);
	}

	@Override
	protected void init() {

		Properties connectionProps = new Properties();
	    connectionProps.put("user", props.getProperty(DBUtilityProperties.HIBERNATE_DB_USERNAME));
	    connectionProps.put("password", props.getProperty(DBUtilityProperties.HIBERNATE_DB_PASSWORD));

	    try {
	    	Class.forName(props.getProperty(DBUtilityProperties.HIBERNATE_DRIVER_CLASS));
			conn = DriverManager.getConnection(props.getProperty(DBUtilityProperties.HIBERNATE_DB_URL), connectionProps);
			System.out.println("Connected to database");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	
	}

	@Override
	public Long storeDocument(long userID, long groupID, long companyID,
			String recordName, String subjectID, int originalFormat,
			double samplingRate, String fileTreePath, int leadCount,
			int numPoints, Calendar dateUploaded, int age, String gender,
			Calendar dateRecorded, double aduGain, String studyID,
			int fileSize, String datatype, long[] filesId) {
		
		Long documentId = null;
		
		try {
			documentId = Long.valueOf(this.getMaxIdDocument());
			PreparedStatement docPstmt = conn.prepareStatement("insert into DATABASE_DOCUMENTRECORD values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			docPstmt.setLong(1, ++documentId);
			docPstmt.setString(2, recordName);
			docPstmt.setLong(3, userID);
			docPstmt.setString(4, subjectID);
			docPstmt.setInt(5, originalFormat);
			docPstmt.setDouble(6, samplingRate);
			docPstmt.setString(7, fileTreePath);
			docPstmt.setInt(8, leadCount);
			docPstmt.setInt(9, numPoints);
			if(dateUploaded != null){
				docPstmt.setTimestamp(10, new Timestamp(dateUploaded.getTimeInMillis()));
			}else{
				docPstmt.setTimestamp(10, null);
			}
			docPstmt.setInt(11, age);
			docPstmt.setString(12, gender);
			if(dateRecorded != null){
				docPstmt.setTimestamp(13, new Timestamp(dateRecorded.getTimeInMillis()));
			}else{
				docPstmt.setTimestamp(13, null);
			}
			docPstmt.setDouble(14, aduGain);
			
			docPstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return documentId;
	}

	@Override
	public Long storeAnnotations(Set<AnnotationDTO> annotSet) {
		
		Long counter = 0L;
		
		try{
			conn.setAutoCommit(false);
			for (AnnotationDTO annotationInfo : annotSet) {
				try{
					Long ret = _storeAnnotation(annotationInfo);
					
					if(ret != null){
						counter++;
						if(counter % 100 == 0){
							conn.commit();
						}
					}
				}catch (Exception e){
					e.printStackTrace();
				}
			}
			
		}catch (SQLException e){
			e.printStackTrace();
		}finally{
			try {
				conn.commit();
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return counter;
	}

	@Override
	public Long storeAnnotation(AnnotationDTO annotation) {

		Long annotationId = null;
		
		try {
			annotationId = _storeAnnotation(annotation);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return annotationId;
	}

	private Long _storeAnnotation(AnnotationDTO annotation) throws SQLException {
		Long annotationId;
		annotationId = Long.valueOf(this.getMaxIdAnnotation());
		
		Integer startId = addCoordinate(annotation.getStartXcoord(), annotation.getStartYcoord());
		Integer endId = addCoordinate(annotation.getEndXcoord(), annotation.getEndYcoord());
		
		PreparedStatement annPstmt = conn.prepareStatement("insert into DATABASE_ANNOTATIONINFO values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		
		annPstmt.setLong(1, ++annotationId);
		annPstmt.setString(2, annotation.getCreatedBy());
		annPstmt.setString(3, annotation.getAnnotationType());
		annPstmt.setString(4, annotation.getName());
		annPstmt.setString(5, annotation.getBioportalReferenceLink());
		annPstmt.setString(6, annotation.getBioportalClassId());
		annPstmt.setInt(7, annotation.getLead());
		
		annPstmt.setInt(8, startId);
		annPstmt.setInt(9, endId);
		
		annPstmt.setString(10, annotation.getUnitMeasurement());
		annPstmt.setString(11, annotation.getDescription());
		annPstmt.setString(12, annotation.getValue());
		annPstmt.setLong(13, annotation.getRecordID());
		if(annotation.getTimestamp() != null){
			annPstmt.setTimestamp(14, new Timestamp(annotation.getTimestamp().getTimeInMillis()));
		}else{
			annPstmt.setTimestamp(14, null);
		}
		
		annPstmt.executeUpdate();
		
		return annotationId;
	}

	private Integer addCoordinate(double x, double y) throws SQLException {
		
		Integer idCoord = getMaxIdCoordinate();
		
		PreparedStatement coordPstmt = conn.prepareStatement("insert into DATABASE_COORDINATE values(?,?,?)");
		
		coordPstmt.setInt(1, ++idCoord);
		coordPstmt.setDouble(2, x);
		coordPstmt.setDouble(3, y);
		
		coordPstmt.executeUpdate();
		
		return idCoord;
	}
	
	private Integer getMaxIdCoordinate() throws SQLException {
		
		PreparedStatement coordPstmt = conn.prepareStatement("select max(coordinateid) from DATABASE_COORDINATE");
		
		ResultSet r = coordPstmt.executeQuery();
		
		if(r.next()){
			return r.getInt(1);
		}
		
		return null;
	}
	
	private Integer getMaxIdAnnotation() throws SQLException {
		
		PreparedStatement coordPstmt = conn.prepareStatement("select max(annotationid) from DATABASE_ANNOTATIONINFO");
		
		ResultSet r = coordPstmt.executeQuery();
		
		if(r.next()){
			return r.getInt(1);
		}
		
		return null;
	}
	
	private Integer getMaxIdDocument() throws SQLException {
		
		PreparedStatement coordPstmt = conn.prepareStatement("select max(documentrecordid) from DATABASE_DOCUMENTRECORD");
		
		ResultSet r = coordPstmt.executeQuery();
		
		if(r.next()){
			return r.getInt(1);
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
