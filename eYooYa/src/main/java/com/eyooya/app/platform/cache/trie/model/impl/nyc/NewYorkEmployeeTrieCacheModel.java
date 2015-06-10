package com.eyooya.app.platform.cache.trie.model.impl.nyc;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.eyooya.app.common.api.google.service.BusinessLookUpService;
import com.eyooya.app.platform.cache.trie.model.impl.trie.AbstractTrieCacheModel;

@Component
@Scope("singleton")
public class NewYorkEmployeeTrieCacheModel extends AbstractTrieCacheModel implements NewYorkCache {

	
	@Autowired
	private BusinessLookUpService lookup;
	
	@Override
	@PostConstruct
	public void buildTrieModel() {		
		addWord("Itay Employee");
		addWord("Itay wiseman Employee");
		addWord("Gilor Wiseman Employee");
		addWord("Jonathan Wiseman Employee");
		addWord("Hangal Olami Employee");
		addWord("Mekodedet Employee");
		addWord("Joseph Yosef Employee");
	}

}
