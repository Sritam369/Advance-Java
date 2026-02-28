package com.pack1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/customerreg")
public class CustomerRegistrationServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		CustomerBean cb = new CustomerBean();
		cb.setUname(req.getParameter("name"));
		cb.setPass(req.getParameter("pass"));
		cb.setFname(req.getParameter("fname"));
		cb.setLname(req.getParameter("lname"));
		cb.setMail(req.getParameter("mail"));
		cb.setPhone(req.getParameter("phone"));
		
		int rowCount = new CustomerRegistrationDao().register(cb);
		if(rowCount>0) {
			req.setAttribute("register", "Customer registered successfully!!!");
			req.getRequestDispatcher("CustomerRegister.jsp").forward(req, res);
		}
		else {
			req.setAttribute("register", "Customer not registered!!!");
			req.getRequestDispatcher("CustomerRegister.jsp").forward(req, res);
		}
	}
}
