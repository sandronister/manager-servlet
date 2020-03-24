package br.com.sandroni.manager.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sandroni.manager.database.Db;

/**
 * Servlet implementation class removeCompanyServlet
 */
@WebServlet("/company/remove")
public class removeCompanyServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
      

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramId = request.getParameter("id");
		int id = Integer.valueOf(paramId);
		Db db = new Db();
		db.companyDelete(id);
		
		response.sendRedirect("/manager/companies");
	}

}
