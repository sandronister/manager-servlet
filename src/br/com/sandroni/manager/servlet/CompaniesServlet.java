package br.com.sandroni.manager.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sandroni.manager.database.Db;
import br.com.sandroni.manager.model.Company;

@WebServlet(urlPatterns = "/companies")
public class CompaniesServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Db db = new Db();
		List<Company> companies = db.getCompanies();

		req.setAttribute("companies", companies);

		RequestDispatcher rd = req.getRequestDispatcher("/companies.jsp");
		rd.forward(req, resp);
	}
}
