package com.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.model.EmployeeRemote;

@ManagedBean(name = "cinsert", eager = true)
public class CInsert {
	   
	   String jobRole;
	   String username;
	   int noofjobs;
	   String desofjob;
	   double salary;
	@EJB(lookup = "java:global/CRM/EmployeeManager!com.model.EmployeeRemote")
	EmployeeRemote ER;
	
	int l;
	public void getList() {
		try {
			
			l = ER.writeData111(getNoofjobs(),getDesofjob(),getSalary(),jobRole,username);
			if(l==1)
				FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "company.xhtml");
		}
			catch (Exception e) {
             System.out.println(e.getMessage());
		}
	}
	public int getNoofjobs() {
		return noofjobs;
	}
	public void setNoofjobs(int noofjobs) {
		this.noofjobs = noofjobs;
	}
	
	public void setJobRole(String jobrole) {
		this.jobRole = jobrole;
	}
	public String getJobRole() {
		return jobRole;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsername() {
		return username;
	}
	public String getDesofjob() {
		return desofjob;
	}
	public void setDesofjob(String desofjob) {
		this.desofjob = desofjob;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	}