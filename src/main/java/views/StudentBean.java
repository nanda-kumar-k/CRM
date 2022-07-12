package views;


import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import controller.CompanyController;
import model.Company;
import model.CompanyJob;


@ManagedBean(name="stu", eager=true)
public class StudentBean {
	
	int id;
	String name;
	String ack;
	
	public void callinsert() {
		CompanyJob sc = new CompanyJob();
        CompanyController cc = new CompanyController();
        sc.setUsername("nanda kumar");
        sc.setJob_role("kumar");
        cc.addjob(sc);
	}
	public void find() {
		CompanyController cc = new CompanyController();
		cc.finds();
	}
	
	
}
