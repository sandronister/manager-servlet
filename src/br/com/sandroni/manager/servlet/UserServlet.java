package br.com.sandroni.manager.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sandroni.manager.services.UserService;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		UserService service = new UserService();
		String result = ":";
		Method method = null;
		
		try {
			method = UserService.class.getMethod(action, HttpServletRequest.class,HttpServletResponse.class);
			result = (String) method.invoke(service, req,resp);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new ServletException(e);
		}
		
		String[] results = result.split(":");
		
		if(results[0].equals("foward")) {
			RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/view/"+results[1]);
			rd.forward(req, resp);
		}
		
		if(results[0].equals("redirect")) {
			resp.sendRedirect(results[1]);
		}
		
	}

}
