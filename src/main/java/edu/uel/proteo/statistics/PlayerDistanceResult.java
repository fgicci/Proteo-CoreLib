package edu.uel.proteo.statistics;

import java.util.Map;

public class PlayerDistanceResult {

	private String name;
	private Map<String, Double> values;
	private Double distance;
	
	public PlayerDistanceResult() {}

	public PlayerDistanceResult(String name, String protocolName, String sportName, Double distance, Double percentage, Map<String, Double> values) {
		this.name = name;
		this.distance = distance;
		this.values = values;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public Map<String, Double> getValues() {
		return values;
	}

	public void setValues(Map<String, Double> values) {
		this.values = values;
	}
}
