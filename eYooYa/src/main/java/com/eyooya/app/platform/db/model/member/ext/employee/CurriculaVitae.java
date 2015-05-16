package com.eyooya.app.platform.db.model.member.ext.employee;

import java.io.Serializable;
import java.util.List;


public class CurriculaVitae implements Serializable {

	private static final long serialVersionUID = 8684356692285932638L;

	private short experienceInYears;
	
	private List<Occupation> occupations;
	
	public short getExperienceInYears() {
		return experienceInYears;
	}

	public void setExperienceInYears(short experienceInYears) {
		this.experienceInYears = experienceInYears;
	}

	public List<Occupation> getOccupations() {
		return occupations;
	}

	public void setOccupations(List<Occupation> occupations) {
		this.occupations = occupations;
	}
}
