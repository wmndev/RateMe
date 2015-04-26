package com.eyooya.app.platform.db.model.member;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="members_level2")
@TypeAlias(value="employer")
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
