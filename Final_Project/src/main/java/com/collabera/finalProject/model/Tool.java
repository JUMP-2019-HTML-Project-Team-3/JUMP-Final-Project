package com.collabera.finalProject.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tool implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	@Column(name = "name", nullable = false, length = 50)
	private String name;
	
	@Column(name = "linkDownload", nullable = false, length = 100)
	private String linkDownLoad;
	
	@Column(name = "linkDocumentation", nullable = true, length = 100)
	private String linkDocumentation;
	
	@Column(name = "description", nullable = true, length = 250)
	private String description;
	
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
