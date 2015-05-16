package com.eyooya.app.platform.db.model.member;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Social {
	
	public Social() {
		this.friends = new ArrayList<>();
		this.following = new ArrayList<>();
		this.interests = new ArrayList<Long>();
		this.promotionsUsed = new LinkedList<>();
	}

	private List<Long> friends;
	
	private List<Long> following;
	
	private List<Long> interests;
	
	private List<Long> promotionsUsed;

	public List<Long> getFriends() {
		return friends;
	}

	public List<Long> getFollowing() {
		return following;
	}

	public List<Long> getInterests() {
		return interests;
	}

	public List<Long> getPromotionsUsed() {
		return promotionsUsed;
	}

	public void setFriends(List<Long> friends) {
		this.friends = friends;
	}

	public void setFollowing(List<Long> following) {
		this.following = following;
	}

	public void setInterests(List<Long> interests) {
		this.interests = interests;
	}

	public void setPromotionsUsed(List<Long> promotionsUsed) {
		this.promotionsUsed = promotionsUsed;
	}

}
