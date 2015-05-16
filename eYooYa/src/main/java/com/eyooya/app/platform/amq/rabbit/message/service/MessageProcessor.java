package com.eyooya.app.platform.amq.rabbit.message.service;

import org.springframework.messaging.Message;

import com.eyooya.app.platform.amq.rabbit.message.service.type.MessageProcessorPriority;

public interface MessageProcessor {
	
	void processMessage(Message<Object> message);
	
	MessageProcessorPriority getPriority(); 

}
