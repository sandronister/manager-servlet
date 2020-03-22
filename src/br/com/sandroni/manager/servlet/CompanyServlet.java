package br.com.sandroni.manager.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
		String paramDate = request.getParameter("createdat");
		
		Date createdAt = null;
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			createdAt =  sdf.parse(paramDate);
		} catch (ParseException e) {
			throw new ServletException(e);
		}	
		
		Company company = new Company();
		company.setName(companyName);
		company.setCreatedAt(createdAt);
		
		Db db = new Db();
		db.addCompany(company);
		
		response.sendRedirect("companies");

	}

}
