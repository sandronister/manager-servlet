package br.com.sandron.manager.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(urlPatterns = "/company")
public class MonitoredFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		  
		   long before = System.currentTimeMillis();
		   
		    chain.doFilter(request, response);

		    long after = System.currentTimeMillis();

		    System.out.println("Time Execution " + (after - before));
		    
		
		
	}

}
