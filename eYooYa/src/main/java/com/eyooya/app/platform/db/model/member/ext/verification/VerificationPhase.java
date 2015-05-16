package com.eyooya.app.platform.db.model.member.ext.verification;

public class VerificationPhase {
	
	
	private String comment;
	
	private String phase;
	
	private long superviser;
	
	private boolean isComplete;
	

	public String getComment() {
		return comment;
	}

	public String getPhase() {
		return phase;
	}

	public boolean isComplete() {
		return isComplete;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setPhase(String phase) {
		this.phase = phase;
	}

	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}

	public long getSuperviser() {
		return superviser;
	}

	public void setSuperviser(long superviser) {
		this.superviser = superviser;
	}

}
