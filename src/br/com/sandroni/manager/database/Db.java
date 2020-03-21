package br.com.sandroni.manager.database;

import java.util.ArrayList;
import java.util.List;

import br.com.sandroni.manager.model.Company;

public class Db {

	private static List<Company> companies = new ArrayList<Company>();
	
	
	static {
		Company comp1 = new Company();
		comp1.setName("Alura");
		Db.companies.add(comp1);
		
		Company comp2 = new Company();
		comp2.setName("Caelum");
		Db.companies.add(comp2);
	}
	
	public void addCompany(Company company) {
		Db.companies.add(company);
	}
	
	public List<Company> getCompanies(){
		return Db.companies;
	}

}
