package com.eyooya.app.platform.cache.trie.model.impl.trie;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;


public class TrieCacheManager {

	private TrieNode root;
	
	private final char ROOT_CHAR= ' ';

	/**
	 * Add the give word into the Trie
	 * 
	 * @param word
	 */
	public synchronized TrieNode addEntityName(String entityName) {
		if (root == null) {
			root = new TrieNode(ROOT_CHAR);
		}
		TrieNode newNode = null;
		TrieNode start = root;
		char[] charecters = entityName.toCharArray();
		for (char c : charecters) {
			if (start.getChilds().size() == 0) {
				newNode = new TrieNode(c);
				start.getChilds().add(newNode);
				start = newNode;
			} else {
				ListIterator<TrieNode> iterator = start.getChilds().listIterator();
				TrieNode node = null;
				while (iterator.hasNext()) {
					node = iterator.next();
					if (node.getCharacter() >= c)
						break;
				}
				if (node.getCharacter() == c) {
					start = node;
				} else {
					newNode = new TrieNode(c);
					iterator.add(newNode);
					start = newNode;

				}
			}
		}
		
		return newNode;

	}

	/**
	 * This method takes and prefix string and returns all possible string that
	 * can be formed from the given prefix
	 * 
	 * @param prefix
	 * @return
	 */
	public List<String> search(String prefix) {
		if (prefix == null || prefix.isEmpty())
			return null;
		
		StringBuilder prefixBuilder = new StringBuilder();

		char[] chars = prefix.toCharArray();
		TrieNode start = root;
		boolean flag = false;
		for (char c : chars) {
			if (start.getChilds().size() > 0) {
				flag = false;
				for (TrieNode node : start.getChilds()) {
					if ( Character.toUpperCase(node.getCharacter()) == Character.toUpperCase(c)) {
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
		if (start.getChilds().size() == 0) {
			List<String> list = new LinkedList<>();
			list.add(prefix);
			return list;
		} else {
			List<String> list = new LinkedList<>();
			for (TrieNode n : start.getChilds()) {
				list.addAll(getAllWords(n, prefix + n.getCharacter()));
			}
			return list;
		}

	}

}
