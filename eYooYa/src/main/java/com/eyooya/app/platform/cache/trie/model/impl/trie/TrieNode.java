package com.eyooya.app.platform.cache.trie.model.impl.trie;

import java.util.LinkedList;
import java.util.List;

public class TrieNode {
	
	private char character;
	private List<TrieNode> childs;
	private char type;
	
	public TrieNode(char charecter) {
		this.character = charecter;
		this.childs = new LinkedList<>();
	}
		
	public char getCharacter() {
		return character;
	}

	public List<TrieNode> getChilds() {
		return childs;
	}


	public void setCharacter(char character) {
		this.character = character;
	}


	public void setChilds(List<TrieNode> childs) {
		this.childs = childs;
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

}
