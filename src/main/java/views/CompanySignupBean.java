package views;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import controller.CompanySigupController;
import model.Company;

@ManagedBean(name = "CoSignup", eager = true)
public class CompanySignupBean {
	String username;
	String password;
	String name;
	String location;
	String email;
	String phone_number;
	float longitude;
	float latitude;
	
	
	int l;
	public void signupCompnay() {
		try {
			Company cs = new Company();
			CompanySigupController csc = new CompanySigupController();
			cs.setUsername(username);
			cs.setPassword(password);
			cs.setName(name);
			cs.setLocation(location);
			cs.setEmail(email);
			cs.setPhone_number(phone_number);
			cs.setLongitude(longitude);
			cs.setLatitude(latitude);
			l = csc.signup(cs);
			if(l==1) {
				FileWriter myWriter = new FileWriter("client.txt");
			    myWriter.write(username);
			    myWriter.close();
			    System.out.println("Successfully wrote to the file.");
				FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "companymap.xhtml");
		}
		}
			catch (Exception e) {
             System.out.println(e.getMessage());
		}
	}
	
	
	public void addlonglat() {
		String user = null;
		try {
			Company cs = new Company();
			CompanySigupController csc = new CompanySigupController();
			File myObj = new File("C:\\Users\\mvr_n\\workspace\\CRM\\company.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        System.out.println(data);
		        user = data;
		        break;
		      }
		      myReader.close();
			cs.setUsername(user);
			cs.setLongitude(longitude);
			cs.setLatitude(latitude);
			l = csc.updatelonglat(cs);
			if(l==1)
				FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "companyjobprofile.xhtml");
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
}
