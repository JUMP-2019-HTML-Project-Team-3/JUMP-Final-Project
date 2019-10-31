package com.collabera.dto;

/**
 * a POJO to contain all the fields of a User, this will be used to interact between UI and API layer
 */
public class UserDTO {

	private String username;

	private String password;

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

}

