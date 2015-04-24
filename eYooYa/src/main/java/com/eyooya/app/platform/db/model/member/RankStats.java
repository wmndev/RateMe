package com.eyooya.app.platform.db.model.member;

import java.util.Date;
import java.util.List;

public class RankStats {
	
	private double score;
	
	private long totalNumberOfReviews;
	
	private List<Long> reviewsIds;
	
	private Date lastReviewedDate;

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public long getTotalNumberOfReviews() {
		return totalNumberOfReviews;
	}

	public void setTotalNumberOfReviews(long totalNumberOfReviews) {
		this.totalNumberOfReviews = totalNumberOfReviews;
	}

	public List<Long> getReviewsIds() {
		return reviewsIds;
	}

	public void setReviewsIds(List<Long> reviewsIds) {
		this.reviewsIds = reviewsIds;
	}

	public Date getLastReviewedDate() {
		return lastReviewedDate;
	}

	public void setLastReviewedDate(Date lastReviewedDate) {
		this.lastReviewedDate = lastReviewedDate;
	}
	

}
