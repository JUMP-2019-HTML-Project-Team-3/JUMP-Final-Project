package com.collabera.finalProject.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


@Entity
public class Student implements  Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	private String imagePath;
	private String firstName;
	private String lastName;
	private String description;
	
	@OneToOne
	@JoinColumn(name = "id")
	private User user;
	
	@OneToOne
	@JoinColumn(name = "id")
	private UserType userType;
	
	//Instructors
    @ManyToMany
    @JoinTable(name = "student_instructor",
    joinColumns = { @JoinColumn(name = "fk_student") },
    inverseJoinColumns = { @JoinColumn(name = "fk_instructor") })
	private Set<Instructor> instructors = new HashSet<Instructor>();

    //Clients
	@ManyToMany
	@JoinTable(
		name = "student_client",
		joinColumns = { @JoinColumn(name = "fk_student")},
		inverseJoinColumns = { @JoinColumn(name = "fk_client") } )
	private Set<Client> clients = new HashSet<Client>();
	
	//Resources
	@ManyToMany
	@JoinTable(
		name = "student_resource",
		joinColumns = { @JoinColumn(name = "fk_student")},
		inverseJoinColumns = { @JoinColumn(name = "fk_resource") } )
	private Set<Resource> resources = new HashSet<Resource>();
	
	//Tools
	@ManyToMany
	@JoinTable(name = "student_tool",
	joinColumns = { @JoinColumn(name = "fk_student") },
	inverseJoinColumns =  { @JoinColumn(name = "fk_tool") })
	private Set<Tool> tools = new HashSet<Tool>();
	
	//Locations
	@ManyToOne
	@JoinColumn(name = "location_id")
	private Location location;

	public Student(Long id, String imagePath, String firstName, String lastName, String description, User user,
			UserType userType, Set<Instructor> instructors, Set<Client> clients, Set<Resource> resources,
			Set<Tool> tools, Location location) {
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

	public Student() {
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
	
	public void addClient(Client client) {
		clients.add(client);
		client.getStudents().add(this);
	}
	
	public void removeClient(Resource resource) {
		resources.remove(resource);
		resource.getStudents().remove(this);
	}

	public Set<Resource> getResources() {
		return resources;
	}

	public void setResources(Set<Resource> resources) {
		this.resources = resources;
	}
	
	public void addResource(Resource resource) {
		resources.add(resource);
		resource.getStudents().add(this);
	}
	
	public void removeResource(Resource resource) {
		resources.remove(resource);
		resource.getStudents().remove(this);
	}

	public Set<Tool> getTools() {
		return tools;
	}

	public void setTools(Set<Tool> tools) {
		this.tools = tools;
	}
	
	public void addTool(Tool tool) {
		tools.add(tool);
	}
	
	public void removeTool(Tool tool) {
		tools.remove(tool);
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
		
}
