package com.collabera.finalProject.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false) // establishes column value id as final and never null
	private Long id;
	@Column(name = "streetNumber", nullable = false, length = 10)
	private String streetNumber; // street number
	@Column(name = "streetName", nullable = false, length = 50)
	private String streetName; // street name
	@Column(name = "suiteNo", length = 10)
	private String suiteNo; // apartment/suite number
	@Column(name = "township", nullable = false, length = 50)
	private String township;
	@Column(name = "state", nullable = false, length = 50)
	private String state;
	@Column(name = "ZIP", nullable = false, length = 10)
	private String ZIP; // abbreviations are the exception to camelCase naming convention rules
	@Column(name = "country", nullable = false, length = 50)
	private String country;
	
	public Address(Long id, String streetNumber, String streetName, String suiteNo, String township, String state,
			String zIP, String country) {
		super();
		this.id = id;
		this.streetNumber = streetNumber;
		this.streetName = streetName;
		this.suiteNo = suiteNo;
		this.township = township;
		this.state = state;
		ZIP = zIP;
		this.country = country;
	}
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
	public String getZIP() {
		return ZIP;
	}
	public void setZIP(String zIP) {
		ZIP = zIP;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}	

	
}
