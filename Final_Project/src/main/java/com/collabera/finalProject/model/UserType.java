package com.collabera.finalProject.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class UserType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	@Column(name = "name", updatable = false, nullable = false)
	private String name;
	
	@OneToOne(mappedBy = "userType")
	private User user;
	
	@OneToOne(mappedBy = "userType")
	private Instructor instructor;
	
	@OneToOne(mappedBy = "userType")
	private Student student;
	
	//Constructor
	public UserType(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public UserType() {
	}

	//Getters and Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
