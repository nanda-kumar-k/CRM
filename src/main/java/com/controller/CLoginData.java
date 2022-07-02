package com.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.ejb.EJB;

import com.model.EmployeeRemote;

@ManagedBean(name = "clogin", eager = true)
public class CLoginData {
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
			l = ER.cloginData(username,password);
			if(l==1)
				FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "index.jsf");
		}
			catch (Exception e) {
             System.out.println(e.getMessage());
		}
	}
	}