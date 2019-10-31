package com.collabera.finalProject.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Login implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", updatable = false, nullable = false)
	private Long id;
	
	@Column(name = "username", updatable = false, nullable = false, length = 25)
	private String username;
	
	@Column(name = "password", updatable = true, nullable = false, length = 25)
	private String password;
	
	@Column(name = "email", updatable = false, nullable = false, length = 25)
	private String email;
	
	@Column(name = "uType", updatable = false, nullable = false, length = 1)
	private int uType;

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public int getuType()
	{
		return uType;
	}

	public void setuType(int uType)
	{
		this.uType = uType;
	}
}
