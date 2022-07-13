package views;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;


import controller.CompanyLoginController;
@ManagedBean(name = "CoLogin", eager = true)
public class CompanyLoginBean {
	String username;
	String password;
	
	int l;
	public void loginClient() {
		try {
			CompanyLoginController cs = new CompanyLoginController();
			l = cs.login(username, password);
			if(l==1)
				FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "index.xhtml");
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
	public int getL() {
		return l;
	}
	public void setL(int l) {
		this.l = l;
	}
}
