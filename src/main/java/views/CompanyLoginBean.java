package views;

import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.Scanner;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import controller.CompanyLoginController;
import model.Client;
import model.CompanyJob;
import model.HomeCompany;
@ManagedBean(name = "CoLogin", eager = true)
public class CompanyLoginBean {
	String username;
	String password;
	String description;
	float salary;
	int number_of_vacancy;
	String location;
	String job_role;
	
	int l;
	public void loginClient() {
		try {
			CompanyLoginController cs = new CompanyLoginController();
			l = cs.login(username, password);
			if(l==1)
				FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "companyjobprofile.xhtml");
		}
			catch (Exception e) {
             System.out.println(e.getMessage());
		}
	}
	
	


	List<Client> L;
	public List<Client> findClient() {
		try {
			CompanyLoginController cs  = new CompanyLoginController();
			if(location!=null || job_role!=null) {
				L = cs.clientFind(location, job_role);
				return L;
			}
//			HomeCompany c = new HomeCompany();
//			if(l==1)
//				FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "index.xhtml");
		}
			catch (Exception e) {
             System.out.println(e.getMessage());
		}
		return L;
	}
	
	List<HomeCompany> s;
	public List<HomeCompany> companyAllJobs() {
		try {
			CompanyLoginController cs  = new CompanyLoginController();
			File myObj = new File("C:\\Users\\mvr_n\\workspace\\CRM\\company.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
//		        System.out.println(data);
		        username = data;
		        break;
		      }
	      myReader.close();
	      s =  cs.getAllJobs(username);
	      return s;
	      
		}
		catch (Exception e) {
            System.out.println(e.getMessage());
		}
		
		return s;
	}
	int cou;
	public void addjob() {
		try {
			CompanyJob cj = new CompanyJob();
			CompanyLoginController cs  = new CompanyLoginController();
			File myObj = new File("C:\\Users\\mvr_n\\workspace\\CRM\\company.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
//		        System.out.println(data);
		        cj.setUsername(data);
		        break;
		      }
		      File myO = new File("C:\\Users\\mvr_n\\workspace\\CRM\\count.txt");
		      Scanner myR = new Scanner(myO);
		      while (myR.hasNextLine()) {
		        String data = myR.nextLine();
		        cou = Integer.parseInt(data);
		        break;
		      }
		      myR.close();
		      cj.setId(cou);
		  System.out.println("tttttttttttttttttttttttttttttttttttttttttttttt");
		  System.out.println(description);
		  System.out.println(job_role);
		  System.out.println(description);
		  System.out.println(cj.getUsername());
	      myReader.close();
	      cj.setJob_role(job_role);
	      cj.setDescription(description);
	      cj.setSalary(salary);
	      cj.setNumber_of_vacancy(number_of_vacancy);
	      FileWriter myWriter = new FileWriter("C:\\Users\\mvr_n\\workspace\\CRM\\count.txt");
	      String temp =String.valueOf(cou+1);
	      myWriter.write(temp);
	      myWriter.close();
	      l = cs.jobadd(cj);
	      if(l==1) {
			  FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "companyjobprofile.xhtml");
	      }
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getJob_role() {
		return job_role;
	}
	public void setJob_role(String job_role) {
		this.job_role = job_role;
	}
	public int getL() {
		return l;
	}
	public void setL(int l) {
		this.l = l;
	}
	
	
	
	
	
	
	
	
}
