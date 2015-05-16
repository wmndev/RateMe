package com.eyooya.app.platform.db.model.member.ext.employee;

import java.util.Date;

public class RankStats {
	
	private double score;
	
	private long totalNumberOfReviews;
	
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

	public Date getLastReviewedDate() {
		return lastReviewedDate;
	}

	public void setLastReviewedDate(Date lastReviewedDate) {
		this.lastReviewedDate = lastReviewedDate;
	}
	

}
