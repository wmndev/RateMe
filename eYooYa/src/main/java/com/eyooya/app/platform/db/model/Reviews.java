package com.eyooya.app.platform.db.model;

import java.util.ArrayList;
import java.util.List;

public class Reviews {
	
	//reviews (IDs) that the user wrote
	List<Long> put;
	
	//Reviewed in (IDs)
	List<Long> get;
	
	public Reviews(){
		this.put = new ArrayList<Long>();
		this.get = new ArrayList<>();
	}
		
	public List<Long> getPut() {
		return put;
	}

	public List<Long> getGet() {
		return get;
	}

	public void setPut(List<Long> put) {
		this.put = put;
	}

	public void setGet(List<Long> get) {
		this.get = get;
	}

}
