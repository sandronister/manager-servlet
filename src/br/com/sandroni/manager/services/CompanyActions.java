package br.com.sandroni.manager.services;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CompanyActions {
	
	String list(HttpServletRequest req,HttpServletResponse resp);
	
	String read(HttpServletRequest req, HttpServletResponse resp);
	
	String create(HttpServletRequest req, HttpServletResponse resp) throws ServletException;
	
	String delete(HttpServletRequest req, HttpServletResponse resp);
	
	String update(HttpServletRequest req, HttpServletResponse resp) throws ServletException;
	
	String newCompany(HttpServletRequest req, HttpServletResponse resp);
}
