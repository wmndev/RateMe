package com.eyooya.app.common.api.google.service.result;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Photos {
	@JsonProperty("photo_reference")
	private String ref;

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}
}
