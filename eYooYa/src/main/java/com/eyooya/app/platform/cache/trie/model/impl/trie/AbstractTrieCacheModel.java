package com.eyooya.app.platform.cache.trie.model.impl.trie;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import javax.annotation.PostConstruct;

import com.eyooya.app.platform.cache.trie.model.TreeCacheModel;

public abstract class AbstractTrieCacheModel implements TreeCacheModel {

	private TrieNode root;

	private final char ROOT_CHAR = ' ';

	@Override
	public List<String> search(String token) {
		if (token == null || token.isEmpty())
			return null;

		StringBuilder prefixBuilder = new StringBuilder();

		char[] chars = token.toCharArray();
		TrieNode start = root;
		boolean flag = false;
		for (char c : chars) {
			if (start.getChilds().size() > 0) {
				flag = false;
				for (TrieNode node : start.getChilds()) {
					if (Character.toUpperCase(node.getCharacter()) == Character
							.toUpperCase(c)) {
						prefixBuilder.append(node.getCharacter());
						start = node;
						flag = true;
						break;
					}
				}

			} else {
				flag = false;
				break;
			}
		}
		if (flag) {
			return getAllWords(start, prefixBuilder.toString());
		}

		return null;
	}

	@Override
	public synchronized TrieNode addWord(String word) {
		if (root == null) {
			root = new TrieNode(ROOT_CHAR);
		}
		TrieNode newNode = null;
		TrieNode start = root;
		char[] charecters = word.toCharArray();
		boolean found;
		for (char c : charecters) {
			found = false;
			if (start.getChilds().size() == 0) {
				newNode = new TrieNode(c);
				start.getChilds().add(newNode);
				start = newNode;
			} else {
				ListIterator<TrieNode> iterator = start.getChilds()
						.listIterator();
				TrieNode node = null;
				while (iterator.hasNext()) {
					node = iterator.next();
					if (Character.toUpperCase(node.getCharacter()) == Character.toUpperCase(c)) {
						start = node;
						found = true;
						break;
					}
				}
				if(!found){
					newNode = new TrieNode(c);
					iterator.add(newNode);
					start = newNode;
				}
			}
		}

		return newNode;
	}

	/**
	 * This method returns list string that can be formed from the given node
	 * 
	 * @param start
	 *            : Node from to start
	 * @param prefix
	 *            : String prefix that was formed till start node
	 * @return
	 */
	private List<String> getAllWords(TrieNode start, final String prefix) {
		List<String> list = new LinkedList<>();
		if (start.getChilds().size() == 0) {			
			list.add(prefix);		
		} else {
			for (TrieNode n : start.getChilds()) {
				list.addAll(getAllWords(n, prefix + n.getCharacter()));
			}
		}
		return list;

	}

	@Override
	public void removeWord(String word) {
		// TODO Auto-generated method stub

	}

	@PostConstruct
	public abstract void buildTrieModel();

}
