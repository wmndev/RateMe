package com.eyooya.app.common.api.search.service.impl.trie;

import java.util.List;

public interface ThreadCompleteListener {
	void notifyOfThreadComplete(List<String> matches);
}
