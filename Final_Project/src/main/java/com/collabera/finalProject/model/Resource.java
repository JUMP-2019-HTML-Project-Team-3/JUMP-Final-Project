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
public class Resource implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "resource_id", updatable = false, nullable = false)
	private Long id;
	
	@Column(name = "name", nullable = false, length = 50)
	private String name;
	
	@Column(name = "link", nullable = false, length = 100)
	private String link;
	
	@Column(name = "description", nullable = true, length = 250)
	private String description;
	
	//Fk to Students
	@ManyToMany(mappedBy = "resources")
	private Set<Student> students = new HashSet<>();
	
	//FK to Instructors
	@ManyToMany(mappedBy = "resources")
	private Set<Instructor> instructors;
	
	//Constructor with Fields
	public Resource(Long id, String name, String link, String description, Set<Student> students, Set<Instructor> instructors) {
		this.id = id;
		this.name = name;
		this.link = link;
		this.description = description;
		this.students = students;
		this.instructors = instructors;
	}

	public Resource() {
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
		student.getResources().add(this);
	}
	
	public void removeStudent(Student student) {
		students.remove(student);
		student.getResources().remove(this);
	}
	
}
