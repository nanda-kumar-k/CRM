package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Client;

public class ClientLoginController {
	private EntityManager em;
	private EntityManagerFactory emf;
	

	public ClientLoginController() {
	    this.emf = Persistence.createEntityManagerFactory("CRM");
	    this.em = this.emf.createEntityManager();
	}
	
	public int login(String username, String password) {	
		Client C = em.find(Client.class, username);
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
