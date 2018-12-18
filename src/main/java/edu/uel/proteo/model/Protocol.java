package edu.uel.proteo.model;

import java.util.ArrayList;
import java.util.List;

public class Protocol {

	private String name;
	private String description;
	private ProtocolType type;
	private Sport sport;
	private List<Character> characters;
	
	public Protocol() {
		this.characters = new ArrayList<Character>();
	}

	public Protocol(String name, String description, ProtocolType type, Sport sport, List<Character> characters) {
		super();
		this.name = name;
		this.description = description;
		this.type = type;
		this.sport = sport;
		this.characters = characters;
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

	public List<Character> getCharacters() {
		return characters;
	}

	public void setCharacters(List<Character> characters) {
		this.characters = characters;
	}
}
