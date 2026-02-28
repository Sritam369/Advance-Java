package com.pack1;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

@WebServlet("/creg")
public class CustomerRegistrationServlet extends HttpServlet{

	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		
		CustomerBean cb = new CustomerBean();
		cb.setUname(req.getParameter("name"));
		cb.setPass(req.getParameter("pass"));
		cb.setFname(req.getParameter("fname"));
		cb.setLname(req.getParameter("lname"));
		cb.setAddr(req.getParameter("addr"));
		cb.setMail(req.getParameter("mail"));
		cb.setMob(req.getParameter("mob"));
		
		int rowCount = new CustomerRegisterDao().register(cb);
		if(rowCount>0) {
			req.setAttribute("msg", "Customer Registered Successfully");
			req.getRequestDispatcher("CustomerRegister.jsp").forward(req, res);
		}
		else {
			req.setAttribute("msg", "Customer Registered Failed");
			req.getRequestDispatcher("CustomerRegister.jsp").forward(req, res);
		}
	}
}
