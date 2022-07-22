package controller;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Client;


@Stateless
@TransactionManagement(value = TransactionManagementType.BEAN)
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
	
	public List<Client> clientProfile(String username){
		em.getTransaction().begin();
		Query q1 = em.createQuery("SELECT c FROM Client c WHERE c.username=?1 ");
		q1.setParameter(1, username);
		List<Client> L = q1.getResultList();
		
		
		return L;
	}
}
