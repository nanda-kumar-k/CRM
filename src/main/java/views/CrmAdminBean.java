package views;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import controller.CrmAdminController;

@ManagedBean(name="admin", eager=true)
public class CrmAdminBean {
	
	String username;
	String password;
//	
//	@EJB(lookup ="java:global/CRM/CrmAdminController!controller.CrmAdminController")
	
	CrmAdminController ad;
	int t=0;
	public void calllogin() {
		System.out.println("yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
		System.out.println(password);
		 t = ad.logins("nandu", "nandu");
		if(t==1) {
			FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "admin.jsf");
		}
		else {
			FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "admin.jsf");
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

}
