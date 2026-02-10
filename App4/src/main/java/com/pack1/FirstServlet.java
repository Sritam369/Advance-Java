package com.pack1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/fs")
public class FirstServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String uName = req.getParameter("name");
		String pass = req.getParameter("pwd");
		String pName = req.getParameter("pname");
		int id = Integer.parseInt(req.getParameter("id"));
		int qty = Integer.parseInt(req.getParameter("qty"));
		double price = Double.parseDouble(req.getParameter("price"));
		if(qty<=5) {
			price+=price*0.10;
		}
		
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		
		if(uName.equalsIgnoreCase("sritam") && pass.equalsIgnoreCase("java is awesome")) {
			pw.println("<center><h1>");
			pw.println("Welcome "+uName+" <br><br>");
			pw.println("You did the task <br><br>");
			
			pw.println("Product Name: "+pName+" <br><br>");
			pw.println("Product Id: "+id+" <br><br>");
			pw.println("Product Quantity: "+qty+" <br><br>");
			pw.println("Product Price: "+price+" <br><br>");
			pw.println("<h1><center>");
		}
		else {
			pw.println("<center><h1>");
			pw.println("Welcome "+uName+" <br>");
			pw.println("Invalid credentials");
			pw.println("<h1><center>");
		}
		
	}

}
