package com.collabera.finalProject.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Client implements  Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	@Column(name = "imagePath", nullable = true, length = 100)
	private String imagePath;
	
	@Column(name = "name", nullable = false, length = 50)
	private String name;
	
	@Column(name = "phone", nullable = true, length = 10)
	private String phone;
	
	@Column(name = "description", nullable = true, length = 250)
	private String description;
	
//	@OneToOne
//	@JoinColumn(name = "id")
//	private Address address;
	
//	@ManyToMany(mappedBy = "clients")
//	private Set<Student> students = new HashSet<>();

	//Constructor
	public Client(Long id, String imagePath, String name, String phone, String description, Address address, Set<Student> students) {
		this.id = id;
		this.imagePath = imagePath;
		this.name = name;
		this.phone = phone;
		this.description = description;
//		this.address = address;
	}

	public Client() {
		// TODO Auto-generated constructor stub
	}

	//Getters and Setters
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

//	public Address getAddress() {
//		return address;
//	}
//
//	public void setAddress(Address address) {
//		this.address = address;
//	}

	

}
