package com.eyooya.app.platform.solr.core.base.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.solr.client.solrj.SolrServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eyooya.app.platform.solr.core.base.document.MemberSolrDocument;
import com.eyooya.app.platform.solr.core.base.repository.MemberSolrRepository;

@Service
public class MemberSolrIndexServiceImpl implements MemberSolrIndexService{
	
	@Resource
	private MemberSolrRepository repository;
	
	@Autowired
	private SolrServer solrServer;

	@Transactional
	@Override
	 public void addToIndex(Long id, String name, String title, List<String> tags, String category, String type, float rating, Point location,
				String zip, String address, String country, String state){
		List<Point> locations = new ArrayList<>();
		locations.add(location);
		MemberSolrDocument document = MemberSolrDocument.getBuilder(id, name,  title,  tags, category,  type,  rating,  locations,
				 zip,  address,  country,  state).build();
		repository.save(document);
		
	}

	@Transactional
	@Override
	public void deleteFromIndex(Long id) {
		repository.delete(id.toString());	
	}

	@Override
	public Page<MemberSolrDocument> getDocByTags(String searchTerm) {
		return repository.findByTagsStartingWith(searchTerm, new PageRequest(1,5));
	}

	
	
}
