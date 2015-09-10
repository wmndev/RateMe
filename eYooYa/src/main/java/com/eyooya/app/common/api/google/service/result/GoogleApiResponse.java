package com.eyooya.app.common.api.google.service.result;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GoogleApiResponse implements Serializable{
	
	private List<GooglePlace> results;
	private String status;

	private static final long serialVersionUID = -5962894037650410357L;
	
	public List<GooglePlace> getResults() {
		return results;
	}
	public String getStatus() {
		return status;
	}
	public void setResults(List<GooglePlace> results) {
		this.results = results;
	}
	public void setStatus(String status) {
		this.status = status;
	}


}
