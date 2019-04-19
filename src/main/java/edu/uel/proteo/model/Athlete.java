package edu.uel.proteo.model;

import java.util.Date;

import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Document(collection = "athlete")
@TypeAlias("athlete")
public class Athlete extends Record {

	private String firstName;
	private String lastName;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private Date birth;
	
	public Athlete() {}
	
	@PersistenceConstructor
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
