package com.eyooya.app.platform.db.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.WriteResult;

public abstract class CommonOperationsService <T>{
	
	@Autowired
	private MongoOperations mongo;
	
	protected abstract Class<T> getEntityClass();

	protected MongoOperations getMongo() {
		return mongo;
	}	
	
	protected  T findById(long id){
		return mongo.findById(id, getEntityClass());
	}
	
	protected WriteResult deleteById(long id, Class<?> entityClass){
		Query query = new Query().addCriteria(Criteria.where("id").is(id));		
		return mongo.remove(query, getEntityClass());
	}
	
	protected List<T> finalAll(Class<T> entityClass){
		return mongo.findAll(entityClass);
	}
	
	protected void insert(Object objectToSave){
		mongo.insert(objectToSave);
	}
	
}
