package edu.uel.proteo.statistics;

import java.util.List;

public class Chart {

	private String type;
	private List<String> labels;
	private List<Dataset> datasets;
	
	public Chart() {}
	
	public Chart(String type, List<String> labels, List<Dataset> datasets) {
		this.type = type;
		this.labels = labels;
		this.datasets = datasets;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<String> getLabels() {
		return labels;
	}
	
	public void setLabels(List<String> labels) {
		this.labels = labels;
	}
	
	public List<Dataset> getDatasets() {
		return datasets;
	}
	
	public void setDatasets(List<Dataset> datasets) {
		this.datasets = datasets;
	}
}
