package com.collabera.finalProject.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", updatable = false, nullable = false)
	private Long id;
	
	@Column(name = "username", updatable = false, nullable = false, length = 25)
	private String username;
	
	@Column(name = "password", updatable = true, nullable = false, length = 25)
	private String password;
	
	@Column(name = "email", updatable = false, nullable = false, length = 25)
	private String email;
	
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "userType_id", referencedColumnName = "userType_id")
	private UserType userType;
	
	@OneToOne(mappedBy = "user")
	private Student student;
	
	@OneToOne(mappedBy = "user")
	private Instructor instructor;

	//Constructor
	public User(Long id, String username, String password, String email, UserType userType) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.userType = userType;
	}

	public User() {
	}

	//Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}
}
