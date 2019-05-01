package edu.uel.proteo.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "trial")
public class Trial extends Record {

	private String name;
	private String description;
	
	@Column(name = "start_date")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date startDate;
	
	@Column(name = "due_date")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date dueDate;
	
	@ManyToMany
	@JoinTable(name = "trial_protocol",
		joinColumns = @JoinColumn(name = "trial_id", referencedColumnName = "id", nullable = false, updatable = false),
		inverseJoinColumns = @JoinColumn(name = "protocol_id", referencedColumnName = "id", nullable = false, updatable = false))
	@OrderBy("id ASC")
	private Set<Protocol> protocols;
	
	public Trial() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Set<Protocol> getProtocols() {
		return protocols;
	}

	public void setProtocols(Set<Protocol> protocols) {
		this.protocols = protocols;
	}
	
	public Protocol addProtocol(Protocol protocol) {
		getProtocols().add(protocol);
		return protocol;
	}
	
	public Protocol removeProtocol(Protocol protocol) {
		getProtocols().remove(protocol);
		return protocol;
	}
}
