package com.eyooya.app.platform.cache.trie;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.eyooya.app.common.api.google.service.BusinessLookUpService;
import com.eyooya.app.common.api.google.service.result.GooglePlace;
import com.eyooya.app.common.api.google.service.result.PlcaesResponse;
import com.eyooya.app.platform.cache.trie.model.TrieNode;


public class TrieCacheManager {

	private TrieNode root;
	
	private final char ROOT_CHAR= ' ';
	

	private BusinessLookUpService lookup;
	

	private void test(){
		
		PlcaesResponse res = lookup.lookInGoogleAPI();
		System.out.println(res.getResults().size());
		for (GooglePlace place : res.getResults()){
			System.out.println(place.getName());
			addEntityName(place.getName());
			System.out.println("Entered:" + place.getName());
		}
		addEntityName("Itay Wiseman");
		addEntityName("Itay Wisemaffg gfg nrt");
		addEntityName("Itay Wisemangvcv");
		addEntityName("Itay fgfgfg");
		addEntityName("Itay fgbb  fdfg");
		addEntityName("Itay fg");
		addEntityName("Itay 546gfdg gfdg ");
		addEntityName("Itay fdgdfgdf ");
		addEntityName("Itay dfgdfg ");
		addEntityName("Itay Wisgfdggdfeman");
		addEntityName("Gilor Wiseman");
		addEntityName("Jonathan Wiseman");
		addEntityName("Hangal Olami");
		addEntityName("Mekodedet");
		addEntityName("Joseph Yosef");
	}

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
