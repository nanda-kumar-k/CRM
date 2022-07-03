package com.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.entity.ComJob;
import com.entity.Company;
import com.entity.CompanyJob;
import com.entity.Employee;
import com.model.EmployeeRemote;

@ManagedBean(name = "clientget", eager = true)
public class ClientGet{
	List<Employee> L;
	
	@EJB(lookup = "java:global/CRM/EmployeeManager!com.model.EmployeeRemote")
	EmployeeRemote ER;
	public List<Employee> getList() {
		try {
			L = ER.clientget();
		}
			catch (Exception e) {
             System.out.println(e.getMessage());
		}
		return L;
	}
}