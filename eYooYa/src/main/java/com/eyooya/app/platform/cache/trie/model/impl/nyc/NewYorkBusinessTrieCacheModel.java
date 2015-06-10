package com.eyooya.app.platform.cache.trie.model.impl.nyc;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.eyooya.app.common.api.google.service.BusinessLookUpService;
import com.eyooya.app.common.api.google.service.result.GooglePlace;
import com.eyooya.app.common.api.google.service.result.PlcaesResponse;
import com.eyooya.app.platform.cache.trie.model.impl.trie.AbstractTrieCacheModel;

@Component
@Scope("singleton")
public class NewYorkBusinessTrieCacheModel extends AbstractTrieCacheModel implements NewYorkCache {

	
	@Autowired
	private BusinessLookUpService lookup;
	
	@Override
	@PostConstruct
	public void buildTrieModel() {
		PlcaesResponse res = lookup.lookInGoogleAPI();

		for (GooglePlace place : res.getResults()){
			addWord(place.getName() + " Business");
		}

	}

}
