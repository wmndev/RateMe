package com.eyooya.app.web.api.response.model;

import java.io.Serializable;

public class SearchResult implements Serializable{

	private static final long serialVersionUID = 3012820260081987224L;

	private String name;
	
	private String title;
	
	private String description;
	
	private String pic;
	
	private String id;
	
	
	public SearchResult(String id, String name, String title, String description, String pic){
		this.id = id;
		this.name = name;
		this.title = title;
		this.description = description;	
		this.pic = pic;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
