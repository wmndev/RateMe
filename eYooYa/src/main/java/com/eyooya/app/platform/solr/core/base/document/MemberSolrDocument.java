package com.eyooya.app.platform.solr.core.base.document;

import java.util.List;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Point;

public class MemberSolrDocument {
				
	@Id
	@Field
	private String id;
	
	@Field("name_t")
	private String name;

	@Field("title_t")
	private String title;
	
	@Field("tags_txt")
	private List<String> tags;
	
	@Field("category_t")
	private String category;
	
	@Field("type_t")
	private String type;
	
	@Field("rating_f")
	private float rating;
	
	@Field("locm_location")
	private List<Point> location;
	
	@Field("zip_s")
	private String zip;
	
	@Field("address_t")
	private String address;
	
	@Field("country_s")
	private String country;
	
	@Field("state_s")
	private String state;
	
	public MemberSolrDocument(){}
	
	public static Builder getBuilder(Long id, String name, String title, List<String> tags, String category, String type, float rating, List<Point> location,
			String zip, String address, String country, String state){
		return new Builder(id, name, title, tags, category, type, rating, location,
				zip, address, country, state) ;
	}
		
	public static class Builder {
		private MemberSolrDocument build;
		
		public Builder(Long id, String name, String title, List<String> tags, String category, String type, float rating, List<Point> location,
				String zip, String address, String country, String state){
			build = new MemberSolrDocument();
			build.setId(id.toString());
			build.setName(name);
			build.setTitle(title);
			build.setTags(tags);
			build.setCategory(category);
			build.setType(type);
			build.setRating(rating);
			build.setLocation(location);
			build.setZip(zip);
			build.setAddress(address);
			build.setCountry(country);
			build.setState(state);			
		}
		
		public MemberSolrDocument build(){
			return build;
		}
	}
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public List<Point> getLocation() {
		return location;
	}

	public void setLocation(List<Point> location) {
		this.location = location;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
