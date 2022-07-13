package views;

import controller.ClientSignupController;
import model.Client;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;


@ManagedBean(name = "ClSignup", eager = true)
public class ClientSignupBean {
	String username;
	String password;
	String first_name;
	String last_name;
	String dob;
	String education_information;
	String cv_link;
	String linkedin_link;
	String github_link;
	String stop_stack_link;
	String projects;
	String skills;
	String phone_number;
	String email_id;
	String experience;
	String preferred_location;
	String preferred_role;
	float salary_expecting;
	String preferred_company;
	
	
	
	int l;
	public void signupClient() {
		try {
			ClientSignupController cs  = new ClientSignupController();
			Client c = new Client();
			c.setUsername(username);
			c.setPassword(password);
			c.setFirst_name(first_name);
			c.setLast_name(last_name);
			c.setDob(dob);
			c.setEducation_information(education_information);
			c.setCv_link(cv_link);
			c.setLinkedin_link(linkedin_link);
			c.setGithub_link(github_link);
			c.setStop_stack_link(stop_stack_link);
			c.setProjects(projects);
			c.setSkills(skills);
			c.setPhone_number(phone_number);
			c.setEmail_id(email_id);
			c.setExperience(experience);
			c.setPreferred_location(preferred_location);
			c.setPreferred_role(preferred_role);
			c.setSalary_expecting(salary_expecting);
			c.setPreferred_company(preferred_company);
			l = cs.signup(c);
			if(l==1)
				FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "index.xhtml");
		}
			catch (Exception e) {
             System.out.println(e.getMessage());
		}
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getEducation_information() {
		return education_information;
	}
	public void setEducation_information(String education_information) {
		this.education_information = education_information;
	}
	public String getCv_link() {
		return cv_link;
	}
	public void setCv_link(String cv_link) {
		this.cv_link = cv_link;
	}
	public String getLinkedin_link() {
		return linkedin_link;
	}
	public void setLinkedin_link(String linkedin_link) {
		this.linkedin_link = linkedin_link;
	}
	public String getGithub_link() {
		return github_link;
	}
	public void setGithub_link(String github_link) {
		this.github_link = github_link;
	}
	public String getStop_stack_link() {
		return stop_stack_link;
	}
	public void setStop_stack_link(String stop_stack_link) {
		this.stop_stack_link = stop_stack_link;
	}
	public String getProjects() {
		return projects;
	}
	public void setProjects(String projects) {
		this.projects = projects;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getPreferred_location() {
		return preferred_location;
	}
	public void setPreferred_location(String preferred_location) {
		this.preferred_location = preferred_location;
	}
	public String getPreferred_role() {
		return preferred_role;
	}
	public void setPreferred_role(String preferred_role) {
		this.preferred_role = preferred_role;
	}
	public float getSalary_expecting() {
		return salary_expecting;
	}
	public void setSalary_expecting(float salary_expecting) {
		this.salary_expecting = salary_expecting;
	}
	public String getPreferred_company() {
		return preferred_company;
	}
	public void setPreferred_company(String preferred_company) {
		this.preferred_company = preferred_company;
	}
}
