package com.model;


import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.entity.Employee;

@Stateless
@TransactionManagement(value = TransactionManagementType.BEAN)
public class EmployeeManager implements EmployeeRemote{

	@Override
	public int writeData(String username,String password,String email,String phone){
		try {
			Employee E=new Employee();
			E.setEmail(email);
			E.setName(username);
			E.setPassword(password);
			E.setPhone(phone);
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
			Employee e = em.find(Employee.class, password);
			//Query qry = em.createQuery("select e from example e where e.username=?1 and e.password=?2");
			//qry.setParameter(1,username);
			//qry.setParameter(2, password);
			//@SuppressWarnings("unchecked")
			//List<Employee> E=qry.getResultList();
			//System.out.println(e.getEmail());
			if(E!=null && e!=null)
				return 1;
			em.getTransaction().commit();
			em.close();
			emf.close();
		}
		catch(Exception e) {
			
		}
		return 0;
	}

}
