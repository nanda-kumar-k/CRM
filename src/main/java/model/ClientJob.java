package model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@IdClass(PK_CC.class)
@Table(name="client_job")
public class ClientJob  {
	
	
	
	@Id
	String client_username;
	
	@Id
	String company_username;
	String client_status;
	String company_status;
	
	@OneToMany(targetEntity = Company.class)
    private Set<Company> students = new HashSet<>();
	
	

	public String getClient_username() {
		return client_username;
	}

	public void setClient_username(String client_username) {
		this.client_username = client_username;
	}

	public String getCompany_username() {
		return company_username;
	}

	public void setCompany_username(String company_username) {
		this.company_username = company_username;
	}

	public String getClient_status() {
		return client_status;
	}

	public void setClient_status(String client_status) {
		this.client_status = client_status;
	}

	public String getCompany_status() {
		return company_status;
	}

	public void setCompany_status(String company_status) {
		this.company_status = company_status;
	}

	public Set<Company> getStudents() {
		return students;
	}

	public void setStudents(Set<Company> students) {
		this.students = students;
	}
	

}
