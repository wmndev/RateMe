package com.eyooya.app.platform.db.service.member;

import org.springframework.stereotype.Service;

import com.eyooya.app.platform.db.model.member.EmploeeMember;
import com.eyooya.app.platform.db.service.CommonOperationsServiceImpl;

@Service("employeeMemberService")
public class EmployeeMemberServiceImpl extends CommonOperationsServiceImpl<EmploeeMember>
		implements MemberService {

	@Override
	protected Class<EmploeeMember> getEntityClass() {
		return EmploeeMember.class;
	}

}
