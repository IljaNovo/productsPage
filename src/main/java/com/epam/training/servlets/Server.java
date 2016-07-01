package com.epam.training.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Server extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		
		List<String> sessionList = (List<String>) session.getAttribute(session.getId());
		if (sessionList == null || sessionList.size() == 0) {
			request.getRequestDispatcher("/WEB-INF/emptyProductsList.jsp").forward(request, response);	
		} else {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = new PrintWriter(response.getWriter());
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
	}
}
