package com.eyooya.app.platform.db.repository;

import org.springframework.stereotype.Repository;

import com.eyooya.app.platform.db.model.business.BusinessEntity;

@Repository
public interface BusinessEntityRepository extends BaseRepository<BusinessEntity, Long> {

}
