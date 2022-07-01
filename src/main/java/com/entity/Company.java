package com.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "company")
public class Company implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	@Id
	String username;
	
	String password;
	
	String phoneno;
	String email;


	public String getName() {
		return username;
	}

	public void setName(String name) {
		this.username = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return phoneno;
	}

	public void setPhone(String phoneno) {
		this.phoneno = phoneno;
	}

}
