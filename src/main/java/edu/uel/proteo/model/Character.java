package edu.uel.proteo.model;

public class Character extends Record {

	private String name;
	private String description;
	private Double minimum;
	private Double maximum;
	private Double optimum;
	
	public Character() {}

	public Character(String name, String description, Double minimum, Double maximum, Double optimum) {
		this.name = name;
		this.description = description;
		this.minimum = minimum;
		this.maximum = maximum;
		this.optimum = optimum;
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
}
