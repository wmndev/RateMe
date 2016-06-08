package com.eyooya.app.common.api.google.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.eyooya.app.common.api.google.service.result.GoogleApiResponse;
import com.eyooya.app.common.api.google.type.PlaceLookupHttpURLs;

/**
 * Use properties from google_api.properties
 */
@Service
public class BusinessLookUpServiceImpl implements BusinessLookupService {
	
	@Value("${server.api.key}")
	private String serverApiKey;
	

	@Override
	public GoogleApiResponse lookInGoogleAPI() {
		return getRestTemplate().getForObject(PlaceLookupHttpURLs.NEAR_BY.uri(), GoogleApiResponse.class,"-33.8670522","151.1957362","500", serverApiKey);
	}

	@Override
	public Object lookInCacheAndDB() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GoogleApiResponse searchByText(String query, Point point,
			String radius) {
		return getRestTemplate().getForObject(PlaceLookupHttpURLs.TEXT_QUERY.uri(), GoogleApiResponse.class, query, point.getX(),point.getY(),radius, serverApiKey);
	}
	
	private RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

}
