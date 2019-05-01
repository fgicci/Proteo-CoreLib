package edu.uel.proteo.statistics;

import java.util.HashMap;
import java.util.Map;

public class Chart {

	private String type;
	private ChartData data;
	private Map<String, Object> options;
	
	public Chart() {
		this.options = new HashMap<String, Object>() {
			{
				put("responsive", new Boolean(true));
			}
		};
	}
	
	public Chart(String type, ChartData data) {
		this();
		this.type = type;
		this.data = data;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ChartData getData() {
		return data;
	}

	public void setData(ChartData data) {
		this.data = data;
	}

	public Map<String, Object> getOptions() {
		return options;
	}

	public void setOptions(Map<String, Object> options) {
		this.options = options;
	}
}
