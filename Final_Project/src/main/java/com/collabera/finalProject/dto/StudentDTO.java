package com.collabera.finalProject.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;

public class StudentDTO implements  Serializable, DTO {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String imagePath;
	private String firstName;
	private String lastName;
	private String description;
	
	private UserDTO user;
	
	private UserTypeDTO userType;
	
	//Instructors
	private Set<InstructorDTO> instructors = new HashSet<InstructorDTO>();

    //Clients
	private Set<ClientDTO> clients = new HashSet<ClientDTO>();
	
	//Resources
	private Set<ResourceDTO> resources = new HashSet<ResourceDTO>();
	
	//Tools
	private Set<ToolDTO> tools = new HashSet<ToolDTO>();
	
	//Locations
	private LocationDTO location;

	public StudentDTO(Long id, String imagePath, String firstName, String lastName, String description, UserDTO user,
			UserTypeDTO userType, Set<InstructorDTO> instructors, Set<ClientDTO> clients, Set<ResourceDTO> resources,
			Set<ToolDTO> tools, LocationDTO location) {
		super();
		this.id = id;
		this.imagePath = imagePath;
		this.firstName = firstName;
		this.lastName = lastName;
		this.description = description;
		this.user = user;
		this.userType = userType;
		this.instructors = instructors;
		this.clients = clients;
		this.resources = resources;
		this.tools = tools;
		this.location = location;
	}

	public StudentDTO() {
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

	public Set<InstructorDTO> getInstructors() {
		return instructors;
	}

	public void setInstructors(Set<InstructorDTO> instructors) {
		this.instructors = instructors;
	}
	
	public void addInstructor(InstructorDTO instructor) {
		instructors.add(instructor);
		instructor.getStudents().add(this);
	}

	public Set<ClientDTO> getClients() {
		return clients;
	}

	public void setClients(Set<ClientDTO> clients) {
		this.clients = clients;
	}
	
	public void addClient(ClientDTO client) {
		clients.add(client);
		client.getStudents().add(this);
	}
	
	public void removeClient(ClientDTO client) {
		clients.remove(client);
		client.getStudents().remove(this);
	}

	public Set<ResourceDTO> getResources() {
		return resources;
	}

	public void setResources(Set<ResourceDTO> resources) {
		this.resources = resources;
	}
	
	public void addResource(ResourceDTO resource) {
		resources.add(resource);
		resource.getStudents().add(this);
	}
	
	public void removeResource(ResourceDTO resource) {
		resources.remove(resource);
		resource.getStudents().remove(this);
	}

	public Set<ToolDTO> getTools() {
		return tools;
	}

	public void setTools(Set<ToolDTO> tools) {
		this.tools = tools;
	}
	
	public void addTool(ToolDTO tool) {
		tools.add(tool);
		tool.getStudents().add(this);
	}
	
	public void removeTool(ToolDTO tool) {
		tools.remove(tool);
		tool.getStudents().remove(this);
	}

	public LocationDTO getLocation() {
		return location;
	}

	public void setLocation(LocationDTO location) {
		this.location = location;
	}
		
}
