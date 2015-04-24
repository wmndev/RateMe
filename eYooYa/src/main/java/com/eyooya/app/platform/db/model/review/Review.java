package com.eyooya.app.platform.db.model.review;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;

public class Review implements Serializable {
	
	private static final long serialVersionUID = -5293158149824337466L;
	
	private long createdByMemeberId;
	
	private Date CreationDate;
	
	private long reviewingEmployeeId;

	private short score;
	
	private String text;

	@Id
	private long id;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCreatedByMemeberId() {
		return createdByMemeberId;
	}

	public void setCreatedByMemeberId(long createdByMemeberId) {
		this.createdByMemeberId = createdByMemeberId;
	}

	public Date getCreationDate() {
		return CreationDate;
	}

	public void setCreationDate(Date creationDate) {
		CreationDate = creationDate;
	}

	public long getReviewingEmployeeId() {
		return reviewingEmployeeId;
	}

	public void setReviewingEmployeeId(long reviewingEmployeeId) {
		this.reviewingEmployeeId = reviewingEmployeeId;
	}

	public short getScore() {
		return score;
	}

	public void setScore(short score) {
		this.score = score;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
