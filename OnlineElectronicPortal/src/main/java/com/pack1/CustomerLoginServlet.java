package com.pack1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/clogin")
public class CustomerLoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		
		CustomerBean cb = new CustomerLoginDao().login(req.getParameter("name"), req.getParameter("pass"));
		if(cb==null) {
			throw new RuntimeException("No customer data available");
		}
		else {
			HttpSession session = req.getSession();
			session.setAttribute("cbean", cb);
			req.getRequestDispatcher("CustomerHome.jsp").forward(req, res);
			
		}
	}
}
