package com.eyooya.app.web.api.internal.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eyooya.app.common.api.search.service.CommonLookupService;
import com.eyooya.app.common.api.search.service.InternalSearchRequest;
import com.eyooya.app.common.api.search.service.LookupEntitiesTypes;
import com.eyooya.app.web.api.response.model.SearchResponse;
import com.eyooya.app.web.api.response.model.SearchResult;

@RestController
@RequestMapping("api/i/v1/serach")
public class SearchAPIController {

	@Autowired
	private CommonLookupService lookupService;

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/ac", method = RequestMethod.GET)
	public SearchResponse searchACForBusinessAndEmployees(
			@RequestParam("token") String token, 
			@RequestParam("loc") String location) {

		InternalSearchRequest request = InternalSearchRequest.generateRequest(LookupEntitiesTypes.BOTH_BUSINESS_AND_EMPLOYEE)
				.addSearchParam("token", token).addSearchParam("location", location);
		
		lookupService.findByTokenWithLocationAndType(request);

		List<SearchResult> results = new ArrayList<>();
		if (request.getResponse() != null){
			int idx = 1;
			for (String match : (List<String>)request.getResponse()) {
				results.add(new SearchResult(match, "The title" + (idx++),
						"Description" + (idx++), "resources/images/img1.jpeg"));
			}
		}

		SearchResponse response = new SearchResponse();
		response.setResults(results);
		return response;

	}

}
