package com.eyooya.app.common.api.search.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eyooya.app.platform.cache.trie.TrieModelContainer;

@Service
public class CommonLookupServiceImpl implements CommonLookupService {

	@Autowired
	private TrieModelContainer trieContainer;

	@Override
	public List<String> findMatchedByPrefixAndTypes(String prefix,
			LookupEntitiesTypes type) {

		switch (type) {
		case BOTH_BUSINESS_AND_EMPLOYEE:
			return trieContainer.getTrieCacheModel("1").search(prefix);
		default:
			return null;

		}
	}
}
