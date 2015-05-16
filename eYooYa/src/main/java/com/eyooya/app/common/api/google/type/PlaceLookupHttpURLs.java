package com.eyooya.app.common.api.google.type;

public enum PlaceLookupHttpURLs {
	NEAR_BY("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location={lat},{lng}&radius={radius}&key={apiKey}"),
	TEXT_QUERY("https://maps.googleapis.com/maps/api/place/textsearch/json?query={query}&key={apiKey}");

	private String uri;

	private PlaceLookupHttpURLs(String uri) {
		this.uri = uri;
	}

	public String uri() {
		return uri;
	}
}
