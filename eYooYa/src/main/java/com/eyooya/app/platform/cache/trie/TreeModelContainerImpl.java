package com.eyooya.app.platform.cache.trie;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.eyooya.app.platform.cache.trie.model.TreeCacheModel;

@Component
public class TreeModelContainerImpl implements TreeModelContainer {
	
	private HashMap<String,TreeCacheModel> cache;
	
	@Inject
	public TreeModelContainerImpl(List<TreeCacheModel> treeCacheModelImpls){
		cache = new HashMap<>();
		for (TreeCacheModel tree : treeCacheModelImpls)
			cache.put("1", tree);
		
	}

	@Override
	public TreeCacheModel getTreeCacheModel(String key) {
		return cache.get("1");
		
	}
}
