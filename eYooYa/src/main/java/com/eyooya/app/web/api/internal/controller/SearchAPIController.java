package com.eyooya.app.web.api.internal.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.geo.Point;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eyooya.app.common.api.search.service.BasicSearchRequestParams;
import com.eyooya.app.common.api.search.service.CommonLookupService;
import com.eyooya.app.common.api.search.service.InternalSearchRequest;
import com.eyooya.app.common.api.search.service.LookupEntitiesTypes;
import com.eyooya.app.common.api.search.service.impl.solr.SolrSearchRequestParams;
import com.eyooya.app.platform.solr.core.base.service.MemberSolrIndexService;
import com.eyooya.app.web.api.response.model.SearchResponse;


@RestController
@RequestMapping("api/i/v1/serach")
public class SearchAPIController {

	@Autowired
	@Qualifier("solrLookup")
	private CommonLookupService lookupService;

	@Autowired
	private MemberSolrIndexService solrService;

	@RequestMapping(value = "/ac", method = RequestMethod.GET)
	public SearchResponse searchACForBusinessAndEmployees(
			@RequestParam("token") String prefix,
			@RequestParam("loc") String state) {
		SearchResponse response = new SearchResponse();
		InternalSearchRequest request = InternalSearchRequest.generateRequest(
				LookupEntitiesTypes.BUSINESS_AND_EMPLOYEE).addSearchParam(
				SolrSearchRequestParams.NAME.name(), prefix).
				addSearchParam(SolrSearchRequestParams.POINT.name(), new Point(6,11)).
				addSearchParam(SolrSearchRequestParams.DISTANCE_IN_KM.name(), 1.0).addSearchParam(BasicSearchRequestParams.PAGE_NUM.name(), 0).
				addSearchParam(BasicSearchRequestParams.SIZE_OF_RESULTS_IN_PAGE.name(), 4);

		//lookupService.findByName(request);
		
		lookupService.findByNameFilterByLocation(request);

		response.setResults(request.getResponse());

		return response;
	}
	
	

}
