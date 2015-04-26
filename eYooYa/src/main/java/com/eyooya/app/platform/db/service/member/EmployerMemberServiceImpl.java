package com.eyooya.app.platform.db.service.member;

import org.springframework.stereotype.Service;

import com.eyooya.app.platform.db.model.member.EmployerMember;
import com.eyooya.app.platform.db.service.CommonOperationsServiceImpl;

@Service("employerMemberService")
public class EmployerMemberServiceImpl extends CommonOperationsServiceImpl<EmployerMember>
		implements MemberService {

	@Override
	protected Class<EmployerMember> getEntityClass() {
		return EmployerMember.class;
	}

}
