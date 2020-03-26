package br.com.sandroni.manager.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sandroni.manager.database.Db;
import br.com.sandroni.manager.model.Company;

public class CompanyService implements CompanyActions {

	public String list(HttpServletRequest req,HttpServletResponse resp)  {
		Db db = new Db();
		List<Company> companies = db.getCompanies();

		req.setAttribute("companies", companies);

		return "foward:companies.jsp";
	}

	public String read(HttpServletRequest req, HttpServletResponse resp) {
		String paramId = req.getParameter("id");
		int id = Integer.valueOf(paramId);
		Db db = new Db();
		Company company = db.findCompanyId(id);

		req.setAttribute("company", company);
		
		return "foward:editCompany.jsp";

	}

	public String create(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
		System.out.println("Cadastrando nova empresa");
		String companyName = req.getParameter("companyName");
		String paramDate = req.getParameter("createdat");

		Date createdAt = null;

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			createdAt = sdf.parse(paramDate);
		} catch (ParseException e) {
			throw new ServletException(e);
		}

		Company company = new Company();
		company.setName(companyName);
		company.setCreatedAt(createdAt);

		Db db = new Db();
		db.addCompany(company);

		return "redirect:company?action=list";
	}

	public String delete(HttpServletRequest req, HttpServletResponse resp) {
		String paramId = req.getParameter("id");
		int id = Integer.valueOf(paramId);
		Db db = new Db();
		db.companyDelete(id);
		return "redirect:company?action=list";
		
	}

	public String update(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
		String paramId = req.getParameter("id");
		String companyName = req.getParameter("companyName");
		String paramDate = req.getParameter("createdat");

		Date createdAt = null;

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			createdAt = sdf.parse(paramDate);
		} catch (ParseException e) {
			throw new ServletException(e);
		}

		int id = Integer.valueOf(paramId);
		Db db = new Db();
		
		Company company = db.findCompanyId(id);
		company.setName(companyName);
		company.setCreatedAt(createdAt);
		
		return "redirect:company?action=list";
	}

	public String newCompany(HttpServletRequest req, HttpServletResponse resp) {
		return "foward:new-company.jsp";
	}
}
