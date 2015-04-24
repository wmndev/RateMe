package com.eyooya.app.platform.db.model.business;

import java.util.Date;

import com.eyooya.app.platform.db.model.FlatStats;

public class BussinessStats extends FlatStats {
	
	private long approvedBy;
	
	private Date approvalDate;
	
	private long managerId;

	public long getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(long approvedBy) {
		this.approvedBy = approvedBy;
	}

	public Date getApprovalDate() {
		return approvalDate;
	}

	public void setApprovalDate(Date approvalDate) {
		this.approvalDate = approvalDate;
	}

	public long getManagerId() {
		return managerId;
	}

	public void setManagerId(long managerId) {
		this.managerId = managerId;
	}
	
	

}
