package views;

import java.io.File;
import java.util.List;
import java.util.Scanner;

import javax.faces.bean.ManagedBean;

import controller.CompanyJobProfileController;
import model.CompanyJob;
import model.HomeCompany;

@ManagedBean(name = "Cojobprofile", eager = true)
public class CompanyJobProfileBean {
	String username;
	String job_role;
	String description;
	float salary;
	int number_of_vacancy;
	
	List<HomeCompany> L;
	public List<HomeCompany> companyjobs() {
		try {
			CompanyJobProfileController cpc = new CompanyJobProfileController();
			
			File myObj = new File("C:\\Users\\mvr_n\\workspace\\CRM\\company.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
//		        System.out.println(data);
		        username = data;
		        break;
		      }
		      myReader.close();
		      L = cpc.allCompanyjob(username);
		      return L;
		}
			catch (Exception e) {
             System.out.println(e.getMessage());
		}
		return L;
	}
	
	public void addnewjobrole() {
		try {
			CompanyJob cj = new CompanyJob();
			File myObj = new File("C:\\Users\\mvr_n\\workspace\\CRM\\company.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        username = data;
		        break;
		      }
		      myReader.close();
		 
		      cj.setDescription(description);
		      cj.setUsername(username);
		      cj.setJob_role(job_role);
		      cj.setNumber_of_vacancy(number_of_vacancy);
		      cj.setSalary(salary);
		      CompanyJobProfileController cpc = new CompanyJobProfileController();
		      cpc.addcompanyjob(cj);
		      
			
		}
			catch (Exception e) {
             System.out.println(e.getMessage());
		}
		
		
	}
	
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
	

}
