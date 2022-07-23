package controller;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Client;
import model.Company;
import model.CompanyJob;
import model.HomeCompany;

public class CompanyLoginController {
	private EntityManager em;
	private EntityManagerFactory emf;
	

	public CompanyLoginController() {
	    this.emf = Persistence.createEntityManagerFactory("CRM");
	    this.em = this.emf.createEntityManager();
	}
	
	public int login(String username, String password) {	
		Company C = em.find(Company.class, username);
		if(C.getPassword().equals(password)) {
			em.close();
			emf.close();
			try {
			      FileWriter myWriter = new FileWriter("C:\\Users\\mvr_n\\workspace\\CRM\\company.txt");
			      myWriter.write(username);
			      myWriter.close();
			      return 1;
			      
			    } catch (IOException e) {
			      e.printStackTrace();
			    }
		}
		em.close();
		emf.close();
		return 0;
	}
	
	
	public List<Client> clientFind(String location, String job_role){
		em.getTransaction().begin();
		Query q1 = em.createQuery("SELECT c FROM Client c WHERE c.preferred_location=?1 and c.preferred_role=?2");
		q1.setParameter(1, location);
		q1.setParameter(2, job_role);
		List<Client> ci = q1.getResultList();
		em.close();
		emf.close();
		
		return ci;
	}
	
	public List<HomeCompany> getAllJobs(String username){
		em.getTransaction().begin();
		Query q1 = em.createQuery("SELECT c FROM Company c WHERE c.username=?1");
		q1.setParameter(1, username);
		Query q2 = em.createQuery("SELECT e FROM CompanyJob e WHERE e.username=?1");
		q2.setParameter(1, username);
		List<Company> d1 = q1.getResultList();
		List<CompanyJob> d2 = q2.getResultList();
		List<HomeCompany> L = new ArrayList<HomeCompany>();
		
		for(int i =0; i<d1.size(); i++) {
			Company c = d1.get(i);
			for(int j =0; j<d2.size(); j++) {
				CompanyJob cj = d2.get(j);
				HomeCompany h = new HomeCompany();
				h.setName(c.getName());
				h.setLocation(c.getLocation());
				h.setEmail(c.getEmail());
				h.setDescription(cj.getDescription());
				h.setJob_role(cj.getJob_role());
				h.setNumber_of_vacancy(cj.getNumber_of_vacancy());
				h.setSalary(cj.getSalary());
				L.add(h);	
				
			}
		}
		
//		System.out.println(L);
		
		em.close();
		emf.close();
		
		return L;
		
	}
	
	public int jobadd(CompanyJob companyjob) {
		System.out.println("rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
		em.getTransaction().begin();
		System.out.println("rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
		em.persist(companyjob);
		System.out.println("rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
		em.getTransaction().commit();
		System.out.println("rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
		em.close();
		emf.close();
		
		return 1;
	}
	
	
}
