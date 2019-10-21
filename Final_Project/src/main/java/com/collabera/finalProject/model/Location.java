package com.collabera.finalProject.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ColumnDefault;

@Entity
public class Location implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false) // establishes column value id as final and never null
	private Long id;
	
	@Column(name = "imagePath", nullable = false, length = 100)
	private String imagePath;
	
	@Column(name = "name", nullable = false, length = 50)
	private String name;
	
	@Column(name = "phoneNo", nullable = true, length = 14)
	@ColumnDefault("(×××) ×××-××××")
	private String phoneNo; // phone number has default value as annotated

//	@OneToOne
//	@JoinColumn(name = "id")
	private Address address;

//	@OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
	//private Set<Student> students = new HashSet<>();

//    @ManyToMany(cascade = { CascadeType.ALL })
//    @JoinTable(
//        name = "Instructor", 
//        joinColumns = { @JoinColumn(name = "id") }, 
//        inverseJoinColumns = { @JoinColumn(name = "id") }
//    )
	//private Set<Instructor> instructors = new HashSet<Instructor>();

	public Location(Long id, String imagePath, String name, String phoneNo, Address address, Set<Student> students,
			Set<Instructor> instructors) {
		super();
		this.id = id;
		this.imagePath = imagePath;
		this.name = name;
		this.phoneNo = phoneNo;
		this.address = address;
		//this.students = students;
		//this.instructors = instructors;
	}

	public Location() {
		// TODO Auto-generated constructor stub
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

//	public Set<Student> getStudents() {
//		return students;
//	}
//
//	public void setStudents(Set<Student> students) {
//		this.students = students;
//	}

//	public Set<Instructor> getInstructors() {
//		return instructors;
//	}

//	public void setInstructors(Set<Instructor> instructors) {
//		this.instructors = instructors;
//	}
	
	
}
