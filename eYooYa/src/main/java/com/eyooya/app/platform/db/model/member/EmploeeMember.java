package com.eyooya.app.platform.db.model.member;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="employees")
@TypeAlias(value="employee")
public class EmploeeMember extends BasicMember {

	private static final long serialVersionUID = 2521287069861474263L;
	
	@Indexed
	private long currentBusinessId;
	
	private CurriculaVitae cv;
	
	private RankStats rankStats;
		
	public long getCurrentBusinessId() {
		return currentBusinessId;
	}

	public void setCurrentBusinessId(long currentBusinessId) {
		this.currentBusinessId = currentBusinessId;
	}

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
