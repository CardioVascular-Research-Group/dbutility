package edu.jhu.cvrg.dbapi.factory.hibernate;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the Algorithm Web Service configuration "person" database table.
 * 
 */
@Entity
@Table(name = "algorithmPerson", schema = "public")
public class AWS_AlgorithmPerson implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PERSON_PERSONID_GENERATOR", sequenceName="PERSON_PERSONID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PERSON_PERSONID_GENERATOR")
	@Column(name="\"personID\"")
	private Integer personID;

	

	public AWS_AlgorithmPerson() {
	}

	public Integer getPersonID() {
		return this.personID;
	}

	public void setPersonID(Integer personID) {
		this.personID = personID;
	}


}