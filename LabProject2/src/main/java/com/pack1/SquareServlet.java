package com.pack1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/ss")
public class SquareServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int num = Integer.parseInt(req.getParameter("num"));
		int s = num*num;
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		pw.println("<center>");
		pw.println("<h1> Square of "+num+" is : "+s+" <h1>");
		pw.println("</center>");
		req.getRequestDispatcher("index.html").include(req, res);
	}

}
