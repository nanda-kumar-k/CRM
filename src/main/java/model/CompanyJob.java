package model;

import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.Set;

@Entity
@Table(name = "company_job")
public class CompanyJob {
	
	@Id
	String username;
	String job_role;
	String description;
	float salary;
	int number_of_vacancy;
	

    @OneToMany(targetEntity = Company.class)
    private Set<Company> students = new HashSet<>();


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getJob_role() {
		return job_role;
	}


	public void setJob_role(String job_role) {
		this.job_role = job_role;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public float getSalary() {
		return salary;
	}


	public void setSalary(float salary) {
		this.salary = salary;
	}


	public int getNumber_of_vacancy() {
		return number_of_vacancy;
	}


	public void setNumber_of_vacancy(int number_of_vacancy) {
		this.number_of_vacancy = number_of_vacancy;
	}


	public Set<Company> getStudents() {
		return students;
	}


	public void setStudents(Set<Company> students) {
		this.students = students;
	}
	

}
