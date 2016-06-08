package com.eyooya.app.common.api.search.service.impl.solr;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import com.eyooya.app.common.api.search.service.BasicSearchRequestParams;
import com.eyooya.app.common.api.search.service.CommonLookupService;
import com.eyooya.app.common.api.search.service.InternalSearchRequest;
import com.eyooya.app.platform.solr.core.base.document.MemberSolrDocument;
import com.eyooya.app.platform.solr.core.base.repository.MemberSolrRepository;

@Service("solrLookup")
public class SolrLookupServiceImpl implements CommonLookupService {
	
	@Resource
	private MemberSolrRepository repository;

	@Override
	public void findByNameFilterByLocation(InternalSearchRequest request) {
		Point pt = (Point)request.getParameterValue(SolrSearchRequestParams.POINT.name());
		double distance = (Double)request.getParameterValue(SolrSearchRequestParams.DISTANCE_IN_KM.name());
		int page = (Integer)request.getParameterValue(BasicSearchRequestParams.PAGE_NUM.name());
		int SizeOfPage = (Integer)request.getParameterValue(BasicSearchRequestParams.SIZE_OF_RESULTS_IN_PAGE.name());
		String prefix = (String)request.getParameterValue(SolrSearchRequestParams.NAME.name());
		List<MemberSolrDocument> membersSolrDocs = repository.findByNameStartingWithFilterLocationWithin(prefix, new Point(pt.getX(), pt.getY()), distance, new PageRequest(page, SizeOfPage)).getContent();
		request.setResponse(SolrLookupResponseUtil.processResults(membersSolrDocs)) ;

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
		List<MemberSolrDocument> membersSolrDocs = repository.findByNameStartingWith((String)request.getParameterValue(SolrSearchRequestParams.NAME.name()), new PageRequest(0, 4)).getContent();	
		request.setResponse(SolrLookupResponseUtil.processResults(membersSolrDocs)) ;
	}


}
