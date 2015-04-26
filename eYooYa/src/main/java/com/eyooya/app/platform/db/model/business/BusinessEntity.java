package com.eyooya.app.platform.db.model.business;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import com.eyooya.app.platform.db.model.Address;
import com.eyooya.app.platform.db.model.Contact;
import com.eyooya.app.platform.db.model.Location;

@Document(collection="businesses")
@TypeAlias(value="business")
public class BusinessEntity implements Serializable {
	
	private static final long serialVersionUID = -8161343581753299826L;

	@Id
	private long id;
	
	private int type;
	
	private Address address;
	
	private Location location;
	
	private Contact contact;
	
	private BussinessStats stats;
	
	private String description;
	
	private List<Long> employeesIds;

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public BussinessStats getStats() {
		return stats;
	}

	public void setStats(BussinessStats tats) {
		this.stats = tats;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Long> getEmployeesIds() {
		return employeesIds;
	}

	public void setEmployeesIds(List<Long> employeesIds) {
		this.employeesIds = employeesIds;
	}
	
	
	
	
	
	
	

}
