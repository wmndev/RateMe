package com.eyooya.app.platform.db.service;

import java.util.List;
import com.mongodb.WriteResult;

public interface CommonOperationsService<T> {

	T findById(long id);
	
	WriteResult deleteById(long id, Class<?> entityClass);
	
	List<T> finalAll(Class<T> entityClass);
	
	void insert(Object objectToSave);
	
	
	
	
}
