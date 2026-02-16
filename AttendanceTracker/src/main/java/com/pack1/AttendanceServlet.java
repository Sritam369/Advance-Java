package com.pack1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ats")
public class AttendanceServlet extends HttpServlet {
  protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
	     int attendance = Integer.parseInt(req.getParameter("at"));
	     int total=Integer.parseInt(req.getParameter("ta"));
	     int percentage = (attendance*total)/total;
	     req.setAttribute("result", percentage);
	     if(percentage>=75) {
	         req.getRequestDispatcher("Pass.jsp").forward(req, res);
	     }
	     else {
	    	 req.getRequestDispatcher("Fail.jsp").forward(req, res);
	     }
  }
}
