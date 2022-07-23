package controller;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Company;
import model.CompanyJob;
import model.HomeCompany;


@Stateless
@TransactionManagement(value = TransactionManagementType.BEAN)
public class HomeCompanyController {
	private EntityManager em;
	private EntityManagerFactory emf;
	
	public HomeCompanyController() {
	    this.emf = Persistence.createEntityManagerFactory("CRM");
	    this.em = this.emf.createEntityManager();
	}
	
	public List<HomeCompany> findCompany(){
		em.getTransaction().begin();
//		Query q2 = em.createQuery("SELECT c FROM CompanyJob f,Company c WHERE f.username=c", Company.class);
//		Query q1 = em.createQuery("SELECT c FROM Company c JOIN fetch CompanyJob f ON c.username=f.username");
		Query q1 = em.createQuery("SELECT c FROM Company c");
		Query q2 = em.createQuery("SELECT c FROM CompanyJob c");
		List<Company> d1 = q1.getResultList();
		List<CompanyJob> d2 = q2.getResultList();
		List<HomeCompany> L = new ArrayList<HomeCompany>();
		
		for(int i =0; i<d1.size(); i++) {
			Company c = d1.get(i);
			for(int j =0; j<d2.size(); j++) {
				CompanyJob cj = d2.get(j);
				if(c.getUsername().equals(cj.getUsername()) ) {
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
		}
		
//		System.out.println(L);
		
		em.close();
		emf.close();
		
		return L;
	}
	
	public List<HomeCompany> searchCompany(String location, String job_role){
		em.getTransaction().begin();
		Query q1 = em.createQuery("SELECT c FROM Company c");
		Query q2 = em.createQuery("SELECT e FROM CompanyJob e");
		List<Company> d1 = q1.getResultList();
		List<CompanyJob> d2 = q2.getResultList();
		List<HomeCompany> L = new ArrayList<HomeCompany>();
		
		for(int i =0; i<d1.size(); i++) {
			Company c = d1.get(i);
			for(int j =0; j<d2.size(); j++) {
				CompanyJob cj = d2.get(j);
				if(c.getUsername().equals(cj.getUsername()) && c.getLocation().equals(location) && cj.getJob_role().equals(job_role) ) {
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
		}
//		
//		System.out.println(L);
		
		em.close();
		emf.close();
		
		return L;
		
	}
}
