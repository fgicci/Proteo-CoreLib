package edu.uel.proteo.model;

import javax.persistence.ManyToOne;

public class CharacterState extends Record {

	@ManyToOne(optional = false)
	private Character character;
	
	private String name;
	private String description;
	private Double value;
	
	public CharacterState() {}
	
	public CharacterState(Character character, String name, String description, Double value) {
		this.character = character;
		this.name = name;
		this.description = description;
		this.value = value;
	}

	public Character getCharacter() {
		return character;
	}

	public void setCharacter(Character character) {
		this.character = character;
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

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
}
