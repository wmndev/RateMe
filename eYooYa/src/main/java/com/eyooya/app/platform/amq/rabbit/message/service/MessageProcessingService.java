package com.eyooya.app.platform.amq.rabbit.message.service;

import org.springframework.messaging.Message;

public interface MessageProcessingService {
	
	void processMessage(Message<Object> message);

}
