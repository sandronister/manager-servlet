package br.com.sandroni.manager.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sandroni.manager.database.Db;
import br.com.sandroni.manager.model.Company;

/**
 * Servlet implementation class CompanyServlet
 */
@WebServlet("/company")
public class CompanyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Cadastrando nova empresa");
		String companyName = request.getParameter("companyName");
		
		Company company = new Company();
		company.setName(companyName);
		
		Db db = new Db();
		db.addCompany(company);
		
		RequestDispatcher dispacher = request.getRequestDispatcher("/company.jsp");
		request.setAttribute("company",company.getName());
		dispacher.forward(request, response);

	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Db db = new Db();
		List<Company> companies = db.getCompanies();
		
		req.setAttribute("companies", companies);

	    RequestDispatcher rd = req.getRequestDispatcher("/companies.jsp");
	    rd.forward(req,resp);
	}

}
