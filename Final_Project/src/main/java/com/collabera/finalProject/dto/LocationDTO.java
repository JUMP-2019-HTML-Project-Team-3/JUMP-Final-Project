package com.collabera.finalProject.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

public class LocationDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String imagePath;
	
	private String name;
	
	private String phoneNo; // phone number has default value as annotated

	private AddressDTO address;

	private Set<StudentDTO> students = new HashSet<StudentDTO>();

	private Set<InstructorDTO> instructors = new HashSet<InstructorDTO>();

	public LocationDTO(Long id, String imagePath, String name, String phoneNo, AddressDTO address, Set<StudentDTO> students,
			Set<InstructorDTO> instructors) {
		super();
		this.id = id;
		this.imagePath = imagePath;
		this.name = name;
		this.phoneNo = phoneNo;
		this.address = address;
		this.students = students;
		this.instructors = instructors;
	}

	public LocationDTO() {
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

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public AddressDTO getAddress() {
		return address;
	}

	public void setAddress(AddressDTO address) {
		this.address = address;
	}
	
	public void addStudent(StudentDTO student) {
		students.add(student);
		student.setLocation(this);	
	}

	public Set<StudentDTO> getStudents() {
		return students;
	}

	public void setStudents(Set<StudentDTO> students) {
		this.students = students;
	}

	public Set<InstructorDTO> getInstructors() {
		return instructors;
	}

	public void setInstructors(Set<InstructorDTO> instructors) {
		this.instructors = instructors;
	}
	
	public void addInstructor(InstructorDTO instructor) {
		instructors.add(instructor);
		instructor.getLocations().add(this);
	}
	
	public void removeInstructor(InstructorDTO instructor) {
		instructors.remove(instructor);
		instructor.getLocations().remove(this);
	}

}
