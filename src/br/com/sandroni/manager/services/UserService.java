package br.com.sandroni.manager.services;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.sandroni.manager.database.Db;
import br.com.sandroni.manager.model.User;

public class UserService {
	
	public String doLogin(HttpServletRequest req,HttpServletResponse resp) {
		
		String login = req.getParameter("login");
		String password = req.getParameter("password");
		
		Db db = new Db();
		User user = db.exists(login,password);
		
		if (user!=null) {
			HttpSession session = req.getSession();
			session.setAttribute("userLogin", user);
			return "redirect:company?action=list";
		}
		
		
		return "redirect:user?action=login";
	}
	
	public String login(HttpServletRequest req,HttpServletResponse resp) {
		return "foward:login.jsp";
	}

	public boolean IsLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		HttpSession session = req.getSession();
		boolean isLogin = (session.getAttribute("userLogin")!=null);
		
		if(!isLogin) {
			resp.sendRedirect("user?action=login");
			return false;
		}
		
		return true;
		
		
	}
	
	

}
