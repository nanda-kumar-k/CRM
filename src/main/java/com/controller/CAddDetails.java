package com.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.model.EmployeeRemote;

@ManagedBean(name = "creg", eager = true)
public class CAddDetails {
	   String name;
	   String username;
	   String password;
	   String email;
	   String location;
	@EJB(lookup = "java:global/CRM/EmployeeManager!com.model.EmployeeRemote")
	EmployeeRemote ER;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return username;
	}
	public void setName(String name) {
		this.name = name;
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
	public void setLocation(String location) {
		this.location = location;
	}
	public String getLocation() {
		return location;
	}
	int l;
	public void getList() {
		try {
			
			l = ER.cwriteData(username,password,email,name,location);
			if(l==1)
				FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "regsuccess.xhtml");
		}
			catch (Exception e) {
             System.out.println(e.getMessage());
		}
	}
	}