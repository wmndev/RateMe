package com.eyooya.app.platform.db.service.sequence;

public class SequenceServiceException extends RuntimeException {
	
	private static final long serialVersionUID = -1475946902913151129L;
	
	private String errCode;
	private String errMsg;
	
	public SequenceServiceException(String errMsg) {
		this.errMsg = errMsg;
	}
 
	
	public String getErrCode() {
		return errCode;
	}


	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}


	public String getErrMsg() {
		return errMsg;
	}


	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
}
