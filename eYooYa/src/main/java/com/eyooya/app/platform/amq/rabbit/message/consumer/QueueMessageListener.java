package com.eyooya.app.platform.amq.rabbit.message.consumer;

import org.springframework.messaging.Message;

public interface QueueMessageListener {
	
	public void handleMessage(Message<Object> message);
	
}
