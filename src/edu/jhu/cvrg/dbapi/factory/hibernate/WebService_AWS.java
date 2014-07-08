package edu.jhu.cvrg.dbapi.factory.hibernate;

import java.io.Serializable;
import javax.persistence.*;

import edu.jhu.cvrg.dbapi.dto.Service;

import java.util.List;


/**
 * The persistent class for the Algorithm Web Service configuration "service" database table.
 * 
 */
@Entity
@Table(name = "service", schema = "public")
public class WebService_AWS implements java.io.Serializable  {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="service_serviceID_seq_GENERATOR", sequenceName="service_serviceID_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="service_serviceID_seq_GENERATOR")
	@Column(name="\"serviceid\"")
	private Integer serviceid;

	@Column(name="\"uiName\"")
	private String uiName;

	@Column(name="\"wsName\"")
	private String wsName;

	@Column(name="\"wsUrl\"")
	private String url;

	//bi-directional many-to-one association to Algorithm
//	@OneToMany(mappedBy="service")
//	private List<AWS_Algorithm> algorithms;

	public WebService_AWS() {
	}

	public WebService_AWS(String UIName, String WSName, String URL){
		setUiName(UIName);
		setWsName(WSName);
		setUrl(URL);
	}
	
	
	public WebService_AWS(Service s){
		setUiName(s.getDisplayServiceName());
		setWsName(s.getServiceName());
		setUrl(s.getUrl());
		if(s.id != (-1)){
			setServiceid(s.id);
		}
	}
	
	public Integer getServiceid() {
		return this.serviceid;
	}

	public void setServiceid(Integer serviceID) {
		this.serviceid = serviceID;
	}

	public String getWsName() {
		return this.wsName;
	}

	public void setWsName(String name) {
		this.wsName = name;
	}

	public String getUiName() {
		return this.uiName;
	}

	public void setUiName(String uiName) {
		this.uiName = uiName;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
//
//	public List<AWS_Algorithm> getAlgorithms() {
//		return this.algorithms;
//	}
//
//	public void setAlgorithms(List<AWS_Algorithm> algorithms) {
//		this.algorithms = algorithms;
//	}

	/** returns the contents of this persistance class as "Service" bean for use by the program external to the dbUtility jar.
	 * 
	 * @return - "Service" bean
	 */
	public Service getServiceBean(){
		Service s = new Service();
		s.setId(getServiceid());
		s.setServiceName(getWsName());
		s.setDisplayServiceName(getUiName());
		s.setUrl(getUrl());
		
		return s;
	}
}