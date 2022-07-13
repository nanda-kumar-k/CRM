package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Company;

public class CompanySigupController {
	private EntityManager em;
	private EntityManagerFactory emf;
	

	public CompanySigupController() {
	    this.emf = Persistence.createEntityManagerFactory("CRM");
	    this.em = this.emf.createEntityManager();
	}
	
	public int signup(Company company) {	
		em.getTransaction().begin();
		em.persist(company);
		em.getTransaction().commit();
		return 1;
	}

	
}
