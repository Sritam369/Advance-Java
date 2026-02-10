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
		String name = req.getParameter("name1");
		int age = Integer.parseInt(req.getParameter("num"));
		long mobile = Long.parseLong(req.getParameter("mob"));
		
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		pw.println("<center><h1>");
		pw.println("Name: "+name+" <br><br>");
		pw.println("Age: "+age+" <br><br>");
		pw.println("Mobile: "+mobile+" <br><br>");
		
		String gender = req.getParameter("gender");
		if(gender.equals("male")) {
			pw.println("Gender: Male <br><br>");			
		}
		else {
			pw.println("Gender: Female <br><br>");
		}
		
		String hobbies[] = req.getParameterValues("hobby");
		
		for(int i=0;i<hobbies.length;i++) {
		if(hobbies[i].equals("read")) {
			pw.println("Hobbies: Reading <br><br>");
		}
		else if(hobbies[i].equals("search")) {
			pw.println("Hobbies: Searching <br><br>");
		}
		else if(hobbies[i].equals("sleep")) {
			pw.println("Hobbies: Sleeping <br><br>");
		}
		else if(hobbies[i].equals("dance")) {
			pw.println("Hobbies: Dancing <br><br>");
		}
		}
		
		String state = req.getParameter("state");
		if(state.equals("telengana")) {
			pw.println("Your selected state is Telengana<br><br>");
			pw.println("Capital = Hyderabad");
		}
		else if(state.equals("andhra")) {
			pw.println("Your selected state is Andhra Pradesh<br><br>");
		    pw.println("Capital = Amaravati");
		}
	   else if(state.equals("tamilnadu")) {
		pw.println("Your selected state is Tamilnadu<br><br>");
	    pw.println("Capital = Chennai");
	}
	   else {
		   pw.println("Your selected state is Maharashtra <br><br>");
		    pw.println("Capital = Mumbai");
	   }
		
	
	}
}
