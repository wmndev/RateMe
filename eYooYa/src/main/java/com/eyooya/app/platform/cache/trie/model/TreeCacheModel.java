package com.eyooya.app.platform.cache.trie.model;

import java.util.List;

import com.eyooya.app.platform.cache.trie.model.impl.trie.TrieNode;

public interface TreeCacheModel {
	
	
	public List<String> search(String token);
	
	public TrieNode addWord(String word);
	
	public void removeWord(String word);

}
