package edu.uel.proteo.statistics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dataset {

	private String label;
	private List<Double> data;
	private List<String> backgroundColor = new ArrayList<>(Arrays.asList("rgba(105, 0, 132, .2)"));
	private List<String> borderColor = new ArrayList<>(Arrays.asList("rgba(200, 99, 132, .7)"));
	private Integer borderWidth = 2;
	
	public Dataset() {}

	public Dataset(String label, List<Double> data, List<String> backgroundColor, List<String> borderColor,
			Integer borderWidth) {
		this.label = label;
		this.data = data;
		this.backgroundColor = backgroundColor;
		this.borderColor = borderColor;
		this.borderWidth = borderWidth;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public List<Double> getData() {
		return data;
	}

	public void setData(List<Double> data) {
		this.data = data;
	}

	public List<String> getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(List<String> backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public List<String> getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(List<String> borderColor) {
		this.borderColor = borderColor;
	}

	public Integer getBorderWidth() {
		return borderWidth;
	}

	public void setBorderWidth(Integer borderWidth) {
		this.borderWidth = borderWidth;
	}
}
