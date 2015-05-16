package com.eyooya.app.platform.amq.rabbit.message.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.eyooya.app.platform.amq.rabbit.message.service.MessageProcessingService;

@Component
public class ReviewMessageListener implements QueueMessageListener{

	@Autowired
	private MessageProcessingService reviewMessageProcessingService;
	

	@Override
	@RabbitListener(queues="review.q")
	public void handleMessage(Message<Object> message) {
		reviewMessageProcessingService.processMessage(message);
	}
		

}
