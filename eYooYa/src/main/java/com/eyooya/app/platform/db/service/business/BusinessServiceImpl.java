package com.eyooya.app.platform.db.service.business;


import org.springframework.stereotype.Service;

import com.eyooya.app.platform.db.model.business.BusinessEntity;
import com.eyooya.app.platform.db.service.CommonOperationsServiceImpl;

@Service("businessService")
public class BusinessServiceImpl extends CommonOperationsServiceImpl<BusinessEntity> implements BusinessService {

	@Override
	protected Class<BusinessEntity> getEntityClass() {
		return BusinessEntity.class;
	}
}
