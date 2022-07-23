package views;

import java.io.File;
import java.util.List;
import java.util.Scanner;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import controller.ClientLoginController;
import controller.CrmAdminController;
import model.Client;
import model.Company;
import model.CrmAdmin;

@ManagedBean(name="admin", eager=true)
public class CrmAdminBean {
	
	String username;
	String password;
//	
//	@EJB(lookup ="java:global/CRM/CrmAdminController!controller.CrmAdminController")
	
	int t=0;
	public void calllogin() {
		CrmAdminController ad = new CrmAdminController();
		 t = ad.logins(username, password);
		if(t==1) {
			FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "dashboard.jsf");
		}
		
	}
	
	
	List<Client> L;
	public List<Client> getallclient(){
		CrmAdminController ad = new CrmAdminController();
		L = ad.allclient();
		return L;
	}
	
	List<Company> S;
	public List<Company> getallcompany(){
		CrmAdminController ad = new CrmAdminController();
		S= ad.allcompany();
		return S;
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
