package com.epam.training.filters;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

public class DataFilter implements Filter {
	public void destroy() {}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		boolean emptyName = Pattern.compile("^\\s*$").matcher(request.getParameter("name")).matches();
		boolean emptyCount = Pattern.compile("^\\s*$").matcher(request.getParameter("count")).matches();
		
		if (emptyCount || emptyName) {
			request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
		} else {
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {}

}
