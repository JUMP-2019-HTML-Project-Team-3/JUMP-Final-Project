package com.collabera.finalProject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tool {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	private String name;
	private String linkDownLoad;
	private String linkDocumentation;
	
	//Constructor with Fields
	public Tool(Long id, String name, String linkDownLoad, String linkDocumentation) {
		super();
		this.id = id;
		this.name = name;
		this.linkDownLoad = linkDownLoad;
		this.linkDocumentation = linkDocumentation;
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
	
}
