package edu.uel.proteo.model;

import java.util.Date;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Document(collection = "activity")
@TypeAlias("activity")
public class Activity extends Record {

	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private Date issueDate;
	
	@DBRef
	private Athlete athlete;
	
	@DBRef
	private Protocol protocol;
	
	@DBRef
	private Character character;
	
	private Double value;
	private String comments;
		
	public Activity() {}

	public Activity(Date issueDate, Athlete athlete, Protocol protocol, Character character, Double value, String comments) {
		this.issueDate = issueDate;
		this.athlete = athlete;
		this.protocol = protocol;
		this.character = character;
		this.value = value;
		this.comments = comments;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Athlete getAthlete() {
		return athlete;
	}

	public void setAthlete(Athlete athlete) {
		this.athlete = athlete;
	}

	public Protocol getProtocol() {
		return protocol;
	}

	public void setProtocol(Protocol protocol) {
		this.protocol = protocol;
	}

	public Character getCharacter() {
		return character;
	}

	public void setCharacter(Character character) {
		this.character = character;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
}
