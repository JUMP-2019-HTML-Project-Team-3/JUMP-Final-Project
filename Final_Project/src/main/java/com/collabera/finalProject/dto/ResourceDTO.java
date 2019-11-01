package com.collabera.finalProject.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

public class ResourceDTO implements Serializable, DTO {
	
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String name;
	
	private String link;
	
	private String description;
	
	//Fk to Students
	private Set<StudentDTO> students = new HashSet<>();
	
	//FK to Instructors
	private Set<InstructorDTO> instructors;
	
	//Constructor with Fields
	public ResourceDTO(Long id, String name, String link, String description, Set<StudentDTO> students, Set<InstructorDTO> instructors) {
		this.id = id;
		this.name = name;
		this.link = link;
		this.description = description;
		this.students = students;
		this.instructors = instructors;
	}

	public ResourceDTO() {
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

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public Set<StudentDTO> getStudents()
	{
		return students;
	}

	public void setStudents(Set<StudentDTO> students)
	{
		this.students = students;
	}
	
	public void addStudent(StudentDTO student) {
		students.add(student);
		student.getResources().add(this);
	}
	
	public void removeStudent(StudentDTO student) {
		students.remove(student);
		student.getResources().remove(this);
	}

	public Set<InstructorDTO> getInstructors() {
		return instructors;
	}

	public void setInstructors(Set<InstructorDTO> instructors) {
		this.instructors = instructors;
	}

	public void addInstructor(InstructorDTO instructor) {
		instructors.add(instructor);
		instructor.getResources().add(this);
	}
	
}
