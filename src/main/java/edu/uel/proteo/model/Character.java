package edu.uel.proteo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "character")
public class Character {

	private String name;
	private String description;
	private Double minimum;
	private Double maximum;
	private Double optimum;
	private List<Sport> sports;
	
	public Character() {
		this.sports = new ArrayList<Sport>();
	}

	public Character(String name, String description, Double minimum, Double maximum, Double optimum, List<Sport> sports) {
		this.name = name;
		this.description = description;
		this.minimum = minimum;
		this.maximum = maximum;
		this.optimum = optimum;
		this.sports = sports;
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

	public List<Sport> getSports() {
		return sports;
	}

	public void setSports(List<Sport> sports) {
		this.sports = sports;
	}
}
