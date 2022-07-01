package com.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.ejb.EJB;

import com.model.EmployeeRemote;

@ManagedBean(name = "login", eager = true)
public class LoginData {
	String username;
	String password;
	
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
			l = ER.loginData(username,password);
			if(l==1)
				FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "loginsuccess.xhtml");
		}
			catch (Exception e) {
             System.out.println(e.getMessage());
		}
	}
	}