package controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Company;
import model.CompanyJob;
import model.HomeCompany;

public class CompanyJobProfileController {
	private EntityManager em;
	private EntityManagerFactory emf;
	
	public CompanyJobProfileController() {
	    this.emf = Persistence.createEntityManagerFactory("CRM");
	    this.em = this.emf.createEntityManager();
	}
	
	
	
	public List<HomeCompany> allCompanyjob(String username){
		em.getTransaction().begin();
		Query q1 = em.createQuery("SELECT c FROM CompanyJob c JOIN fetch Company f ON c.username=f.username and f.username=?1");
		q1.setParameter(1, username);
		List<CompanyJob> d1 = q1.getResultList();
		Query q2 = em.createQuery("SELECT c FROM Company c JOIN fetch CompanyJob f ON c.username=f.username and c.username=?1");
		q2.setParameter(1, username);
//		System.out.println("111111111111");
		List<Company> d2 = q2.getResultList();
		em.close();
		emf.close();
		List<HomeCompany> L = new ArrayList<HomeCompany>();
		
		for(int i =0; i<d1.size(); i++) {
			HomeCompany h = new HomeCompany();
			Company c = d2.get(i);
			h.setName(c.getName());
			h.setLocation(c.getLocation());
			h.setEmail(c.getEmail());
			CompanyJob cj = d1.get(i);
			h.setDescription(cj.getDescription());
			h.setJob_role(cj.getJob_role());
			h.setNumber_of_vacancy(cj.getNumber_of_vacancy());
			h.setSalary(cj.getSalary());
			L.add(h);
		}
		
//		System.out.println(L);
		
		return L;
		
	}
	
	public int addcompanyjob(CompanyJob companyjob) {
        em.getTransaction().begin();
		em.persist(companyjob);
		em.getTransaction().commit();
		em.close();
		emf.close();
        return 1;
    }
}
