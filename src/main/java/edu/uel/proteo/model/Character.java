package edu.uel.proteo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "character")
public class Character extends Record {

	private String name;
	private String description;
	private Double minimum;
	private Double maximum;
	private Double optimum;
	
	@ManyToMany(mappedBy = "characters")
	@JsonIgnore
	private List<Protocol> protocols;
	
	@ManyToMany
	@JoinTable(name = "character_character_states",
		joinColumns = @JoinColumn(name = "character_id"),
		inverseJoinColumns = @JoinColumn(name = "character_state_id"))
	private List<CharacterState> states;
	
	public Character(String name, String description, Double minimum, Double maximum, Double optimum, List<CharacterState> states) {
		super();
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
