package com.eyooya.app.platform.db.model.member.ext.employer;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import com.eyooya.app.platform.db.model.member.ext.MemberExt;

@Document(collection="employers")
@TypeAlias(value="employer")
public class EmployerMember extends MemberExt {
	  
	private static final long serialVersionUID = 5386603535712041989L;
	
	public EmployerMember(long verificationId) {
		super(verificationId);
	}
	
	private long businessId;

	public long getBusinessId() {
		return businessId;
	}

	public void setBusinessId(long businessId) {
		this.businessId = businessId;
	}
}
