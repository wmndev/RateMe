package com.eyooya.app.platform.db.model.member;

import java.util.Date;

public class Occupation {

	private long businessId;

	private int rule;

	private Date from;

	private Date till;

	public long getBusinessId() {
		return businessId;
	}

	public void setBusinessId(long businessId) {
		this.businessId = businessId;
	}

	public int getRule() {
		return rule;
	}

	public void setRule(int rule) {
		this.rule = rule;
	}

	public Date getFrom() {
		return from;
	}

	public void setFrom(Date from) {
		this.from = from;
	}

	public Date getTill() {
		return till;
	}

	public void setTill(Date till) {
		this.till = till;
	}
}
