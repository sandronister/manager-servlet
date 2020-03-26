package br.com.sandroni.manager.database;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.sandroni.manager.model.Company;
import br.com.sandroni.manager.model.User;

public class Db {

	private static List<Company> companies = new ArrayList<Company>();
	private static List<User> users = new ArrayList<User>();
	
	private static int sequecial_key =1; 
	
	static {
		Company comp1 = new Company();
		comp1.setName("Alura");
		comp1.setId(Db.sequecial_key++);
		Db.companies.add(comp1);
		
		Company comp2 = new Company();
		comp2.setId(Db.sequecial_key++);
		comp2.setName("Caelum");
		Db.companies.add(comp2);
		
		User u1 = new User();
		u1.setLogin("lm1");
		u1.setPassword("123");
		Db.users.add(u1);
		
		User u2 = new User();
		u2.setLogin("lm2");
		u2.setPassword("123");
		Db.users.add(u2);
	}
	
	public void addCompany(Company company) {
		company.setId(Db.sequecial_key++);
		Db.companies.add(company);
	}
	
	public List<Company> getCompanies(){
		return Db.companies;
	}

	
	public void companyDelete(int id) {
		
		Iterator<Company> it = companies.iterator();
		
		while(it.hasNext()) {
			
			Company company = it.next();
			
			if(company.getId()==id) {
				it.remove();
			}
		}
	}

	public Company findCompanyId(int id) {
		
		for (Company company : companies) {
			if(company.getId()==id) {
				return company;
			}
		}
		
		return null;
	}

	public User exists(String login, String password) {
		
		User result = null;
		
		for (User user : users) {
			if(user.IsEqual(login, password)) {
				return user;
			}
		}
		
		return result;
	}

}
