package com.eyooya.app.common.api.search.service;

import java.util.HashMap;

public class InternalSearchRequest {
	
	
	private HashMap<SearchRequestObjectsEnum, Object> request;
	
	
	private InternalSearchRequest(LookupEntitiesTypes type){
		request = new HashMap<>();
		request.put(SearchRequestObjectsEnum.SEARCH_PARAMS, new HashMap<String, Object>());
		request.put(SearchRequestObjectsEnum.TYPE, type);
	}
	
	public static InternalSearchRequest generateRequest(LookupEntitiesTypes type){
		return new InternalSearchRequest(type);
	}
	
	@SuppressWarnings("unchecked")
	public InternalSearchRequest addSearchParam(String name, Object value){
		((HashMap<String, Object>)request.get(SearchRequestObjectsEnum.SEARCH_PARAMS)).put(name,  value);
		return this;
	}
	
	@SuppressWarnings("unchecked")
	public Object getParameterValue(String name){
		return ((HashMap<String, Object>)request.get(SearchRequestObjectsEnum.SEARCH_PARAMS)).get(name);
		
	}
	
	public Object getResponse(){
		return request.get(SearchRequestObjectsEnum.RESPONSE);
	}
	
	public void setResponse(Object response){
		request.put(SearchRequestObjectsEnum.RESPONSE, response);
	}
	
	public LookupEntitiesTypes getSearchType(){
		return (LookupEntitiesTypes)request.get(SearchRequestObjectsEnum.TYPE);
	}
	
}
