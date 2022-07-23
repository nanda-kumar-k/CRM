package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.Client;
import model.Company;
import model.CrmAdmin;

public class CrmAdminController {
	
	private EntityManager entityManager;
	private EntityManagerFactory emf;

	public CrmAdminController() {
	    this.emf = Persistence.createEntityManagerFactory("CRM");
	    this.entityManager = this.emf.createEntityManager();
	}
	
	public int logins(String username, String password) {
		CrmAdmin f = entityManager.find(CrmAdmin.class, username);
		if(f!=null) {
			if(f.getPassword().equals(password))
			{
				entityManager.close();
				emf.close();
				return 1; 
			}
			entityManager.close();
			emf.close();
			return 0;
		}
		
		entityManager.close();
		emf.close();
		return 0;
		
	}
	
	public List<Client> allclient(){
		entityManager.getTransaction().begin();
		Query q1 = entityManager.createQuery("SELECT c FROM Client c");
		List<Client> L = q1.getResultList();
		return L;
	}
	
	public List<Company> allcompany(){
		entityManager.getTransaction().begin();
		Query q1 = entityManager.createQuery("SELECT c FROM Company c");
		List<Company> L = q1.getResultList();
		return L;
	}

}
