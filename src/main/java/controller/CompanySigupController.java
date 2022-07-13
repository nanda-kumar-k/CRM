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
	
	
	public int updatelonglat(Company company) {
		Company f = em.find(Company.class, company.getUsername());
        em.getTransaction().begin();
        f.setLatitude(company.getLatitude());
        f.setLongitude(company.getLongitude());
        em.getTransaction().commit();
        return 1;
    }

	
}
