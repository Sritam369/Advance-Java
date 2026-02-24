package com.pack1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/customerreg")
public class CustomerRegistrationServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		CustomerBean cb = new CustomerBean();
		cb.setUname(req.getParameter("name"));
	}
}
