package com.XMLReader.entities.report;

import java.util.ArrayList;
import java.util.List;

public class ConvertReportPOJO {

	private String message;
	private List<String> queryNames = new ArrayList<String>();
	private String path;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public List<String> getQueryNames() {
		return queryNames;
	}
	public void setQueryNames(List<String> queryNames) {
		this.queryNames = queryNames;
	}
	public void addQueryNames(String queryNames) {
		this.queryNames.add(queryNames);
	}
}
