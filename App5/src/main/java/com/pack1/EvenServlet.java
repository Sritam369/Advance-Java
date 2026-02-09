package com.pack1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/es")
public class EvenServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		int x = Integer.parseInt(req.getParameter("num"));
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		
		if(x%2==0) {
			
			pw.println("<center><h1>");
			pw.println("The Number "+x+" is Even <br><br>");
			pw.println("</h1></center>");
			
		}
		else {
			pw.println("<center><h1>");
			pw.println("The Number "+x+" is Not Even <br><br>");
			pw.println("</h1></center>");
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("input.html");
		rd.include(req,res);
		
	}

}
