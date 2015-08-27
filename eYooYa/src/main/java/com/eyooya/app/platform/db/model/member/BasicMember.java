package com.eyooya.app.platform.db.model.member;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import com.eyooya.app.platform.db.model.FlatStats;
import com.eyooya.app.platform.db.model.Location;
import com.eyooya.app.platform.db.model.Reviews;


@Document(collection="basicMembers")
@TypeAlias(value="basicMemeber")
public class BasicMember implements Serializable {
	
	private static final long serialVersionUID = 7585793280522327504L;

	@Id
	private long id;
	
	private Details details;
	
	private FlatStats flatStats;
	
	private Reviews reviews;
	
	private Location location;
	
	private Social social;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Details getDetails() {
		return details;
	}

	public void setDetails(Details details) {
		this.details = details;
	}

	public FlatStats getFlatStats() {
		return flatStats;
	}

	public void setFlatStats(FlatStats flatStats) {
		this.flatStats = flatStats;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Reviews getReviews() {
		return reviews;
	}

	public void setReviews(Reviews reviews) {
		this.reviews = reviews;
	}

	public Social getSocial() {
		return social;
	}

	public void setSocial(Social social) {
		this.social = social;
	}
}
