package com.eyooya.app.platform.utils.upload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;


import com.eyooya.app.common.api.google.service.BusinessLookupService;
import com.eyooya.app.common.api.google.service.GeocodingService;
import com.eyooya.app.common.api.google.service.result.GoogleApiResponse;

@Service
public class UploadServiceImpl implements UploadService {
	
	@Autowired
	private BusinessLookupService googleLookupService;
	
	@Autowired
	private GeocodingService gecodingService;
	
	
	@Override
	public void uploadData(String type, String [] nextLine) {
		
		String address = nextLine[3];
		Point point = gecodingService.addressGeocoding(address);	
		
		GoogleApiResponse response = googleLookupService.searchByText(nextLine[1], point, "100");
System.out.println(response);
		

	}

}
