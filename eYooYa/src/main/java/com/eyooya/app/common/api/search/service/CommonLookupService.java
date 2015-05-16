package com.eyooya.app.common.api.search.service;

import java.util.List;

public interface CommonLookupService {
	
	public List<String> findMatchedByPrefixAndTypes(String prefix, LookupEntitiesTypes type);

}
