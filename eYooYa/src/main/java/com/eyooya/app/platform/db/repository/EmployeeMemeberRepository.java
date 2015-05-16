package com.eyooya.app.platform.db.repository;

import org.springframework.stereotype.Repository;

import com.eyooya.app.platform.db.model.member.ext.employee.EmploeeMember;

@Repository
public interface EmployeeMemeberRepository extends BaseRepository<EmploeeMember, Long> {

}
