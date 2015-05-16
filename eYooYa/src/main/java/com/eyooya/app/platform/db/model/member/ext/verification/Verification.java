package com.eyooya.app.platform.db.model.member.ext.verification;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import com.eyooya.app.platform.type.VerificationStatusType;

@Document(collection = "verifications")
@TypeAlias(value = "verification")
public class Verification implements Serializable {

	private static final long serialVersionUID = -1086932941499167037L;

	@Id
	private Long id;

	private long verifiedBy;

	private Date complitionDate;

	private VerificationStatusType status;

	private List<VerificationPhase> phases;

	public Long getId() {
		return id;
	}

	public long getVerifiedBy() {
		return verifiedBy;
	}

	public Date getComplitionDate() {
		return complitionDate;
	}

	public VerificationStatusType getStatus() {
		return status;
	}

	public List<VerificationPhase> getPhases() {
		return phases;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setVerifiedBy(long verifiedBy) {
		this.verifiedBy = verifiedBy;
	}

	public void setComplitionDate(Date complitionDate) {
		this.complitionDate = complitionDate;
	}

	public void setStatus(VerificationStatusType status) {
		this.status = status;
	}

	public void setPhases(List<VerificationPhase> phases) {
		this.phases = phases;
	}
}
