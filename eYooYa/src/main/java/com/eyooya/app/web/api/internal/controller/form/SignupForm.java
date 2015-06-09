package com.eyooya.app.web.api.internal.controller.form;

import org.springframework.social.connect.UserProfile;

public class SignupForm {
	
	
	private String firstName;
	private String lastName;
	private String username;
	private String email;
	
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getUsername() {
		return username;
	}
	public String getEmail() {
		return email;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public static SignupForm fromProviderUser(UserProfile providerUser) {
	    SignupForm form = new SignupForm();
	    form.setFirstName(providerUser.getFirstName());
	    form.setLastName(providerUser.getLastName());
	    form.setUsername(providerUser.getUsername());
	    form.setEmail(providerUser.getEmail());
	    return form;
	}

}
