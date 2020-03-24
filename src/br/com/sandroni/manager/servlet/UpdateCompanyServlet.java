package br.com.sandroni.manager.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import java.text.ParseException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import br.com.sandroni.manager.database.Db;
import br.com.sandroni.manager.model.Company;

/**
 * Servlet implementation class UpdateCompanyServlet
 */
@WebServlet("/updateCompany")
public class UpdateCompanyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramId = request.getParameter("id");
		String companyName = request.getParameter("companyName");
		String paramDate = request.getParameter("createdat");

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
		
		response.sendRedirect("companies");
	}

}
