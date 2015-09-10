package com.eyooya.app.common.api.google.service;

import com.eyooya.app.common.api.google.service.result.GoogleApiResponse;

public interface BusinessLookUpService {
	
	public GoogleApiResponse lookInGoogleAPI();
	
	public Object lookInCacheAndDB();

}
