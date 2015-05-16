package com.eyooya.app.web.api.internal.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eyooya.app.common.api.search.service.CommonLookupService;
import com.eyooya.app.common.api.search.service.LookupEntitiesTypes;
import com.eyooya.app.web.api.response.model.SearchResponse;
import com.eyooya.app.web.api.response.model.SearchResult;

@RestController
@RequestMapping("api/i/v1/serach")
public class SearchAPIController {

	@Autowired
	private CommonLookupService lookupService;

	@RequestMapping(value = "/ac", method = RequestMethod.GET)
	public SearchResponse searchACForBusinessAndEmployees(
			@RequestParam("token") String token) {

		List<String> matches = lookupService.findMatchedByPrefixAndTypes(token,
				LookupEntitiesTypes.BOTH_BUSINESS_AND_EMPLOYEE);

		List<SearchResult> results = new ArrayList<>();
		if (matches != null){
			int idx = 1;
			for (String match : matches) {
				results.add(new SearchResult(match, "The title" + (idx++),
						"Description" + (idx++), "resources/images/img1.jpeg"));
			}
		}

		SearchResponse response = new SearchResponse();
		response.setResults(results);
		return response;

	}

}
