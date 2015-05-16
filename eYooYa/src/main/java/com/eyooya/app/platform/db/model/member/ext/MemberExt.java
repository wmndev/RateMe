package com.eyooya.app.platform.db.model.member.ext;

import com.eyooya.app.platform.db.model.member.BasicMember;

public abstract class MemberExt extends BasicMember {

	private static final long serialVersionUID = 1L;
	
	private long verificationId;	
	
	public MemberExt(long verificationId){
		this.verificationId = verificationId;
	}

	public long getVerificationId() {
		return verificationId;
	}

}
