package edu.jhu.cvrg.dbapi.factory.hibernate;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Algorithm Web Service configuration "person" database table.
 * 
 */
@Entity
public class AWS_Person implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PERSON_PERSONID_GENERATOR", sequenceName="PERSON_PERSONID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PERSON_PERSONID_GENERATOR")
	@Column(name="\"personID\"")
	private Integer personID;

	private String email;

	private String firstname;

	private String lastname;

	private String middlename;

	private String phonenumber;

//	//bi-directional many-to-one association to AlgorithmPerson
//	@OneToMany(mappedBy="person")
//	private List<AWS_AlgorithmPerson> algorithmPersons;
//
//	//bi-directional many-to-one association to OrganizationContact
//	@OneToMany(mappedBy="person")
//	private List<AWS_OrganizationContact> organizationContacts;

	public AWS_Person() {
	}

	public Integer getPersonID() {
		return this.personID;
	}

	public void setPersonID(Integer personID) {
		this.personID = personID;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMiddlename() {
		return this.middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getPhonenumber() {
		return this.phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

//	public List<AWS_AlgorithmPerson> getAlgorithmPersons() {
//		return this.algorithmPersons;
//	}
//
//	public void setAlgorithmPersons(List<AWS_AlgorithmPerson> algorithmPersons) {
//		this.algorithmPersons = algorithmPersons;
//	}
//
//	public List<AWS_OrganizationContact> getOrganizationContacts() {
//		return this.organizationContacts;
//	}
//
//	public void setOrganizationContacts(List<AWS_OrganizationContact> organizationContacts) {
//		this.organizationContacts = organizationContacts;
//	}

}