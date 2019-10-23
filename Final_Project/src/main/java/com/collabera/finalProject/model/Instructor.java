package com.collabera.finalProject.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

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
	
	//FK to User
	@OneToOne
	@JoinColumn(name = "id")
	private User user;
	
	//FK to UserType
	@OneToOne
	@JoinColumn(name = "id")
	private UserType userType;
	
	//FK to Student
	@ManyToMany(mappedBy = "instructors")
	private Set<Student> students = new HashSet<>();
    
    //FK to Resource
	@ManyToMany
	@JoinTable(
		name = "instructor_resource",
		joinColumns = { @JoinColumn(name = "fk_instructor")},
		inverseJoinColumns = { @JoinColumn(name = "fk_resource") } )
	private Set<Resource> resources = new HashSet<>();
    
    //FK to Tool
	@ManyToMany
	@JoinTable(
		name = "instructor_tool",
		joinColumns = { @JoinColumn(name = "fk_instructor")},
		inverseJoinColumns = { @JoinColumn(name = "fk_tool") } )
	private Set<Tool> tools = new HashSet<>();
    
    //FK to Location
	@ManyToMany
	@JoinTable(
		name = "instructor_location",
		joinColumns = { @JoinColumn(name = "fk_instructor")},
		inverseJoinColumns = { @JoinColumn(name = "fk_location") } )
    private Set<Location> locations = new HashSet<>();

    //Constructor Using Fields
	public Instructor(Long id, String firstName, String lastName, String description, User user, UserType userType,
			Set<Student> students, Set<Resource> resources, Set<Tool> tools) {
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


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
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


	public Instructor() {
	}


	public Set<Location> getLocations() {
		return locations;
	}


	public void setLocations(Set<Location> locations) {
		this.locations = locations;
	}
	
	// Add/Remove Student
	public void addStudent(Student s)
	{
		this.students.add(s);
		s.getInstructors().add(this);
	}
	
	public void removeStudent(Student s)
	{
		this.students.remove(s);
		s.getInstructors().remove(this);
	}
	
	// Add/Remove Resource
	public void addResource(Resource r)
	{
		this.resources.add(r);
	}
	
	public void removeResource(Resource r)
	{
		this.resources.remove(r);
	}
	
	// Add/Remove Tool
	public void addTool(Tool t)
	{
		this.tools.add(t);
	}
	
	public void removeTool(Tool t)
	{
		this.tools.remove(t);
	}
}
