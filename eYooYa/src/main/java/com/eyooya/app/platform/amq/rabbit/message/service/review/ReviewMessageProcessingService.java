package com.eyooya.app.platform.amq.rabbit.message.service.review;

import org.springframework.stereotype.Service;

import com.eyooya.app.platform.amq.rabbit.message.service.BasicMessageProcessingService;
import com.eyooya.app.platform.amq.rabbit.message.service.review.processor.ReviewMessageProcessor;

@Service("reviewMessageProcessingService")
public class ReviewMessageProcessingService extends
		BasicMessageProcessingService<ReviewMessageProcessor> {

}
