package com.model;


import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.entity.ComJob;
import com.entity.Company;
import com.entity.CompanyJob;
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
	public Employee loginData(String username,String password) {
		
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRM");
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Employee E = em.find(Employee.class, username);
			if(E.getPassword().equals(password))
				return E;
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
		return null;
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
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CompanyJob> getall(String jobrole){
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRM");
//		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();
//		Query qry=em.createQuery("select e from Company e where e.companylocation=?1");
//		qry.setParameter(1, "Vza");
//		@SuppressWarnings("unchecked")
//		List<Company> L = qry.getResultList();
//		System.out.println("rrrrrrrrrrrrrrrrrrrrrrrrr");
//		System.out.println(L);
//		em.getTransaction().commit();
//		em.close();
//		emf.close();
////		return L;
//		
//		List<ComJob> J = null;
////		EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("CRM");
////		EntityManager em1 = emf.createEntityManager();
////		em1.getTransaction().begin();
////		Query qry1=em.createQuery("select e from Company e");
//		//qry.setParameter(1, location);
//		//@SuppressWarnings("unchecked")
////		List<Company> L = qry.getResultList();
////		System.out.println(qry);
////		System.out.println("ahjdgajhsgdjhattttttttttttttttttttttttuyygd");
////		System.out.println(L);
//		for(int i=0;i<L.size();i++)
//		{
//			EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("CRM");
//			EntityManager em1 = emf1.createEntityManager();
//			em1.getTransaction().begin();
//			ComJob D = null;
//			Query qry1=em.createQuery("select e from CompanyJob e where e.username=?1 and e.jobrole=?2",CompanyJob.class);
//			Company Q=L.get(i);
//			qry1.setParameter(1, Q.getUserName());
//			qry1.setParameter(2, "GameDeveloper");
//			System.out.println(D);
//			CompanyJob LL=(CompanyJob)qry1.getSingleResult();
//			System.out.println(LL);
//			if(LL!=null) {
//				D.setComname(Q.getName());
//				D.setComloc(Q.getCompanyLocation());
//				D.setComemail(Q.getEmail());
//				D.setJobrole(LL.getJobrole());
//				D.setDesofjob(LL.getDesofjob());
//				D.setNoofjobs(LL.getNoofjobs());
//				D.setSalary(LL.getSalary());
//				J.add(D);
//				ComJob obj = J.get(i);
//				System.out.println(obj.getJobrole());
//			}
//			em.getTransaction().commit();
//			em.close();
//			emf.close();
//			
//		}
//		System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
//		System.out.println(J);
//		return L;
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRM");
//		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();
//		Query qry=em.createQuery("select e,b from Company e, CompanyJob b"+" where e.companylocation=?1 and b.jobrole=?2");
//		qry.setParameter(1, location);
//		qry.setParameter(2, jobrole);
//		List<ComJob> K=qry.getResultList();
//		em.getTransaction().commit();
//		em.close();
//		emf.close();
//		return K;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRM");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query qry=em.createQuery("select b from CompanyJob b where b.jobrole=?1");
		qry.setParameter(1, jobrole);
		List<CompanyJob> K=qry.getResultList();
		em.getTransaction().commit();
		em.close();
		emf.close();
		return K;
	}
	
	int i=2;
	@Override
	public int writeData111(int noofjob,String desofjob,double salary,String jobrole,String username){
		try {
			i+=1;
			CompanyJob E=new CompanyJob();
		    E.setId(i);
			E.setDesofjob(desofjob);
			E.setJobrole(jobrole);
			E.setNoofjobs(noofjob);
			E.setSalary(salary);
			E.setUserName(username);
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
	public List<Employee> clientget(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRM");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query qry=em.createQuery("select b from Employee b");
		@SuppressWarnings("unchecked")
		List<Employee> K=qry.getResultList();
		em.getTransaction().commit();
		em.close();
		emf.close();
		return K;
	}
	
	
}
