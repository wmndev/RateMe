package com.eyooya.app.web.api.response;

public class BasicResponseImpl implements BasicResponse {

	private boolean result;
	private String content;
	
	public BasicResponseImpl(boolean result, String content){
		this.result = result;
		this.content = content;
	}
	
	
	@Override
	public boolean getResult() {
		return result;
	}

	@Override
	public String getContent() {
		return content;
	}

}
