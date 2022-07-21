package views;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import controller.HomeCompanyController;
import model.HomeCompany;


@ManagedBean(name = "Homeitems", eager = true)
public class HomeCompanyBean {
	
	String location;
	String job_role;
	
	
	int l;

	List<HomeCompany> L;
	public List<HomeCompany> findHome() {
		try {
			HomeCompanyController cs  = new HomeCompanyController();
			if(location!=null || job_role!=null) {
				L = cs.searchCompany(location, job_role);
				return L;
			}
			else {
				L = cs.findCompany();
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
	

}
