package com.collabera.finalProject.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



@Entity
public class Instructor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	@Column(name = "firstName", nullable = false, length = 25)
	private String firstName;
	
	@Column(name = "lastName", nullable = false, length = 25)
	private String lastName;
	
	@Column(name = "description", nullable = false, length = 250)
	private String description;
	
	//FK to UserType
	@OneToOne
	@JoinColumn(name = "id")
	private UserType userType;
	
	//FK to Student
    @OneToMany(mappedBy = "instructor")
	private Set<Student> students;
    
    //FK to Resource
    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
	private Set<Resource> resources;
    
    //FK to Tool
    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
	private Set<Tool> tools;

    //Constructor Using Fields
	public Instructor(Long id, String firstName, String lastName, String description, UserType userType,
			Set<Student> students, Set<Resource> resources, Set<Tool> tools) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.description = description;
		this.userType = userType;
		this.students = students;
		this.resources = resources;
		this.tools = tools;
	}

	public Instructor() {
		// TODO Auto-generated constructor stub
	}

	//Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Set<Resource> getResources() {
		return resources;
	}

	public void setResources(Set<Resource> resources) {
		this.resources = resources;
	}

	public Set<Tool> getTools() {
		return tools;
	}

	public void setTools(Set<Tool> tools) {
		this.tools = tools;
	}
}
