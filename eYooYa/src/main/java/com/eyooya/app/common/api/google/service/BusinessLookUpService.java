package com.eyooya.app.common.api.google.service;

import com.eyooya.app.common.api.google.service.result.PlcaesResponse;

public interface BusinessLookUpService {
	
	public PlcaesResponse lookInGoogleAPI();
	
	public Object lookInCacheAndDB();

}
