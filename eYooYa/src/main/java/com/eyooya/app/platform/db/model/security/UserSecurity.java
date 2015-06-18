package com.eyooya.app.platform.db.model.security;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "userSecurity")
@TypeAlias(value="user")
public class UserSecurity {

	@Id
	private long id;
	private String name;
	private String lastName;
	@Indexed
	private String username;
	private String password;
	private List<Integer> roles;

	public UserSecurity() {
		super();
	}
	
	public UserSecurity(long id, String name, String lastName,
			String password, List<Integer> roles) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.password = password;
		this.roles = roles;
	}

	public UserSecurity(long id, String name, String lastName, String username,
			String password, List<Integer> roles) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.roles = roles;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Integer> getRoles() {
		return roles;
	}

	public void setRoles(List<Integer> roles) {
		this.roles = roles;
	}
}
