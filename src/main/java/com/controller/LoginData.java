package com.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.ejb.EJB;

import com.entity.Employee;
import com.model.EmployeeRemote;

@ManagedBean(name = "login", eager = true)
public class LoginData {
	String username;
	String password;
	String eduinfo;
	String name;
	String phoneno;
	String email;
	String joblocation;
	String jobrole;
	
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
	int l;
	public void getList() {
		try {
			Employee E = ER.loginData(username,password);
			setEduinfo(E.getEdu());
			setName(E.getName());
			setPhoneno(E.getPhone());
			setEmail(E.getEmail());
			setJoblocation(E.getJobLocation());
			setJobrole(E.getJobRole());
			if(E!=null)
				FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "client.xhtml");
		}
			catch (Exception e) {
             System.out.println(e.getMessage());
		}
	}
	public String getEduinfo() {
		return eduinfo;
	}
	public void setEduinfo(String eduinfo) {
		this.eduinfo = eduinfo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getJoblocation() {
		return joblocation;
	}
	public void setJoblocation(String joblocation) {
		this.joblocation = joblocation;
	}
	public String getJobrole() {
		return jobrole;
	}
	public void setJobrole(String jobrole) {
		this.jobrole = jobrole;
	}
	}