package com.eyooya.app.platform.cache.trie;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.eyooya.app.platform.cache.trie.model.TreeCacheModel;
import com.eyooya.app.platform.cache.trie.model.impl.nyc.NewYorkCache;
import com.eyooya.app.platform.cache.trie.model.impl.trie.TreeCacheContainerKey;

@Component
public class TreeModelContainerImpl implements TreeModelContainer {
	
	private HashMap<TreeCacheContainerKey,List<TreeCacheModel>> cache;
	
	@Inject
	public TreeModelContainerImpl(List<TreeCacheModel> treeCacheModelImpls){
		cache = new HashMap<>();
		for (TreeCacheModel tree : treeCacheModelImpls){
			if (tree instanceof NewYorkCache){
				insertTreeIntoCache(TreeCacheContainerKey.NYC,tree);
			}
		}	
	}

	private void insertTreeIntoCache(TreeCacheContainerKey key,
			TreeCacheModel tree) {
		List<TreeCacheModel> cacheModels = cache.get(key);
		if(cacheModels== null){
			cacheModels = new LinkedList<>();
		}
		cacheModels.add(tree);
		cache.put(key, cacheModels);
	}

	@Override
	public List<TreeCacheModel> getTreeCacheModel(TreeCacheContainerKey  key) {
		return cache.get(key);
		
	}
}
