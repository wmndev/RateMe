package com.eyooya.app.common.api.search.service;


public interface CommonLookupService {
	
	public void findByName(InternalSearchRequest request);
	
	public void findByNameFilterByLocation(InternalSearchRequest request);
	
	public void findByNameFilterByZip(InternalSearchRequest request);
	
	public void findByNameFilterByCategoryAndLocation(InternalSearchRequest request);
	
	public void findByNameFilterByCategoryAndZip(InternalSearchRequest request);


}
