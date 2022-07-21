package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Client;
import model.Company;

public class CompanyLoginController {
	private EntityManager em;
	private EntityManagerFactory emf;
	

	public CompanyLoginController() {
	    this.emf = Persistence.createEntityManagerFactory("CRM");
	    this.em = this.emf.createEntityManager();
	}
	
	public int login(String username, String password) {	
		Company C = em.find(Company.class, username);
		if(C.getPassword().equals(password)) {
			em.close();
			emf.close();
			return 1;
		}
		em.close();
		emf.close();
		return 0;
	}
}
