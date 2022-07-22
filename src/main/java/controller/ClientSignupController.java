package controller;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Client;

@Stateless
@TransactionManagement(value = TransactionManagementType.BEAN)
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
		
		em.close();
		emf.close();
		return 1;
	}

}
