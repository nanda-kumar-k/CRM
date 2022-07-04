package com.model;

import java.util.List;

import com.entity.ComJob;
import com.entity.Company;
import com.entity.CompanyJob;
import com.entity.Employee;

public interface EmployeeRemote {

	public int writeData(String username,String password,String email,String phone,String name,String edu,String jobRole,String location);
	public Employee loginData(String username,String password);
	public int cwriteData(String username,String password,String email,String name,String location);
	public int cloginData(String username,String password);
	public List<CompanyJob> getall(String jobrole);
	public int writeData111(int noofjob,String desofjob,double salary,String jobrole,String username);
	public List<Employee> clientget();
}
