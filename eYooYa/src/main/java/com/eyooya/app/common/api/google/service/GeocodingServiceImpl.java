package com.eyooya.app.common.api.google.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.eyooya.app.common.api.google.service.result.Location;
import com.eyooya.app.common.api.google.service.result.GoogleApiResponse;
import com.eyooya.app.common.api.google.type.PlaceLookupHttpURLs;

@Service
public class GeocodingServiceImpl implements GeocodingService {

	@Value("${server.api.key}")
	private String serverApiKey;
	
	@Override
	public Point addressGeocoding(String address) {
		RestTemplate restTemplate = new RestTemplate();
		GoogleApiResponse response =  restTemplate.getForObject(PlaceLookupHttpURLs.GEOCODING.uri(), GoogleApiResponse.class,address, serverApiKey);
		Location location = response.getResults().get(0).getGeometry().getLocation();
		return new Point (location.getLat().doubleValue(), location.getLng().doubleValue());
	}

}
