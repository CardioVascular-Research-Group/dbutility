package edu.jhu.cvrg.dbapi.dto;

import java.util.Calendar;
import java.util.GregorianCalendar;

import edu.jhu.cvrg.dbapi.factory.exists.model.AnnotationData;
import edu.jhu.cvrg.dbapi.factory.hibernate.AnnotationInfo;

/*
 * NEW COLUMNS
 * 	timestamp
 * 
 * OLD COLUMNS IMPLEMENTED
 * 	subjectID
 * 	recordName
 * 	studyID
 * 	
 * 	NOT IMPLEMENTED
 * 		onsetLabel
 * 		onsetRestURL
 * 		offsetLabel
 * 		offsetRestURL
 * 	
 * */
public class AnnotationDTO {

	private Long annotationId;;
	private long userID;
	private long groupID; 
	private long companyID;
	private Long recordID;
	private String createdBy;
	private String annotationType;
	private String name;
	private String bioportalID;
	private String bioportalRef;
	private Integer lead;
	private String unitMeasurement;
	private String description;
	private String value;
	private Calendar timestamp;
	private Double startXcoord;
	private Double startYcoord;
	private Double endXcoord;
	private Double endYcoord;
	
	private String newStudyID;
	private String newRecordName;
	private String newSubjectID;

	public AnnotationDTO() {
	}
	
	
	public AnnotationDTO(long userID, long groupID, long companyID, Long recordID, String createdBy,
			String annotationType, String name, String bioportalID, String bioportalRef,
			Integer lead, String unitMeasurement, String description,
			String value, Calendar timestamp, Double startXcoord,
			Double startYcoord, Double endXcoord, Double endYcoord,
			String newStudyID, String newRecordName, String newSubjectID) {
		super();
		this.userID = userID;
		this.groupID = groupID;
		this.companyID = companyID;
		this.recordID = recordID;
		this.createdBy = createdBy;
		this.annotationType = annotationType;
		this.name = name;
		this.bioportalID = bioportalID;
		this.bioportalRef = bioportalRef;
		this.lead = lead;
		this.unitMeasurement = unitMeasurement;
		this.description = description;
		this.value = value;
		this.timestamp = timestamp;
		this.startXcoord = startXcoord;
		this.startYcoord = startYcoord;
		this.endXcoord = endXcoord;
		this.endYcoord = endYcoord;
		this.newStudyID = newStudyID;
		this.newRecordName = newRecordName;
		this.newSubjectID = newSubjectID;
	}
	
	public AnnotationDTO(AnnotationInfo entity){
		this(entity.getDocumentRecord().getUserId(), 0L, 0L, entity.getDocumentRecordId(), entity.getCreatedBy(), entity.getAnnotationType(), entity.getName(), entity.getBioportalId(), 
			 entity.getBioportalReference(), entity.getLeadIndex(), entity.getUnitOfMeasurement(), entity.getDescription(), entity.getValue(), null, null,null, null, null, 
		     String.valueOf(entity.getDocumentRecordId()), entity.getDocumentRecord().getRecordName(), entity.getDocumentRecord().getSubjectId());
		
		if(entity.getStartCoordinate() != null){
			this.setStartXcoord(entity.getStartCoordinate().getxCoordinate());
			this.setStartYcoord(entity.getStartCoordinate().getyCoordinate());
		}
		
		if(entity.getEndCoordinate() != null){
			this.setEndXcoord(entity.getEndCoordinate().getxCoordinate());
			this.setEndYcoord(entity.getEndCoordinate().getyCoordinate());
		}
		
		Calendar cal = new GregorianCalendar();
		cal.setTime( entity.getTimestamp());
		this.setTimestamp(cal);
		this.setAnnotationId(entity.getAnnotationId());
	}

	public long getUserID() {
		return userID;
	}
	public void setUserID(long userID) {
		this.userID = userID;
	}
	public Long getRecordID() {
		return recordID;
	}
	public void setRecordID(Long recordID) {
		this.recordID = recordID;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getAnnotationType() {
		return annotationType;
	}
	public void setAnnotationType(String annotationType) {
		this.annotationType = annotationType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBioportalRef() {
		return bioportalRef;
	}
	public void setBioportalRef(String bioportalRef) {
		this.bioportalRef = bioportalRef;
	}
	public Integer getLead() {
		return lead;
	}
	public void setLead(Integer lead) {
		this.lead = lead;
	}
	public String getUnitMeasurement() {
		return unitMeasurement;
	}
	public void setUnitMeasurement(String unitMeasurement) {
		this.unitMeasurement = unitMeasurement;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Calendar getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Calendar timestamp) {
		this.timestamp = timestamp;
	}
	public Double getStartXcoord() {
		return startXcoord;
	}
	public void setStartXcoord(Double startXcoord) {
		this.startXcoord = startXcoord;
	}
	public Double getStartYcoord() {
		return startYcoord;
	}
	public void setStartYcoord(Double startYcoord) {
		this.startYcoord = startYcoord;
	}
	public Double getEndXcoord() {
		return endXcoord;
	}
	public void setEndXcoord(Double endXcoord) {
		this.endXcoord = endXcoord;
	}
	public Double getEndYcoord() {
		return endYcoord;
	}
	public void setEndYcoord(Double endYcoord) {
		this.endYcoord = endYcoord;
	}
	public String getNewStudyID() {
		return newStudyID;
	}
	public void setNewStudyID(String newStudyID) {
		this.newStudyID = newStudyID;
	}
	public String getNewRecordName() {
		return newRecordName;
	}
	public void setNewRecordName(String newRecordName) {
		this.newRecordName = newRecordName;
	}
	public String getNewSubjectID() {
		return newSubjectID;
	}
	public void setNewSubjectID(String newSubjectID) {
		this.newSubjectID = newSubjectID;
	}

	
	public AnnotationData toExistsModel() {
		AnnotationData annData = new AnnotationData();
		
		annData.setUserID(String.valueOf(this.getUserID()));
		
		annData.setSubjectID(this.getNewSubjectID());
		annData.setDatasetName(this.getNewRecordName());
		annData.setStudyID(this.getNewStudyID());
		
		annData.setIsComment(isComment());
		
		annData.setAnnotation(this.getValue());
		annData.setComment(this.getDescription());
		
		annData.setConceptID(this.getBioportalID());
		annData.setConceptLabel(this.getName());
		annData.setConceptRestURL(this.getBioportalRef());
		
		annData.setCreator(this.getCreatedBy());
		
		annData.setLeadIndex(this.getLead());
		
		if(this.getStartXcoord() != null && this.getStartYcoord() != null){
			annData.setMilliSecondStart(this.getStartXcoord());
			annData.setMicroVoltStart(this.getStartYcoord());
			
			if(this.getEndXcoord() != null && this.getEndYcoord() != null && (this.getStartXcoord() != this.getEndXcoord() || this.getStartYcoord() != this.getEndYcoord())){
				annData.setMilliSecondEnd(this.getEndXcoord());
				annData.setMicroVoltEnd(this.getEndYcoord());
			}else{
				annData.setIsSinglePoint(true);
			}
		}
		
		
		annData.setUnit(this.getUnitMeasurement());
		return annData;
	}

	public long getGroupID() {
		return groupID;
	}

	public void setGroupID(long groupID) {
		this.groupID = groupID;
	}

	public long getCompanyID() {
		return companyID;
	}

	public void setCompanyID(long companyID) {
		this.companyID = companyID;
	}

	public String getBioportalID() {
		return bioportalID;
	}

	public void setBioportalID(String bioportalID) {
		this.bioportalID = bioportalID;
	}

	public Long getAnnotationId() {
		return annotationId;
	}

	public void setAnnotationId(Long annotationId) {
		this.annotationId = annotationId;
	}

	public boolean isComment() {
		return "COMMENT".equals(this.getAnnotationType());
	}
	
	public boolean isSinglePoint(){
		boolean ret = false;
		
		if(this.getStartXcoord() != null && this.getStartYcoord() != null){
			if(this.getEndXcoord() != null && this.getEndYcoord() != null && (this.getStartXcoord().equals(this.getEndXcoord()) || this.getStartYcoord().equals(this.getEndYcoord()))){
				ret = true;
			}
		}
		
		return ret;
	}
	
	public boolean isWholeLead(){
		return this.getStartXcoord() == null && this.getStartYcoord() == null && this.getEndXcoord() == null && this.getEndYcoord() == null;
	}
	
}
