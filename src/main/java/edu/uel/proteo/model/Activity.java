	package edu.uel.proteo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "activity")
public class Activity extends Record {

	@Column(name = "issue_date")
	private Date issueDate;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "athlete_id")
	private Athlete athlete;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "protocol_id")
	private Protocol protocol;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "characteristic_id")
	private Characteristic characteristic;
	
	private Double value;
	private String comments;
		
	public Activity() {}

	public Activity(Date issueDate, Athlete athlete, Protocol protocol, Characteristic characteristic, Double value, String comments) {
		this.issueDate = issueDate;
		this.athlete = athlete;
		this.protocol = protocol;
		this.characteristic = characteristic;
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

	public Characteristic getCharacteristic() {
		return characteristic;
	}

	public void setCharacteristic(Characteristic characteristic) {
		this.characteristic = characteristic;
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
	
	public String getCharacteristicName() {
		return getCharacteristic().getName();
	}
}
