package br.com.sandroni.manager.servlet;

import br.com.sandroni.manager.database.Db;
import br.com.sandroni.manager.model.Company;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;


@WebServlet("/company-service")
public class CompanyRestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			List<Company> companies = new Db().getCompanies();
			
			
			
			XStream xStream = new XStream();
			xStream.alias("company", Company.class);
			String xml = xStream.toXML(companies);
			
			resp.setContentType("application/xml");
			resp.getWriter().print(xml);
			
//			Gson gson = new Gson();
//			String json = gson.toJson(companies);
			
		}
	

}
