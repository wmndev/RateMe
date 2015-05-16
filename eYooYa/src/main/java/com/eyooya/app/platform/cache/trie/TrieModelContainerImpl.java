package com.eyooya.app.platform.cache.trie;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.eyooya.app.platform.cache.trie.model.TrieCacheModel;

@Component
public class TrieModelContainerImpl implements TrieModelContainer {
	
	private HashMap<String,TrieCacheModel> cache;
	
	@Inject
	public TrieModelContainerImpl(List<TrieCacheModel> trieCacheModelImpls){
		cache = new HashMap<>();
		for (TrieCacheModel trie : trieCacheModelImpls)
			cache.put("1", trie);
		
	}

	@Override
	public TrieCacheModel getTrieCacheModel(String key) {
		return cache.get("1");
		
	}
	
	

}
