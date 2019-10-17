package com.collabera.finalProject.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Student implements  Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String imagePath;
	private String firstName;
	private String lastName;
	private String description;
	
	@OneToOne
	@JoinColumn(name = "id")
	private UserType userType;
	
	@ManyToMany(mappedBy = "students")
	private Set<Instructor> instructors = new HashSet<>();

	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Client> clients;
	
	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Resource> resources;
	
	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Resource> tools;
	
	@ManyToOne
	@JoinColumn(name = "id")
	private Location location;

	public Student(Long id, String imagePath, String firstName, String lastName, String description,
			UserType userType, Set<Instructor> instructors, Set<Client> clients, Set<Resource> resources,
			Set<Resource> tools, Location location) {
		super();
		this.id = id;
		this.imagePath = imagePath;
		this.firstName = firstName;
		this.lastName = lastName;
		this.description = description;
		this.userType = userType;
		this.instructors = instructors;
		this.clients = clients;
		this.resources = resources;
		this.tools = tools;
		this.location = location;
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

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public Set<Instructor> getInstructors() {
		return instructors;
	}

	public void setInstructors(Set<Instructor> instructors) {
		this.instructors = instructors;
	}

	public Set<Client> getClients() {
		return clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}

	public Set<Resource> getResources() {
		return resources;
	}

	public void setResources(Set<Resource> resources) {
		this.resources = resources;
	}

	public Set<Resource> getTools() {
		return tools;
	}

	public void setTools(Set<Resource> tools) {
		this.tools = tools;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	

}
