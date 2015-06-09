package com.eyooya.app.common.api.search.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eyooya.app.platform.cache.trie.TreeModelContainer;

@Service
public class CommonLookupServiceImpl implements CommonLookupService {

	@Autowired
	private TreeModelContainer trieContainer;

	@Override
	public void findByTokenWithLocationAndType(InternalSearchRequest request) {

		switch (request.getSearchType()) {
		case BOTH_BUSINESS_AND_EMPLOYEE:
			handleResult(trieContainer.getTreeCacheModel("1").search((String)request.getParameterValue("token")), request);
			break;
		default:

		}
	}

	private void handleResult(List<String> searchResult, InternalSearchRequest request) {
		request.setResponse(searchResult);
		
	}
}
