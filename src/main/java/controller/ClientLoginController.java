package controller;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Client;
import model.Company;
import model.CompanyJob;
import model.HomeCompany;


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
			try {
			      FileWriter myWriter = new FileWriter("C:\\Users\\mvr_n\\workspace\\CRM\\client.txt");
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
	
	public List<Client> clientProfile(String username){
		em.getTransaction().begin();
		Query q1 = em.createQuery("SELECT c FROM Client c WHERE c.username=?1 ");
		q1.setParameter(1, username);
		List<Client> L = q1.getResultList();
		
		
		return L;
	}
	
	public List<HomeCompany> clientMainProfile(String username){
		em.getTransaction().begin();
		Query q3 = em.createQuery("SELECT c FROM Client c WHERE c.username=?1 ");
		q3.setParameter(1, username);
		List<Client> S = q3.getResultList();
		
		String role = S.get(0).getPreferred_role();
		String location = S.get(0).getPreferred_location();
		
		Query q1 = em.createQuery("SELECT c FROM Company c");
		Query q2 = em.createQuery("SELECT e FROM CompanyJob e");
		List<Company> d1 = q1.getResultList();
		List<CompanyJob> d2 = q2.getResultList();
		List<HomeCompany> L = new ArrayList<HomeCompany>();
		
		for(int i =0; i<d1.size(); i++) {
			Company c = d1.get(i);
			for(int j =0; j<d2.size(); j++) {
				CompanyJob cj = d2.get(j);
				if(c.getUsername().equals(cj.getUsername()) && c.getLocation().equals(location) && cj.getJob_role().equals(role) ) {
					HomeCompany h = new HomeCompany();
					h.setUsername(c.getUsername());
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
		
		
		return L;
	}
}
