package com.eyooya.app.platform.cache.trie.model;

import java.util.List;

public interface TrieCacheModel {
	
	
	public List<String> search(String token);
	
	public TrieNode addWord(String word);
	
	public void removeWord(String word);

}
