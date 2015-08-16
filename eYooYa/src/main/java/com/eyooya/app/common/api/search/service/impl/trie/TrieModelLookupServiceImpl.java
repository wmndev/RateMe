package com.eyooya.app.common.api.search.service.impl.trie;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eyooya.app.common.api.search.service.CommonLookupService;
import com.eyooya.app.common.api.search.service.InternalSearchRequest;
import com.eyooya.app.platform.cache.trie.TreeModelContainer;
import com.eyooya.app.platform.cache.trie.model.TreeCacheModel;
import com.eyooya.app.platform.cache.trie.model.impl.trie.TreeCacheContainerKey;

@Service("TrieModelLookup")
public class TrieModelLookupServiceImpl implements CommonLookupService, ThreadCompleteListener {

	@Autowired
	private TreeModelContainer trieContainer;
	
	private int threadAliveCount;
	

	@Override
	public void findByNameFilterByLocation(InternalSearchRequest request) {
//		results = new LookupResponse<>();
		switch (request.getSearchType()) {
		case BUSINESS_AND_EMPLOYEE:
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
//		while (threadAliveCount > 0){
//		}
//		request.setResponse(results);
		
	}

	@Override
	public void notifyOfThreadComplete(List<String> matches) {
//		if (matches != null){
//			results.addAll(matches);
//		}
//		threadAliveCount--;
	}

	@Override
	public void findByNameFilterByZip(InternalSearchRequest request) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void findByNameFilterByCategoryAndLocation(
			InternalSearchRequest request) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void findByNameFilterByCategoryAndZip(InternalSearchRequest request) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void findByName(InternalSearchRequest request) {
		// TODO Auto-generated method stub
		
	}
}
