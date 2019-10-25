package com.collabera.finalProject.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Location implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "location_id", updatable = false, nullable = false) // establishes column value id as final and never null
	private Long id;
	
	@Column(name = "imagePath", nullable = false, length = 100)
	private String imagePath;
	
	@Column(name = "name", nullable = false, length = 50)
	private String name;
	
	@Column(name = "phoneNo", nullable = true, length = 14)
	private String phoneNo; // phone number has default value as annotated

	@OneToOne
	@JoinColumn(name = "address_id", referencedColumnName = "address_id")
	private Address address;

	@JsonBackReference
	@OneToMany(mappedBy = "location", targetEntity = Student.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Student> students = new HashSet<Student>();

    @ManyToMany(mappedBy = "locations")
	private Set<Instructor> instructors = new HashSet<Instructor>();

	public Location(Long id, String imagePath, String name, String phoneNo, Address address, Set<Student> students,
			Set<Instructor> instructors) {
		super();
		this.id = id;
		this.imagePath = imagePath;
		this.name = name;
		this.phoneNo = phoneNo;
		this.address = address;
		this.students = students;
		this.instructors = instructors;
	}

	public Location() {
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Set<Instructor> getInstructors() {
		return instructors;
	}

	public void setInstructors(Set<Instructor> instructors) {
		this.instructors = instructors;
	}
	
	public void addInstructor(Instructor instructor) {
		instructors.add(instructor);
		instructor.getLocations().add(this);
	}
	
	public void removeInstructor(Instructor instructor) {
		instructors.remove(instructor);
		instructor.getLocations().remove(this);
	}
}
