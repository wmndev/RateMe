package com.eyooya.app.web.api.response.model;

import java.io.Serializable;

public class SearchResult implements Serializable{

	private static final long serialVersionUID = 3012820260081987224L;

	private String name;
	
	private String nickName;
	
	private String description;
	
	private String pic;
	
	
	public SearchResult(String name, String nickName, String description, String pic){
		this.name = name;
		this.nickName = nickName;
		this.description = description;	
		this.pic = pic;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
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

}
