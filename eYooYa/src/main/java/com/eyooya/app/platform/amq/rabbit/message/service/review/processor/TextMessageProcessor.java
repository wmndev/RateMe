package com.eyooya.app.platform.amq.rabbit.message.service.review.processor;

import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.eyooya.app.platform.amq.rabbit.message.service.type.MessageProcessorPriority;

@Component
public class TextMessageProcessor implements ReviewMessageProcessor {

	@Override
	public void processMessage(Message<Object> message) {
		//TODO implement!

	}

	@Override
	public MessageProcessorPriority getPriority() {
		return MessageProcessorPriority.HIGH;
	}

}
