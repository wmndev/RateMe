package com.eyooya.app.platform.amq.rabbit.message.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;

import com.google.common.collect.Ordering;

public class BasicMessageProcessingService<T extends MessageProcessor>
		implements MessageProcessingService {

	@Autowired
	private List<T> processors;

	@PostConstruct
	protected void initiateProcessors() {
		Comparator<T> byPriority = new Comparator<T>() {
			public int compare(T left, T right) {
				return Integer.compare(left.getPriority().value(), right
						.getPriority().value());
			}
		};

		Comparator<T> reversedByPriority = Ordering.from(byPriority).reversed();

		Collections.sort(processors, reversedByPriority);
		
		

	}

	public void processMessage(Message<Object> message) {
		for (T processor : processors) {
			processor.processMessage(message);
				System.out.println("processing...msg:"+message.toString());
			
		}
	}

}
