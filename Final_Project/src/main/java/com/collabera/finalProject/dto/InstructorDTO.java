package com.collabera.finalProject.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.collabera.finalProject.model.Location;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

public class InstructorDTO implements Serializable, DTO {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	private String description;
	
	private UserDTO user;
	
	//FK to UserType
	private UserTypeDTO userType;
	
	//FK to Student
	private Set<StudentDTO> students = new HashSet<>();
    
    //FK to Resource
	private Set<ResourceDTO> resources;
    
    //FK to Tool
	private Set<ToolDTO> tools = new HashSet<>();
    
    //FK to Location
    private Set<LocationDTO> locations = new HashSet<>();

    //Constructor Using Fields
	public InstructorDTO(Long id, String firstName, String lastName, String description, UserDTO user, UserTypeDTO userType,
			Set<StudentDTO> students, Set<ResourceDTO> resources, Set<ToolDTO> tools) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.description = description;
		this.user = user;
		this.userType = userType;
		this.students = students;
		this.resources = resources;
		this.tools = tools;
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


	public UserDTO getUser() {
		return user;
	}


	public void setUser(UserDTO user) {
		this.user = user;
	}


	public UserTypeDTO getUserType() {
		return userType;
	}


	public void setUserType(UserTypeDTO userType) {
		this.userType = userType;
	}


	public Set<StudentDTO> getStudents() {
		return students;
	}


	public void setStudents(Set<StudentDTO> students) {
		this.students = students;
	}


	public Set<ResourceDTO> getResources() {
		return resources;
	}


	public void setResources(Set<ResourceDTO> resources) {
		this.resources = resources;
	}


	public Set<ToolDTO> getTools() {
		return tools;
	}


	public void setTools(Set<ToolDTO> tools) {
		this.tools = tools;
	}


	public InstructorDTO() {
	}

	
	// Location
	public Set<LocationDTO> getLocations() {
		return locations;
	}


	public void setLocations(Set<LocationDTO> locations) {
		this.locations = locations;
	}
	
	public void addLocation(LocationDTO location) {
		this.locations.add(location);
		location.getInstructors().add(this);	
	}
	
	// Add/Remove Student
	public void addStudent(StudentDTO s)
	{
		this.students.add(s);
		s.getInstructors().add(this);
	}
	
	public void removeStudent(StudentDTO s)
	{
		this.students.remove(s);
		s.getInstructors().remove(this);
	}
	
	// Add/Remove Resource
	public void addResource(ResourceDTO r)
	{
		this.resources.add(r);
	}
	
	public void removeResource(ResourceDTO r)
	{
		this.resources.remove(r);
	}
	
	// Add/Remove Tool
	public void addTool(ToolDTO t)
	{
		this.tools.add(t);
	}
	
	public void removeTool(ToolDTO t)
	{
		this.tools.remove(t);
	}

}
