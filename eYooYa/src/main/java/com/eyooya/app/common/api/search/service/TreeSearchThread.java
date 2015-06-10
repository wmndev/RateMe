package com.eyooya.app.common.api.search.service;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import com.eyooya.app.platform.cache.trie.model.TreeCacheModel;

public class TreeSearchThread implements Runnable {

	private final Set<ThreadCompleteListener> listeners = new CopyOnWriteArraySet<ThreadCompleteListener>();

	private TreeCacheModel treeCacheModel;
	private String token;

	private List<String> results;

	public TreeSearchThread(TreeCacheModel treeCacheModel, String token) {
		this.treeCacheModel = treeCacheModel;
		this.token = token;
	}

	public final void addListener(final ThreadCompleteListener listener) {
		listeners.add(listener);
	}

	public final void removeListener(final ThreadCompleteListener listener) {
		listeners.remove(listener);
	}

	private final void notifyListeners() {
		for (ThreadCompleteListener listener : listeners) {
			listener.notifyOfThreadComplete(results);
		}
	}

	@Override
	public final void run() {
		try {
			doRun();
		} finally {
			notifyListeners();
		}
	}

	private void doRun() {
		results = treeCacheModel.search(token);
	}

}
