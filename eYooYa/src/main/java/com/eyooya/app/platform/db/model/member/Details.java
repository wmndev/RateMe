package com.eyooya.app.platform.db.model.member;

import java.util.Date;

import com.eyooya.app.platform.db.model.Address;
import com.eyooya.app.platform.db.model.Contact;

public class Details {
	
	private Contact contact;
	private Address address;
	private String firstName;
	private String LastName;
	private Date birthday;
	
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}	

}
