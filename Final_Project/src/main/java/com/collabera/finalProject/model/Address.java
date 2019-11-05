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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Address implements Serializable, Model {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id", updatable = false) // establishes column value id as final and never null
	private Long id;
	
	@Column(name = "streetNumber", nullable = false, length = 10)
	private String streetNumber; // street number
	
	@Column(name = "streetName", nullable = false, length = 50)
	private String streetName; // street name
	//Is allowed to be null as you may not have a suite number
	
	@Column(name = "suiteNo", nullable = true, length = 10)
	private String suiteNo; // apartment/suite number
	
	@Column(name = "township", nullable = false, length = 50)
	private String township;
	
	@Column(name = "state", nullable = false, length = 50)
	private String state;
	
	@Column(name = "zip", nullable = false, length = 10)
	private String zip; // abbreviations are the exception to camelCase naming convention rules
	
	@Column(name = "country", nullable = false, length = 50)
	private String country;
	
	//Locations
	@OneToMany(mappedBy = "address", targetEntity = Location.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Location> locations = new HashSet<Location>();
	
	//Clients
	@OneToMany(mappedBy = "address", targetEntity = Client.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Client> clients = new HashSet<Client>();

	//Constructor
	public Address(Long id, String streetNumber, String streetName, String suiteNo, String township, String state,
			String zip, String country) {
		super();
		this.id = id;
		this.streetNumber = streetNumber;
		this.streetName = streetName;
		this.suiteNo = suiteNo;
		this.township = township;
		this.state = state;
		this.zip = zip;
		this.country = country;
	}

	public Address() {
		// TODO Auto-generated constructor stub
	}

	//Getters and Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStreetNumber() {
		return streetNumber;
	}
	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getSuiteNo() {
		return suiteNo;
	}
	public void setSuiteNo(String suiteNo) {
		this.suiteNo = suiteNo;
	}
	public String getTownship() {
		return township;
	}
	public void setTownship(String township) {
		this.township = township;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	public Set<Location> getLocations() {
		return locations;
	}

	public void setLocations(Set<Location> locations) {
		this.locations = locations;
	}

	public Set<Client> getClients() {
		return clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}	
}
