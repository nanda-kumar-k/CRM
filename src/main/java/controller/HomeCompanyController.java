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

public class HomeCompanyController {
	private EntityManager em;
	private EntityManagerFactory emf;
	
	public HomeCompanyController() {
	    this.emf = Persistence.createEntityManagerFactory("CRM");
	    this.em = this.emf.createEntityManager();
	}
	
	public List<HomeCompany> findCompany(){
//		System.out.println("ddddddddddddddddddddddddddddddddddddddddddd");
		em.getTransaction().begin();
		Query q1 = em.createQuery("SELECT c FROM CompanyJob c JOIN fetch Company f ON c.username=f.username");
		Query q2 = em.createQuery("SELECT c FROM Company c JOIN fetch CompanyJob f ON c.username=f.username");
//		System.out.println("111111111111");
//		System.out.println(q1);
//		System.out.println("222222222222");
//		System.out.println(q2);
		List<CompanyJob> d1 = q1.getResultList();
//		System.out.println("3333333333333");
//		System.out.println(d1);
		List<Company> d2 = q2.getResultList();
//		System.out.println("4444444444444444");
//		System.out.println(d2);
//		System.out.println(d2.size());
//		System.out.println(d1.size());
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
		
//		em.close();
//		emf.close();
		
		return L;
	}
	
	public List<HomeCompany> searchCompany(String location, String job_role){
//		System.out.println("ddddddddddddddddddddddddddddddddddddddddddd");
		em.getTransaction().begin();
		Query q1 = em.createQuery("SELECT c FROM CompanyJob c JOIN fetch Company f ON c.username=f.username and f.location=?1 and c.job_role=?2");
		q1.setParameter(1, location);
		q1.setParameter(2, job_role);
		Query q2 = em.createQuery("SELECT c FROM Company c JOIN fetch CompanyJob f ON c.username=f.username and c.location=?1 and f.job_role=?2");
		q2.setParameter(1, location);
		q2.setParameter(2, job_role);
		System.out.println("111111111111");
//		System.out.println(q1);
//		System.out.println("222222222222");
//		System.out.println(q2);
		List<CompanyJob> d1 = q1.getResultList();
//		System.out.println("3333333333333");
//		System.out.println(d1);
		List<Company> d2 = q2.getResultList();
//		System.out.println("4444444444444444");
//		System.out.println(d2);
//		System.out.println(d2.size());
//		System.out.println(d1.size());
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
		
//		em.close();
//		emf.close();
		
		return L;
		
	}
}
