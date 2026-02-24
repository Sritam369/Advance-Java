package com.pack1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/fs2")
public class FactorialServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int num = Integer.parseInt(req.getParameter("num"));
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		
		int f=1;
		for(int i=1;i<=num;i++) {
			f*=i;
		}
		
		pw.println("<center>");
		pw.println("<h1>Factorial of "+num+" is : "+f+" </h1>");
		pw.println("</center>");
		req.getRequestDispatcher("index.html").include(req, res);
	}

}
