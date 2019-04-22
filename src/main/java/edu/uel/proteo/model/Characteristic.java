package edu.uel.proteo.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "characteristic")
public class Characteristic extends Record {

	private String name;
	private String description;
	private Double minimum;
	private Double maximum;
	private Double optimum;
	
	@ManyToMany(mappedBy = "characteristics")
	@JsonIgnore
	private Set<Protocol> protocols;
	
	@ManyToMany
	@JoinTable(name = "characteristic_characteristic_state",
		joinColumns = @JoinColumn(name = "characteristic_id", referencedColumnName = "id", nullable = false, updatable = false),
		inverseJoinColumns = @JoinColumn(name = "characteristic_state_id", referencedColumnName = "id", nullable = false, updatable = false))
	@OrderBy("value ASC")
	private Set<CharacteristicState> states;
	
	public Characteristic() {}
	
	public Characteristic(String name, String description, Double minimum, Double maximum, Double optimum, Set<CharacteristicState> states) {
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

	public Set<Protocol> getProtocols() {
		return protocols;
	}

	public void setProtocols(Set<Protocol> protocols) {
		this.protocols = protocols;
	}

	public Set<CharacteristicState> getStates() {
		return states;
	}

	public void setStates(Set<CharacteristicState> states) {
		this.states = states;
	}
	
	public CharacteristicState addState(CharacteristicState state) {
		getStates().add(state);
		return state;
	}
	
	public CharacteristicState removeState(CharacteristicState state) {
		getStates().remove(state);
		return state;
	}
}
