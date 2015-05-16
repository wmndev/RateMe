package com.eyooya.app.platform.db.repository;

import org.springframework.stereotype.Repository;

import com.eyooya.app.platform.db.model.member.ext.employer.EmployerMember;

@Repository
public interface EmployerMemberRepository extends BaseRepository<EmployerMember, Long> {

}
