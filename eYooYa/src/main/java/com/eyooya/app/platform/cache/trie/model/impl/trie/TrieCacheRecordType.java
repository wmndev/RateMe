package com.eyooya.app.platform.cache.trie.model.impl.trie;

public enum TrieCacheRecordType {
	
	BUSINESS('a'), EMPLOYEE('b'), BUSINESS_TYPE('c');
	
	private char value;
	
	private TrieCacheRecordType(char value){
		this.value = value;
	}

	public char value(){
		return this.value;
	}
}
