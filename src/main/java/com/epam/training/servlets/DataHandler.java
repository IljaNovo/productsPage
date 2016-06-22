package com.epam.training.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DataHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession(true);
		List<String> sessionList = (List<String>) session.getAttribute(session.getId());
		PrintWriter out = new PrintWriter(response.getWriter());
		
		if (sessionList == null) {
			request.getRequestDispatcher("WEB-INF/error.jsp");
		}
		out.println("<html>");
			out.println("<head>");
				out.println("<title>Страница заказов</title>");
			out.println("<body>");
			out.println("Session id: " + session.getId() + "<br>");
			for (int i = 0; i < sessionList.size(); ++i) {
				out.println(sessionList.get(i) + "<br>");
			}
			out.println("</body>");
		    out.println("</head>");
		out.println("</html>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession(true);
		
		String name = request.getParameter("name");
		String count = request.getParameter("count");

		List<String> sessionList = (List<String>) session.getAttribute(session.getId());
		
		if (sessionList == null ) {
			sessionList = new ArrayList<>();
		}
		sessionList.add(count + "шт. " + name);
		
		session.setAttribute(session.getId(), sessionList);
		
		doGet(request, response);
	}
}
