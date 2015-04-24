package com.eyooya.app.platform.db.model;

import java.util.Date;

public class FlatStats {
	
	private Date joinDate;
	private Date lastLogin;
	
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public Date getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	

}
