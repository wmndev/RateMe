package com.eyooya.app.common.api.search.service.impl.solr;

import java.util.ArrayList;
import java.util.List;

import com.eyooya.app.platform.solr.core.base.document.MemberSolrDocument;
import com.eyooya.app.web.api.response.model.SearchResult;

public class SolrLookupResponseUtil{
	
	
	public static List<SearchResult> processResults(List<MemberSolrDocument> docs){
		List<SearchResult> result = new ArrayList<>(); 
		for (MemberSolrDocument doc : docs){
			result.add(new SearchResult(doc.getId(), doc.getName(), doc.getTitle(), doc.getCategory(), "resources/images/img1.jpeg"));
		}
		return result;
	}


}
