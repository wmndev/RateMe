package com.eyooya.app.platform.db.repositories;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BaseRepository <T, ID extends Serializable>  extends MongoRepository<T, ID> {

}
