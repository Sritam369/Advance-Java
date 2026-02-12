package com.pack1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/fs")
public class FirstServlet extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
   req.getParameter("");
   String name=req.getParameter("uname");
   String mail=req.getParameter("umail");
   
   PrintWriter pw=res.getWriter();
   res.setContentType("text/html");
   
//   System.out.println("username = "+name);
//   System.out.println("user mail id = "+mail);
   
   pw.println("<center><h1>");
   pw.println("Users Data<br><br>");
   pw.println("Users Name : "+name+" <br><br>");
   pw.println("Users Mail_id : "+mail+" <br><br>");
   pw.println("</h1></center>");
	}

}