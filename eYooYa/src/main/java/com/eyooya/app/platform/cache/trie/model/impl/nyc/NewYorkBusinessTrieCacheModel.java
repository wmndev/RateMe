package com.eyooya.app.platform.cache.trie.model.impl.nyc;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.eyooya.app.common.api.google.service.BusinessLookupService;
import com.eyooya.app.common.api.google.service.result.GooglePlace;
import com.eyooya.app.common.api.google.service.result.GoogleApiResponse;
import com.eyooya.app.platform.cache.trie.model.impl.trie.AbstractTrieCacheModel;

@Component
@Scope("singleton")
public class NewYorkBusinessTrieCacheModel extends AbstractTrieCacheModel implements NewYorkCache {

	
	@Autowired
	private BusinessLookupService lookup;
	
	@Override
	@PostConstruct
	public void buildTrieModel() {
		GoogleApiResponse res = lookup.lookInGoogleAPI();

		for (GooglePlace place : res.getResults()){
			addWord("Business :" + place.getName());
		}

	}

}
