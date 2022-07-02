package com.model;


import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import com.entity.Company;
import com.entity.Employee;
import javax.persistence.Query;

@Stateless
@TransactionManagement(value = TransactionManagementType.BEAN)
public class EmployeeManager implements EmployeeRemote{

	@Override
	public int writeData(String username,String password,String email,String phone,String name,String edu,String jobRole,String location){
		try {
			Employee E=new Employee();
			E.setEmail(email);
			E.setUserName(username);
			E.setPassword(password);
			E.setPhone(phone);
			E.setName(name);
			E.setEdu(edu);
			E.setJobRole(jobRole);
			E.setJobLocation(location);
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRM");
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(E);
			em.getTransaction().commit();
			em.close();
			emf.close();
			return 1;
	       }
		catch(Exception e) {
			
		}
		return 0;
	}
	
	@Override
	public int loginData(String username,String password) {
		
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRM");
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Employee E = em.find(Employee.class, username);
			if(E.getPassword().equals(password))
				return 1;
			//Query qry = em.createQuery("select e from example e where e.username=?1 and e.password=?2");
			//qry.setParameter(1,username);
			//qry.setParameter(2, password);
			//@SuppressWarnings("unchecked")
			//List<Employee> E=qry.getResultList();
			//if(E!=null && e!=null)
			em.getTransaction().commit();
			em.close();
			emf.close();
		}
		catch(Exception e) {
			
		}
		return 0;
	}

	@Override
	public int cwriteData(String username,String password,String email,String name,String location){
		try {
			Company E=new Company();
			E.setEmail(email);
			E.setUserName(username);
			E.setPassword(password);
			E.setName(name);
			E.setCompanyLocation(location);
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRM");
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(E);
			em.getTransaction().commit();
			em.close();
			emf.close();
			return 1;
	       }
		catch(Exception e) {
			
		}
		return 0;
	}
	
	@Override
	public int cloginData(String username,String password) {
		
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRM");
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Company E = em.find(Company.class, username);
			if(E.getPassword().equals(password))
				return 1;
			//Query qry = em.createQuery("select e from example e where e.username=?1 and e.password=?2");
			//qry.setParameter(1,username);
			//qry.setParameter(2, password);
			//@SuppressWarnings("unchecked")
			//List<Employee> E=qry.getResultList();
			//if(E!=null && e!=null)
			em.getTransaction().commit();
			em.close();
			emf.close();
		}
		catch(Exception e) {
			
		}
		return 0;
	}
	public List<Company> getall(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRM");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query qry=em.createQuery("select e from Company e");
		@SuppressWarnings("unchecked")
		List<Company> L = qry.getResultList();
		em.getTransaction().commit();
		em.close();
		emf.close();
		return L;
	}
	
}
