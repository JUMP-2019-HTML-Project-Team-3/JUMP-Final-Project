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

import com.collabera.finalProject.model.Instructor;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

public class ToolDTO implements Serializable, DTO {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String name;
	
	private String linkDownLoad;
	
	private String linkDocumentation;
	
	private String description;
	
	//FK to Students
	private Set<StudentDTO> students = new HashSet<>();
	
	//FK to Instructors
	private Set<InstructorDTO> instructors = new HashSet<>();
	
	//Constructor with Fields
	public ToolDTO(Long id, String name, String linkDownLoad, String linkDocumentation) {
		super();
		this.id = id;
		this.name = name;
		this.linkDownLoad = linkDownLoad;
		this.linkDocumentation = linkDocumentation;
	}

	public ToolDTO() {
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

	public String getLinkDownLoad() {
		return linkDownLoad;
	}

	public void setLinkDownLoad(String linkDownLoad) {
		this.linkDownLoad = linkDownLoad;
	}

	public String getLinkDocumentation() {
		return linkDocumentation;
	}

	public void setLinkDocumentation(String linkDocumentation) {
		this.linkDocumentation = linkDocumentation;
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
		student.getTools().add(this);
	}
	
	public void removeStudent(StudentDTO student) {
		students.remove(student);
		student.getTools().remove(this);
	}

	public Set<InstructorDTO> getInstructors() {
		return instructors;
	}

	public void setInstructors(Set<InstructorDTO> instructors) {
		this.instructors = instructors;
	}
	
	public void addInstructor(InstructorDTO instructor) {
		this.instructors.add(instructor);
		instructor.getTools().add(this);
	}
	
}
