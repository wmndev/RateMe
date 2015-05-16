package com.eyooya.app.platform.db.model.member.ext.employee;

import java.util.Date;

public class Occupation {

	private long businessId;

	private int role;

	private Date from;

	private Date till;

	public long getBusinessId() {
		return businessId;
	}

	public void setBusinessId(long businessId) {
		this.businessId = businessId;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
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
