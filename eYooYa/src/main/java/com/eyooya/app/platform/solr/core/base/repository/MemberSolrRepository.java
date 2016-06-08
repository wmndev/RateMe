package com.eyooya.app.platform.solr.core.base.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.geo.Point;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;

import com.eyooya.app.platform.solr.core.base.document.MemberSolrDocument;

public interface MemberSolrRepository extends SolrCrudRepository<MemberSolrDocument, String> {
	
//	@Query(name = "MemberSolrDocument.findByTags")
//	public List<MemberSolrDocument> findByTags(String searchTerm);
	
//	@Query(value="name:?0*", filters={"type:?1"})
//	public List<MemberSolrDocument> findByNamePrefixFilterType(String name, String type);
//	
//	@Query(value="name:?0*")
	public Page<MemberSolrDocument> findByTagsStartingWith(String tags, Pageable pageable);
	
	public Page<MemberSolrDocument> findByNameStartingWith(String name, Pageable pageable);
	
	@Query(value="name_t:?0*", filters={"{!geofilt pt=?1 sfield=locm_location d=?2}"})
	public Page<MemberSolrDocument> findByNameStartingWithFilterLocationWithin(String name, Point pt, double d, Pageable pageable);
	
}
