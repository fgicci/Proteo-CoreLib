package edu.uel.proteo.model;

import java.util.Date;

public class Athlete {

	private String firstName;
	private String lastName;
	private Date birth;
	
	public Athlete() {
		
	}
	
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
}
