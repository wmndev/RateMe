package com.eyooya.app.platform.db.model.member;


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
