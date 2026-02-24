package com.pack1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/ps")
public class PrimeServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int num =Integer.parseInt(req.getParameter("num"));	
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		
		int c = 0;
		for(int i=1;i<=num;i++) {
			if(num%i==0) {
				c++;
			}
		}
		if(c==2) {
			pw.println("<center>");
			pw.println("<h1>"+num+" is a prime number.<h1>");
			pw.println("</center>");
			
		}
		else {
			
			pw.println("<center>");
			pw.println("<h1>"+num+" is not a prime number. </h1>");
			pw.println("</center>");
		}
		
		req.getRequestDispatcher("index.html").include(req, res);
	}

}
