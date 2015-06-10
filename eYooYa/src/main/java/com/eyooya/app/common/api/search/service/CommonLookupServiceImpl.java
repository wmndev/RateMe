package com.eyooya.app.common.api.search.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eyooya.app.platform.cache.trie.TreeModelContainer;
import com.eyooya.app.platform.cache.trie.model.TreeCacheModel;
import com.eyooya.app.platform.cache.trie.model.impl.trie.TreeCacheContainerKey;

@Service
public class CommonLookupServiceImpl implements CommonLookupService, ThreadCompleteListener {

	@Autowired
	private TreeModelContainer trieContainer;
	
	private int threadAliveCount;
	
	private List<String> results;

	@Override
	public void findByTokenWithLocationAndType(InternalSearchRequest request) {
		results = new ArrayList<>();
		switch (request.getSearchType()) {
		case BOTH_BUSINESS_AND_EMPLOYEE:
			List<TreeCacheModel> treeCacheModels = trieContainer.getTreeCacheModel(TreeCacheContainerKey.NYC);
			threadAliveCount = treeCacheModels.size();
			for (TreeCacheModel treeCache : treeCacheModels){
				TreeSearchThread thread = new TreeSearchThread(treeCache, (String)request.getParameterValue("token"));
				thread.addListener(this);
				thread.run();
			}
			handleResults(request);
			break;
		default:

		}
	}

	private void handleResults(InternalSearchRequest request) {
		while (threadAliveCount > 0){
		}
		request.setResponse(results);
		
	}

	@Override
	public void notifyOfThreadComplete(List<String> matches) {
		if (matches != null){
			results.addAll(matches);
		}
		threadAliveCount--;
		
		
		
	}
}
