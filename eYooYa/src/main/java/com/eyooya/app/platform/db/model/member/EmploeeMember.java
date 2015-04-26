package com.eyooya.app.platform.db.model.member;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="members_level2")
@TypeAlias(value="employee")
public class EmploeeMember extends BasicMember {

	private static final long serialVersionUID = 2521287069861474263L;
	
	private CurriculaVitae cv;
	
	private RankStats rankStats;

	public CurriculaVitae getCv() {
		return cv;
	}

	public void setCv(CurriculaVitae cv) {
		this.cv = cv;
	}

	public RankStats getRankStats() {
		return rankStats;
	}

	public void setRankStats(RankStats rankStats) {
		this.rankStats = rankStats;
	}
}
