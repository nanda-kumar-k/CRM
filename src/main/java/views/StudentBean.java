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
	
//	@EJB(lookup = "java:global/CRM/CompanyController!controller.CompanyController")
//	@EJB(lookup ="java:global/CRM/CompanyController!controller.CompanyController")
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAck() {
		return ack;
	}
	public void setAck(String ack) {
		this.ack = ack;
	}
	
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
