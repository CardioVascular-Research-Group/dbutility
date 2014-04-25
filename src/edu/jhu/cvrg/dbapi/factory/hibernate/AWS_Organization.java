package edu.jhu.cvrg.dbapi.factory.hibernate;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Entity;

import java.util.List;


/**
 * The persistent class for the Algorithm Web Service configuration "organization" database table.
 * 
 */
@Entity
public class AWS_Organization implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ORGANIZATION_ORGANIZATIONID_GENERATOR", sequenceName="ORGANIZATION_ORGANIZATIONID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ORGANIZATION_ORGANIZATIONID_GENERATOR")
	@Column(name="\"organizationID\"")
	private Integer organizationID;

	private String phonenumber;

	@Column(name="\"uiName\"")
	private String uiName;

	private String url;

	//bi-directional many-to-one association to OrganizationContact
//	@OneToMany(mappedBy="organization")
//	private List<AWS_OrganizationContact> organizationContacts;

	public AWS_Organization() {
	}

	public Integer getOrganizationID() {
		return this.organizationID;
	}

	public void setOrganizationID(Integer organizationID) {
		this.organizationID = organizationID;
	}

	public String getPhonenumber() {
		return this.phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
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

//	public List<AWS_OrganizationContact> getOrganizationContacts() {
//		return this.organizationContacts;
//	}
//
//	public void setOrganizationContacts(List<AWS_OrganizationContact> organizationContacts) {
//		this.organizationContacts = organizationContacts;
//	}

}