package com.eyooya.app.web.api.internal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eyooya.app.platform.db.model.review.Review;
import com.eyooya.app.platform.db.service.CommonOperationsService;
import com.eyooya.app.web.api.response.BasicResponse;

@RestController
@RequestMapping("api/i/v1/review")
public class ReviewsAPIController {
	
	@Autowired
	@Qualifier("reviewService")
	private CommonOperationsService<Review> reviewService;
	
	@RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
	public Review getReviewById(@PathVariable("id") String id){
		if (id!=null){
			return reviewService.findById(Long.parseLong(id));
		}
		return null;
	}
	
	@RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Review> getAllReviews(){
			return reviewService.finalAll(Review.class);		
	}
	
	
	@RequestMapping(method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
	public BasicResponse addReview(){
		
		
		return null;
		
	}

}
