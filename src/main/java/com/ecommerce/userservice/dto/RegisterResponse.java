package com.ecommerce.userservice.dto;

import java.util.Set;
import java.util.stream.Collectors;

import com.ecommerce.userservice.model.User;

public class RegisterResponse {
	
	private long id;
	private String username;
	private String emailId;
	private String token;
	private Set<String> roles;
	
	public RegisterResponse(User user, String token) {
		this.id = user.getId();
		this.username = user.getUsername();
		this.emailId = user.getEmailId();
		this.token = token;
		this.roles = user.getRole().stream().map(role->role.getType().name()).collect(Collectors.toSet());
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}

}
