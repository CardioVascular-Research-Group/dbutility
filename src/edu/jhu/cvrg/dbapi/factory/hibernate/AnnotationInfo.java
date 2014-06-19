package edu.jhu.cvrg.dbapi.factory.hibernate;

// Generated Dec 7, 2013 2:31:41 PM by Hibernate Tools 4.0.0

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

/**
 * Annotationinfo generated by hbm2java
 */
@Entity
@Table(name = "annotationinfo", schema = "public")
public class AnnotationInfo implements java.io.Serializable {

	private static final long serialVersionUID = 1414386334714848736L;
	
	private Long annotationId;
	private Date timestamp;
	private Coordinate startCoordinate;
	private DocumentRecord documentRecord;
	private Coordinate endCoordinate;
	private String createdBy;
	private String annotationtype;
	private String name;
	private String bioportalOntology;
	private String bioportalReferenceLink;
	private String bioportalClassId;
	private Integer leadIndex;
	private Long startCoordinateId;
	private Long endCoordinateId;
	private String unitOfMeasurement;
	private String description;
	private String value;
	private Long documentRecordId;
	private Long analysisJobId;

	public AnnotationInfo() {
	}

	public AnnotationInfo(Long annotationid) {
		this.annotationId = annotationid;
	}

	public AnnotationInfo(Long annotationid, Long documentrecordid, Long startingcoordinateid, Long endingcoordinateid, String createdby, String annotationtype, String name, String bioportalreferenceLink,
						  String bioportalOntology, String bioportalid, Integer leadindex, String unitofmeasurement, String description, String value, Long analysisJobId) {
		this.annotationId = annotationid;
		this.documentRecordId = documentrecordid;
		this.startCoordinateId = startingcoordinateid;
		this.endCoordinateId = endingcoordinateid;
		this.createdBy = createdby;
		this.annotationtype = annotationtype;
		this.name = name;
		this.bioportalOntology = bioportalOntology;
		this.bioportalReferenceLink = bioportalreferenceLink;
		this.bioportalClassId = bioportalid;
		this.leadIndex = leadindex;
		this.unitOfMeasurement = unitofmeasurement;
		this.description = description;
		this.value = value;
		this.analysisJobId = analysisJobId;
	}
	
	public AnnotationInfo(Long annotationid,
			DocumentRecord documentrecord,
			Coordinate coordinateByStartingcoordinateid,
			Coordinate coordinateByEndingcoordinateid, String createdby,
			String annotationtype, String name, String bioportalReferenceLink,
			String bioportalOntology, String bioportalClassId, Integer leadindex, String unitofmeasurement,
			String description, String value, Long analysisJobId) {
		this.annotationId = annotationid;
		this.startCoordinate = coordinateByStartingcoordinateid;
		this.documentRecord = documentrecord;
		this.endCoordinate = coordinateByEndingcoordinateid;
		this.createdBy = createdby;
		this.annotationtype = annotationtype;
		this.name = name;
		this.bioportalReferenceLink = bioportalReferenceLink;
		this.bioportalOntology = bioportalOntology;
		this.bioportalClassId = bioportalClassId;
		this.leadIndex = leadindex;
		this.unitOfMeasurement = unitofmeasurement;
		this.description = description;
		this.value = value;
		this.analysisJobId = analysisJobId;
	}

	@Id
	@SequenceGenerator(name="annotationinfo_sequence",sequenceName="annotationinfo_sequence", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="annotationinfo_sequence")
	@Column(name = "annotationid", unique = true, nullable = false)
	public Long getAnnotationId() {
		return this.annotationId;
	}

	public void setAnnotationId(Long annotationid) {
		this.annotationId = annotationid;
	}

	@Version
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "timestamp", length = 29)
	public Date getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "startingcoordinateid", insertable = false, updatable = false)
	public Coordinate getStartCoordinate() {
		return this.startCoordinate;
	}

	public void setStartCoordinate(
			Coordinate coordinateByStartingcoordinateid) {
		this.startCoordinate = coordinateByStartingcoordinateid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "documentrecordid", insertable = false, updatable = false)
	public DocumentRecord getDocumentRecord() {
		return this.documentRecord;
	}

	public void setDocumentRecord(DocumentRecord documentrecord) {
		this.documentRecord = documentrecord;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "endingcoordinateid", insertable = false , updatable = false)
	public Coordinate getEndCoordinate() {
		return this.endCoordinate;
	}

	public void setEndCoordinate(
			Coordinate coordinateByEndingcoordinateid) {
		this.endCoordinate = coordinateByEndingcoordinateid;
	}

	@Column(name = "createdby", length = 75)
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdby) {
		this.createdBy = createdby;
	}

	/** Options are:
	 * "ANNOTATION" if a lead annotation
	 * "COMMENT" if a whole record annotation
	 * @return
	 */
	@Column(name = "annotationtype", length = 75)
	public String getAnnotationtype() {
		return this.annotationtype;
	}

	public void setAnnotationtype(String annotationtype) {
		this.annotationtype = annotationtype;
	}

	@Column(name = "name", length = 75)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "bioportalreferencelink", length = 200)
	public String getBioportalReferenceLink() {
		return this.bioportalReferenceLink;
	}

	public void setBioportalReferenceLink(String bioportalreferenceLink) {
		this.bioportalReferenceLink = bioportalreferenceLink;
	}

	@Column(name = "bioportalclassid", length = 200)
	public String getBioportalClassId() {
		return this.bioportalClassId;
	}

	public void setBioportalClassId(String bioportalid) {
		this.bioportalClassId = bioportalid;
	}
	
	@Column(name = "bioportalontology", length = 50)
	public String getBioportalOntology() {
		return bioportalOntology;
	}

	public void setBioportalOntology(String ontologyId) {
		this.bioportalOntology = ontologyId;
	}

	/** set to null if this is a whole record annotation **/
	@Column(name = "leadindex")
	public Integer getLeadIndex() {
		return this.leadIndex;
	}

	/** set to null if this is a whole record annotation **/
	public void setLeadIndex(Integer leadindex) {
		this.leadIndex = leadindex;
	}

	@Column(name = "startingcoordinateid")
	public Long getStartCoordinateId() {
		return this.startCoordinateId;
	}

	public void setStartCoordinateId(Long startingcoordinateid) {
		this.startCoordinateId = startingcoordinateid;
	}

	@Column(name = "endingcoordinateid")
	public Long getEndCoordinateId() {
		return this.endCoordinateId;
	}

	public void setEndCoordinateId(Long endingcoordinateid) {
		this.endCoordinateId = endingcoordinateid;
	}

	@Column(name = "unitofmeasurement", length = 75)
	public String getUnitOfMeasurement() {
		return this.unitOfMeasurement;
	}

	public void setUnitOfMeasurement(String unitofmeasurement) {
		this.unitOfMeasurement = unitofmeasurement;
	}

	@Column(name = "description", length = 75)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "value", length = 75)
	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Column(name = "documentrecordid")
	public Long getDocumentRecordId() {
		return this.documentRecordId;
	}

	public void setDocumentRecordId(Long documentrecordid) {
		this.documentRecordId = documentrecordid;
	}

	@Column(name = "analysisjobid")
	public Long getAnalysisJobId() {
		return analysisJobId;
	}

	public void setAnalysisJobId(Long analysisJobId) {
		this.analysisJobId = analysisJobId;
	}

}
