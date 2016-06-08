package com.eyooya.app.common.api.google.service;

import org.springframework.data.geo.Point;

import com.eyooya.app.common.api.google.service.result.GoogleApiResponse;

public interface BusinessLookupService {
	
	public GoogleApiResponse lookInGoogleAPI();
	
	public GoogleApiResponse searchByText(String query, Point point, String radius);
	
	public Object lookInCacheAndDB();

}
