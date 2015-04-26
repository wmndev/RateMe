package com.eyooya.app.platform.db.service.member;

import org.springframework.stereotype.Service;

import com.eyooya.app.platform.db.model.member.BasicMember;
import com.eyooya.app.platform.db.service.CommonOperationsServiceImpl;

@Service("basicMemberService")
public class BasicMemeberServiceImpl extends CommonOperationsServiceImpl<BasicMember> implements MemberService{

	@Override
	protected Class<BasicMember> getEntityClass() {
		return BasicMember.class;
	}

}
