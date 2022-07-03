package com.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.entity.ComJob;
import com.entity.Company;
import com.entity.CompanyJob;
import com.model.EmployeeRemote;

@ManagedBean(name = "allget", eager = true)
public class AllGet{
	List<CompanyJob> L;
	String role;
	
	@EJB(lookup = "java:global/CRM/EmployeeManager!com.model.EmployeeRemote")
	EmployeeRemote ER;
	public List<CompanyJob> getList() {
		try {
			L = ER.getall(role);
		}
			catch (Exception e) {
             System.out.println(e.getMessage());
		}
		return L;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}