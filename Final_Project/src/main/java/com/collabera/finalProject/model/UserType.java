package com.collabera.finalProject.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class UserType implements Serializable, Model {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userType_id", updatable = false, nullable = false)
	private Long id;
	
	@Column(name = "name", updatable = false, nullable = false)
	private String name;
	
	@OneToMany(mappedBy = "userType")
	private Set<User> users = new HashSet<>();
	
	@OneToMany(mappedBy = "userType")
	private Set<Instructor> instructors = new HashSet<>();
	
	@OneToMany(mappedBy = "userType")
	private Set<Student> students = new HashSet<>();
	
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
