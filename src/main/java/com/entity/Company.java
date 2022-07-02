package com.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Companies")
public class Company implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	@Id
	String username;
	String password;
	String companyname;
	String email;
	String companylocation;


	public String getUserName() {
		return username;
	}

	public void setUserName(String name) {
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
	
	public String getName() {
		return companyname;
	}

	public void setName(String companyname) {
		this.companyname = companyname;
	}
	
	public String getCompanyLocation() {
		return companylocation;
	}

	public void setCompanyLocation(String companylocation) {
		this.companylocation = companylocation;
	}
}
