package com.eyooya.app.platform.amq.rabbit.message.service.type;

public enum MessageProcessorPriority {

	SUPER_HIGH(4), HIGH(3), MEDIUM(2), LOW(1);
	private int value;

	private MessageProcessorPriority(int value) {
		this.value = value;
	}

	public int value() {
		return value;
	}

}
