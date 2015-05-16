package com.eyooya.app.platform.cache.trie;

public enum TrieCacheRecordType {
	
	BUSINESS('a'), EMPLOYEE('b');
	
	private char value;
	
	private TrieCacheRecordType(char value){
		this.value = value;
	}

	public char value(){
		return this.value;
	}
	
	

}
