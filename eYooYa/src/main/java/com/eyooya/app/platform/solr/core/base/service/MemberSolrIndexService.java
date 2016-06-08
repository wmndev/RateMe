package com.eyooya.app.platform.solr.core.base.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.geo.Point;

import com.eyooya.app.platform.solr.core.base.document.MemberSolrDocument;

public interface MemberSolrIndexService {
	
    public void addToIndex(Long id, String name, String title, List<String> tags, String category, String type, float rating, Point location,
			String zip, String address, String country, String state);
    
    public void deleteFromIndex(Long id);
    
    public Page<MemberSolrDocument> getDocByTags(String searchTerm);
    

}
