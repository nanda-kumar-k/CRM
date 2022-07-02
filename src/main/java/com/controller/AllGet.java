package com.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.entity.Company;
import com.model.EmployeeRemote;

@ManagedBean(name = "allget", eager = true)
public class AllGet{
	List<Company> L;
	@EJB(lookup = "java:global/CRM/EmployeeManager!com.model.EmployeeRemote")
	EmployeeRemote ER;
	public List<Company> getList() {
		try {
			
			L = ER.getall();
		}
			catch (Exception e) {
             System.out.println(e.getMessage());
		}
		return L;
	}
}