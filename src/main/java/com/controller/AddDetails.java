package com.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.model.EmployeeRemote;

@ManagedBean(name = "reg", eager = true)
public class AddDetails {
	   String name;
	   String edu;
	   String username;
	   String password;
	   String email;
	   String phone;
	   String jobRole;
	   String location;
	@EJB(lookup = "java:global/CRM/EmployeeManager!com.model.EmployeeRemote")
	EmployeeRemote ER;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setEdu(String edu) {
		this.edu = edu;
	}
	public String getEdu() {
		return edu;
	}
	public void setJobRole(String jobrole) {
		this.jobRole = jobrole;
	}
	public String getJobRole() {
		return jobRole;
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
			
			l = ER.writeData(username,password,email,phone,name,edu,jobRole,location);
			if(l==1)
				FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "regsuccess.xhtml");
		}
			catch (Exception e) {
             System.out.println(e.getMessage());
		}
	}
	}