package com.pack1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/fs")
public class FirstServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
			String name = req.getParameter("name");
			int id = Integer.parseInt(req.getParameter("id"));
			int sal = Integer.parseInt(req.getParameter("sal"));
			int exp =Integer.parseInt(req.getParameter("exp"));
			
			if (exp>=5) {
				sal=(int) (sal+(sal*0.10));
			}
			
			PrintWriter pw = res.getWriter();
			res.setContentType("text/html");
			
			pw.println("<center><h1>");
			pw.println("EmpName "+name+" <br><br>");
			pw.println("EmpId "+id+" <br><br>");
			pw.println("EmpSal "+sal+" <br><br>");
			pw.println("EmpExp "+exp+" <br><br>");
			pw.println("<h1><center>");
	}

}
