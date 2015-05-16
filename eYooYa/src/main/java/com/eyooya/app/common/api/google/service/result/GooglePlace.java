package com.eyooya.app.common.api.google.service.result;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GooglePlace implements Serializable {

	private static final long serialVersionUID = 4940221730089435864L;

	private String id;
	private String name;
	@JsonProperty("place_id")
	private String placeId;
	private String scope;
	private String vicinity;
	private Geometry geometry;
	private List<Photos> photos;

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPlaceId() {
		return placeId;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getVicinity() {
		return vicinity;
	}

	public void setVicinity(String vicinity) {
		this.vicinity = vicinity;
	}

	public List<Photos> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photos> photos) {
		this.photos = photos;
	}

	public Geometry getGeometry() {
		return geometry;
	}

	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}
}
