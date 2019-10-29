package com.collabera.finalProject.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

public class ClientDTO implements  Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String imagePath;
	
	private String name;
	
	private String phone;
	
	private String description;
	
	private AddressDTO address;
	
	private Set<StudentDTO> students = new HashSet<>();
	
	public ClientDTO () {
		
	}

	public ClientDTO(Long id, String imagePath, String name, String phone, String description, AddressDTO addressDTO,
			Set<StudentDTO> students) {
		super();
		this.id = id;
		this.imagePath = imagePath;
		this.name = name;
		this.phone = phone;
		this.description = description;
		this.address = addressDTO;
		this.students = students;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public AddressDTO getAddress() {
		return address;
	}

	public void setAddress(AddressDTO address) {
		this.address = address;
	}

	public Set<StudentDTO> getStudents() {
		return students;
	}

	public void setStudents(Set<StudentDTO> students) {
		this.students = students;
	}
	
	 public void addStudent(StudentDTO student) {
	        students.add(student);
	    }
	 
	 public void removeStudent(StudentDTO student) {
		 students.remove(student);
	 }
}
