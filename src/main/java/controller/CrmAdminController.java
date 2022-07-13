package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.CrmAdmin;

public class CrmAdminController {
	
	private EntityManager entityManager;
	private EntityManagerFactory emf;

	public CrmAdminController() {
	    this.emf = Persistence.createEntityManagerFactory("CRM");
	    this.entityManager = this.emf.createEntityManager();
	}
	
	public int logins(String username, String password) {
		System.out.println("ffffffffffffffffffffffffffffffffffffffffffffffffffffff");
		System.out.println(password);
		entityManager.getTransaction().begin();
		CrmAdmin f = entityManager.find(CrmAdmin.class, username);
		if(f.getPassword().equals(password))
			return 1;  
		return 0;
	}

}
