package com.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Client")
public class Employee implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	@Id
	String username;
	String name;
	String eduinfo;
	String password;
	String phoneno;
	String email;
	String joblocation;
	String jobrole;


	public String getUserName() {
		return username;
	}

	public void setUserName(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getEdu() {
		return username;
	}

	public void setEdu(String eduinfo) {
		this.eduinfo = eduinfo;
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
	
	public String getJobRole() {
		return jobrole;
	}

	public void setJobRole(String jobrole) {
		this.jobrole = jobrole;
	}
	
	public String getJobLocation() {
		return joblocation;
	}

	public void setJobLocation(String joblocation) {
		this.joblocation = joblocation;
	}

}
