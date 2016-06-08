package com.eyooya.app.common.api.google.service;

import org.springframework.data.geo.Point;


public interface GeocodingService {
	
	public Point addressGeocoding(String adress);

}
