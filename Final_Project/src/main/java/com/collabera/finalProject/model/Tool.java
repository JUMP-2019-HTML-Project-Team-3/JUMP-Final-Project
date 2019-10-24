package com.collabera.finalProject.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Tool implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tool_id", updatable = false, nullable = false)
	private Long id;
	
	@Column(name = "name", nullable = false, length = 50)
	private String name;
	
	@Column(name = "linkDownload", nullable = false, length = 100)
	private String linkDownLoad;
	
	@Column(name = "linkDocumentation", nullable = true, length = 100)
	private String linkDocumentation;
	
	@Column(name = "description", nullable = true, length = 250)
	private String description;
	
	//FK to Students
	@ManyToMany(mappedBy = "tools")
	private Set<Student> students = new HashSet<>();
	
	//Fk to Instructors
	@ManyToMany(mappedBy = "tools")
	private Set<Student> instructors = new HashSet<>();
	
	//Constructor with Fields
	public Tool(Long id, String name, String linkDownLoad, String linkDocumentation) {
		super();
		this.id = id;
		this.name = name;
		this.linkDownLoad = linkDownLoad;
		this.linkDocumentation = linkDocumentation;
	}

	public Tool() {
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

	public Set<Student> getStudents()
	{
		return students;
	}

	public void setStudents(Set<Student> students)
	{
		this.students = students;
	}
	
	public void addStudent(Student student) {
		students.add(student);
		student.getTools().add(this);
	}
	
	public void removeStudent(Student student) {
		students.remove(student);
		student.getTools().remove(this);
	}
	
}
