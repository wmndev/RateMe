package com.eyooya.app.platform.db.service.review;

import org.springframework.stereotype.Service;

import com.eyooya.app.platform.db.model.review.Review;
import com.eyooya.app.platform.db.service.CommonOperationsServiceImpl;

@Service("reviewService")
public class ReviewServiceImpl extends CommonOperationsServiceImpl<Review> implements
		ReviewService {

	@Override
	protected Class<Review> getEntityClass() {
		return Review.class;
	}

}
