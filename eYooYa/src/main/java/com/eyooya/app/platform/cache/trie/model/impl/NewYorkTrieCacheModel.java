package com.eyooya.app.platform.cache.trie.model.impl;

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
public class NewYorkTrieCacheModel extends AbstractTrieCacheModel {

	
	@Autowired
	private BusinessLookUpService lookup;
	
	@Override
	@PostConstruct
	public void buildTrieModel() {
		PlcaesResponse res = lookup.lookInGoogleAPI();

		for (GooglePlace place : res.getResults()){
			addWord(place.getName());
		}
		
		addWord("Pyrmont");
		addWord("Wida");
		addWord("Widgfg nrt");
		addWord("Itay Wisemangvcv");
		addWord("Itay fgfgfg");
		addWord("Itay fgbb  fdfg");
		addWord("Itay fg");
		addWord("Itay 546gfdg gfdg");
		addWord("Itay fdgdfgdf");
		addWord("Itay dfgdfg");
		addWord("Itay Wisgfdggdfeman");
		addWord("Gilor Wiseman");
		addWord("Jonathan Wiseman");
		addWord("Hangal Olami");
		addWord("Mekodedet");
		addWord("Joseph Yosef");
	}

}
