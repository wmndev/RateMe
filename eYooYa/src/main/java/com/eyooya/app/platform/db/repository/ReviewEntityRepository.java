package com.eyooya.app.platform.db.repository;

import org.springframework.stereotype.Repository;

import com.eyooya.app.platform.db.model.review.Review;

@Repository
public interface ReviewEntityRepository extends BaseRepository<Review, Long> {

}
