package edu.uel.proteo.model;

import java.util.List;

import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "character")
@TypeAlias("character")
public class Character extends Record {

	private String name;
	private String description;
	private Double minimum;
	private Double maximum;
	private Double optimum;

	@Field("character_states")
	private List<CharacterState> states;
	
	@PersistenceConstructor
	public Character(String name, String description, Double minimum, Double maximum, Double optimum, List<CharacterState> states) {
		this.name = name;
		this.description = description;
		this.minimum = minimum;
		this.maximum = maximum;
		this.optimum = optimum;
		this.states = states;
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

	public Double getMinimum() {
		return minimum;
	}

	public void setMinimum(Double minimum) {
		this.minimum = minimum;
	}

	public Double getMaximum() {
		return maximum;
	}

	public void setMaximum(Double maximum) {
		this.maximum = maximum;
	}

	public Double getOptimum() {
		return optimum;
	}

	public void setOptimum(Double optimum) {
		this.optimum = optimum;
	}

	public List<CharacterState> getStates() {
		return states;
	}

	public void setStates(List<CharacterState> states) {
		this.states = states;
	}
}
