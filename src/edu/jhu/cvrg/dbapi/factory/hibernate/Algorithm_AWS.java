package edu.jhu.cvrg.dbapi.factory.hibernate;

//import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.mapping.Collection;


/**
 * The persistent class for the  Algorithm Web Service configuration "algorithm" database table.
 * 
 */
@Entity
@Table(name = "algorithm", schema = "public")
public class Algorithm_AWS implements java.io.Serializable  {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="algorithm_algorithmid_seq",sequenceName="algorithm_algorithmid_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="algorithm_algorithmid_seq")
	@Column(name="\"algorithmid\"", unique = true, nullable = false)
	private Integer algorithmid;

	@Column(name="\"serviceid\"")
	private Integer serviceid;

	@Column(name="\"completeDescription\"")
	private String completeDescription;

	@Column(name="\"serviceMethod\"")
	private String serviceMethod;

	@Column(name="\"shortDescription\"")
	private String shortDescription;

	@Column(name="\"uiName\"")
	private String uiName;

//	private List<AWS_Parameter> parameterset = new ArrayList<AWS_Parameter>();
//
////	private Collection parameterset;
//
////	@OneToMany(mappedBy = "algorithmref") //cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "algorithmref", targetEntity=AWS_Parameter.class)
//	@OneToMany(cascade=CascadeType.ALL)
//	@Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
//	public List<AWS_Parameter> getParameter() {
//		return this.parameterset;
//	}
//
//	public void setParameter(List<AWS_Parameter> passedParameters) {
//		this.parameterset = passedParameters;
//	}

	
	//bi-directional many-to-one association to AlgorithmPerson
//	@OneToMany(mappedBy="algorithm")
//	private List<AWS_AlgorithmPerson> algorithmPersons = new ArrayList<AWS_AlgorithmPerson>(0);

	
	public Algorithm_AWS() {
	}
	
	/** Initialization constructor.
	 * 
	 * @param uiName - Human friendly name to be used by the UI when listing services.
	 * @param serviceid - Foreign key to the "service" table, which will contain the URL and description meta-data for a single web service.  
	 * @param serviceMethod - Name of the method which executes the algorithm, within the webservice. e.g. "sqrsWrapperType2".
	 * @param shortDescription - Short summary description suitable for displaying as a tooltip.
	 * @param completeDescription - Complete description of the algorithm suitable for using in a manual/help file.
	 */
	public Algorithm_AWS(String uiName, Integer serviceid, String serviceMethod, 
			String shortDescription,
			String completeDescription) {
		setUiName(uiName);
		setServiceid(serviceid);
		setServiceMethod(serviceMethod);
		setShortDescription(shortDescription);
		setCompleteDescription(completeDescription);
	}

	public Integer getAlgorithmid() {
		return this.algorithmid;
	}

	public void setAlgorithmid(Integer algorithmid) {
		this.algorithmid = algorithmid;
	}

	public String getCompleteDescription() {
		return this.completeDescription;
	}

	public void setCompleteDescription(String completeDescription) {
		if(completeDescription.length()>5000) completeDescription = completeDescription.substring(0, 4995)+"...";
		this.completeDescription = completeDescription;
	}

	public Integer getServiceid() {
		return this.serviceid;
	}

	public void setServiceid(Integer serviceid) {
		this.serviceid = serviceid;
	}

	public String getServiceMethod() {
		return this.serviceMethod;
	}

	public void setServiceMethod(String serviceMethod) {
		this.serviceMethod = serviceMethod;
	}

	public String getShortDescription() {
		return this.shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		if(shortDescription.length()>150) shortDescription = shortDescription.substring(0, 145)+"...";
		this.shortDescription = shortDescription;
	}

	public String getUiName() {
		return this.uiName;
	}

	public void setUiName(String uiName) {
		this.uiName = uiName;
	}

//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "algorithm")
//	public List<AWS_AlgorithmPerson> getAlgorithmPersons() {
//		return this.algorithmPersons;
//	}
//	
//	public void setAlgorithmPersons(List<AWS_AlgorithmPerson> algorithmPersons) {
//		this.algorithmPersons = algorithmPersons;
//	}

}