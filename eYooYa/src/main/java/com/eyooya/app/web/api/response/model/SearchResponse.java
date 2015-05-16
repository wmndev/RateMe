package com.eyooya.app.web.api.response.model;

import java.io.Serializable;
import java.util.List;

public class SearchResponse implements Serializable {
	

	private static final long serialVersionUID = -1557949434272811703L;

	private String name;
	
	private short type;
	
	List<SearchResult> results;

	public List<SearchResult> getResults() {
		return results;
	}

	public void setResults(List<SearchResult> results) {
		this.results = results;
	}

	public String getName() {
		return name;
	}

	public short getType() {
		return type;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(short type) {
		this.type = type;
	}

}
