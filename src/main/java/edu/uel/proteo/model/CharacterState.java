package edu.uel.proteo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "character_states")
public class CharacterState extends Record {

	@ManyToOne(optional = false)
	@JoinColumn(name = "character_id")
	private Character character;
	
	private String name;
	private String description;
	private Double value;
	
	@ManyToMany(mappedBy = "states")
	@JsonIgnore
	List<Character> characters;
	
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
