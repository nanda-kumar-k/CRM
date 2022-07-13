package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Client;

public class ClientSignupController {
	
	private EntityManager em;
	private EntityManagerFactory emf;
	

	public ClientSignupController() {
	    this.emf = Persistence.createEntityManagerFactory("CRM");
	    this.em = this.emf.createEntityManager();
	}
	
	public int signup(Client client) {	
		em.getTransaction().begin();
		em.persist(client);
		em.getTransaction().commit();
		return 1;
	}

}
