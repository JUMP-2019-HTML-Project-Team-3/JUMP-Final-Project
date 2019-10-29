package com.collabera.finalProject.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

public class AddressDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String streetNumber; // street number
	
	private String streetName; // street name
	//Is allowed to be null as you may not have a suite number
	
	private String suiteNo; // apartment/suite number
	
	private String township;
	
	private String state;
	
	private String zip; // abbreviations are the exception to camelCase naming convention rules
	
	private String country;
	
	private LocationDTO location;
	
	private ClientDTO client;

	//Constructor
	public AddressDTO(Long id, String streetNumber, String streetName, String suiteNo, String township, String state,
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

	public AddressDTO() {
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
}
