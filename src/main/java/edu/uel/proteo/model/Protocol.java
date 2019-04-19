package edu.uel.proteo.model;

public class Protocol extends Record {

	private String name;
	private String description;
	
	private ProtocolType type;
	
	private Sport sport;
	
	public Protocol() {}

	public Protocol(String name, String description, ProtocolType type, Sport sport) {
		super();
		this.name = name;
		this.description = description;
		this.type = type;
		this.sport = sport;
	}

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

	public ProtocolType getType() {
		return type;
	}

	public void setType(ProtocolType type) {
		this.type = type;
	}

	public Sport getSport() {
		return sport;
	}

	public void setSport(Sport sport) {
		this.sport = sport;
	}
}
