package views;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.faces.bean.ManagedBean;



import javax.faces.context.FacesContext;

import controller.ClientLoginController;
import model.Client;
import model.Company;
import model.HomeCompany;





@ManagedBean(name = "ClLogin", eager = true)
public class ClientLoginBean {
	String username;
	String password;
	
	int l;
	public void loginClient() {
		try {
			ClientLoginController cs = new ClientLoginController();
			l = cs.login(username, password);
			if(l==1)
				FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "mainclientprofile.xhtml");
		}
			catch (Exception e) {
             System.out.println(e.getMessage());
		}
	}
	
	List<Client> ci;
	public List<Client> ProfileClient(){
		try {
			ClientLoginController cs = new ClientLoginController();
			File myObj = new File("C:\\Users\\mvr_n\\workspace\\CRM\\client.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        System.out.println(data);
		        username = data;
		        break;
		      }
	      myReader.close();
	      ci = cs.clientProfile(username);
	      return ci;
		}
		catch (Exception e) {
            System.out.println(e.getMessage());
		}
		return ci;
	}
	
	
	
	List<HomeCompany> cip;
	public List<HomeCompany> mainClientProfile(){
		try {
			ClientLoginController cs = new ClientLoginController();
			File myObj = new File("C:\\Users\\mvr_n\\workspace\\CRM\\client.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        System.out.println(data);
		        username = data;
		        break;
		      }
	      myReader.close();
	      cip = cs.clientMainProfile(username);
	      return cip;
		}
		catch (Exception e) {
            System.out.println(e.getMessage());
		}
		return cip;
	}
	
	List<Company> di;
	public List<Company> direction() {
		FacesContext fc = FacesContext.getCurrentInstance();
	      Map<String,String> params = 
	         fc.getExternalContext().getRequestParameterMap();
	      String user =  params.get("username"); 
	      System.out.println("ssssssssssssssssssssssssssssssssssssssssss");
	      System.out.println(user);
	      ClientLoginController cs = new ClientLoginController();
	      di = cs.getDirections(user);
	      FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "directions.xhtml");
	     return di;
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
}
