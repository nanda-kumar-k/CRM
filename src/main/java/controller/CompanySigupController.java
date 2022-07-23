package controller;

import java.io.FileWriter;
import java.io.IOException;

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
		em.close();
		emf.close();
		try {
		      FileWriter myWriter = new FileWriter("C:\\Users\\mvr_n\\workspace\\CRM\\company.txt");
		      myWriter.write(company.getUsername());
		      myWriter.close();
		      return 1;
		      
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
		return 1;
	}
	
	
	public int updatelonglat(Company company) {
		Company f = em.find(Company.class, company.getUsername());
        em.getTransaction().begin();
        f.setLatitude(company.getLatitude());
        f.setLongitude(company.getLongitude());
        em.getTransaction().commit();
        em.close();
		emf.close();
        return 1;
    }

	
}
