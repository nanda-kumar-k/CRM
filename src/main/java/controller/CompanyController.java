package controller;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.Join;

import model.Company;
import model.CompanyJob;


@Stateless
public class CompanyController {
	
	private EntityManager entityManager;
	private EntityManagerFactory emf;
	

	public CompanyController() {
	    this.emf = Persistence.createEntityManagerFactory("example");
	    this.entityManager = this.emf.createEntityManager();
	}
	
	public Company add(Company company) {
	    entityManager.getTransaction().begin();
	    entityManager.persist(company);
	    entityManager.getTransaction().commit();
	    entityManager.close();
		emf.close();
	    return company;
	}
	
	public CompanyJob addjob(CompanyJob companyJob) {
	    entityManager.getTransaction().begin();
	    entityManager.persist(companyJob);
	    entityManager.getTransaction().commit();
	    entityManager.close();
		emf.close();
	    return companyJob;
	}
	
	public void finds() {
		entityManager.getTransaction().begin();
		Query query = entityManager.createQuery("SELECT c FROM CompanyJob c JOIN fetch CompanyJob f ON c.username=f.username and c.username=?1");
		query.setParameter(1, "nanda");
		System.out.println("ttttttttttttttttttttttttttttttttt");
		System.out.println(query.getResultList());
		List<CompanyJob> data = query.getResultList();
		System.out.println(data.get(1).getJob_role());
		
		entityManager.close();
		emf.close();
	  }
	

}
