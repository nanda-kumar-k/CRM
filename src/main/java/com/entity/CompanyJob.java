package com.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CompaniesJobs")
public class CompanyJob implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	@Id
	int id;
	String username;
	String jobrole;
	String desofjob;
	int noofjobs;
	double salary;


	public String getUserName() {
		return username;
	}

	public void setUserName(String name) {
		this.username = name;
	}

	public String getJobrole() {
		return jobrole;
	}

	public void setJobrole(String jobrole) {
		this.jobrole = jobrole;
	}

	public String getDesofjob() {
		return desofjob;
	}

	public void setDesofjob(String desofjob) {
		this.desofjob = desofjob;
	}

	public int getNoofjobs() {
		return noofjobs;
	}

	public void setNoofjobs(int noofjobs) {
		this.noofjobs = noofjobs;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
}
