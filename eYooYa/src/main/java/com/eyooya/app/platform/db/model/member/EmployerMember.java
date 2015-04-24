package com.eyooya.app.platform.db.model.member;

public class EmployerMember extends BasicMember {
	
	private static final long serialVersionUID = 5386603535712041989L;
	
	private long businessId;

	public long getBusinessId() {
		return businessId;
	}

	public void setBusinessId(long businessId) {
		this.businessId = businessId;
	}

}
