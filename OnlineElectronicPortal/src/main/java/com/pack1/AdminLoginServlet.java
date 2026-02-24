package com.pack1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class AdminLoginServlet extends HttpServlet{

	protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
	
		AdminBean ab= new AdminLoginDao().checkAdminLogin(req.getParameter("name"), req.getParameter("pwd"));
		if(ab==null) {
			req.setAttribute("msg", "Invalid Admin Login Credentials!!!");
			req.getRequestDispatcher("AdminLogin.html").forward(req, res);
		}
		else {
			HttpSession session = req.getSession();
			session.setAttribute("abean", ab);
			req.getRequestDispatcher("AdminHome.jsp").forward(req, res);
		}
	}
}
