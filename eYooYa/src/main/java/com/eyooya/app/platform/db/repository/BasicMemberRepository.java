package com.eyooya.app.platform.db.repository;

import org.springframework.stereotype.Repository;

import com.eyooya.app.platform.db.model.member.BasicMember;

@Repository
public interface BasicMemberRepository extends BaseRepository<BasicMember, Long> {

}
