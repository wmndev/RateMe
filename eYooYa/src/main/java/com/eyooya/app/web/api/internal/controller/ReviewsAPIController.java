package com.eyooya.app.web.api.internal.controller;

import java.util.List;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eyooya.app.common.api.google.service.BusinessLookUpService;
import com.eyooya.app.platform.db.model.review.Review;
import com.eyooya.app.platform.db.repository.ReviewEntityRepository;
import com.eyooya.app.web.api.response.BasicResponse;


@RestController
@RequestMapping("api/i/v1/review")
public class ReviewsAPIController {
	
	@Autowired
	private ReviewEntityRepository reviewRepository;
	
	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	@Autowired
	private BusinessLookUpService bService;
	
	@RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
	public Review getReviewById(@PathVariable("id") String id){
		if (id!=null){
			return reviewRepository.findOne(Long.parseLong(id));
		}
		return null;
	}
	
	@RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Review> getAllReviews(){
		Message<String> message = MessageBuilder.withPayload("test")
		        .setHeader("foo", "bar")
		        .build();
		
		
		rabbitTemplate.convertAndSend("direct.exchange", "review.key", message);			
		
		bService.lookInGoogleAPI();
		return reviewRepository.findAll();		
	}
	
	
	@RequestMapping(method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
	public BasicResponse addReview(){

		return null;
		
	}

}
