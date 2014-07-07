package edu.jhu.cvrg.dbapi.factory.hibernate;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Date;
import java.util.List;


/**
 * The persistent class for the Algorithm Web Service configuration "person" database table.
 * 
 */
@Entity
@Table(name = "algorithmreference", schema = "public")
public class AlgRef_AWS implements Serializable {
	private static final long serialVersionUID = 1L;

	//*****************************************

	@Id
	@SequenceGenerator(name="algorithmReferenceid_generator", sequenceName="algorithmreference_algorithmreferenceid_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="algorithmReferenceid_generator")
	@Column(name="\"algorithmreferenceid\"")
	private Integer algorithmreferenceid;

	@Column(name="\"algorithmid\"")
	private Integer algorithmid;

	@Column(name="\"versionAlgorithm\"")
	private String versionAlgorithm="n/a";

	@Column(name="\"dateAlgorithm\"")
	private Date dateAlgorithm;

	@Column(name="\"versionWebService\"")
	private String versionWebService="n/a";

	@Column(name="\"dateWebService\"")
	private Date dateWebService;

	@Column(name="\"licence\"")
	private String licence="n/a";

	@Column(name="\"referenceurl\"")
	private String referenceurl="n/a";

	public AlgRef_AWS() {
	}

	public AlgRef_AWS(Integer Algid) {
		setAlgorithmid(Algid);
	}

	public Integer getAlgorithmReferenceid() {
		return this.algorithmreferenceid;
	}

	public void setAlgorithmReferenceid(Integer algorithmRefid) {
		this.algorithmreferenceid = algorithmRefid;
	}

	public Integer getAlgorithmid() {
		return algorithmid;
	}

	public void setAlgorithmid(Integer algorithmid) {
		this.algorithmid = algorithmid;
	}

	public String getVersionAlgorithm() {
		return versionAlgorithm;
	}

	public void setVersionAlgorithm(String versionAlgorithm) {
		this.versionAlgorithm = versionAlgorithm;
	}

	public Date getDateAlgorithm() {
		return dateAlgorithm;
	}

	public void setDateAlgorithm(Date dateAlgorithm) {
		this.dateAlgorithm = dateAlgorithm;
	}

	public String getVersionWebService() {
		return versionWebService;
	}

	public void setVersionWebService(String versionWebService) {
		this.versionWebService = versionWebService;
	}

	public Date getDateWebService() {
		return dateWebService;
	}

	public void setDateWebService(Date dateWebService) {
		this.dateWebService = dateWebService;
	}

	public String getLicence() {
		return licence;
	}

	public void setLicence(String licence) {
		this.licence = licence;
	}

	public String getReferenceurl() {
		return referenceurl;
	}

	public void setReferenceurl(String referenceURL) {
		this.referenceurl = referenceURL;
	}



}