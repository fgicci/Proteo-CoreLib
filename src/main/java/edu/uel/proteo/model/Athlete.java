package edu.uel.proteo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "athlete")
public class Athlete extends Record {

	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	
//	@Column(name = "birth")
//	@Temporal(TemporalType.TIMESTAMP)
	@Transient
	private Date birth;
	
	public Athlete() {}
	
	public Athlete(String firstName, String lastName, Date birth) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birth = birth;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	@Override
	public String toString() {
		return "Athlete [firstName=" + firstName + ", lastName=" + lastName + ", birth=" + birth + ", key="
				+ super.toString() + "]";
	}
}
