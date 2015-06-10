package com.eyooya.app.platform.cache.trie;

import java.util.List;

import com.eyooya.app.platform.cache.trie.model.TreeCacheModel;
import com.eyooya.app.platform.cache.trie.model.impl.trie.TreeCacheContainerKey;

public interface TreeModelContainer {
	
	public List<TreeCacheModel> getTreeCacheModel(TreeCacheContainerKey key);
	
	

}
