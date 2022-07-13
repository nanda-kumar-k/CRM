package views;

import javax.faces.bean.ManagedBean;



import javax.faces.context.FacesContext;

import controller.ClientLoginController;





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
}
