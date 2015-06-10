package com.eyooya.app.common.api.search.service;

import com.eyooya.app.platform.cache.trie.model.TreeCacheModel;

public class TreeSearchThread implements Runnable {

	private TreeCacheModel treeCacheModel;
	private String token;
	
	public TreeSearchThread(TreeCacheModel treeCacheModel, String token){
		this.treeCacheModel = treeCacheModel;
		this.token = token;
	}
	
	@Override
	public void run() {
		treeCacheModel.search(token);

	}

}
