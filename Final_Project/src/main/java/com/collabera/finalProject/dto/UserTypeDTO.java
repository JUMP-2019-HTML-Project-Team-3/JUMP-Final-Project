package com.collabera.finalProject.dto;

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

public class UserTypeDTO implements Serializable, DTO {
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String name;
	
	private Set<UserDTO> users = new HashSet<>();
	
	private Set<InstructorDTO> instructors = new HashSet<>();
	
	private Set<StudentDTO> students = new HashSet<>();
	
	//Constructor
	public UserTypeDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public UserTypeDTO() {
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
