package com.pack1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class AdminLoginServlet extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
		String name = req.getParameter("name");
		String pass = req.getParameter("pass");
		
		AdminLoginDao ld = new AdminLoginDao();
		ArrayList<AdminBean>list = ld.view();
		Iterator<AdminBean> itr=list.iterator();
		boolean flag=false;
		while(itr.hasNext()) {
			AdminBean ab = itr.next();			
			String names = ab.getName();
			String pwd = ab.getPass();
			if(names.equals(name) && pwd.equals(pass)) {
				flag=true;
				break;
			}
		}
		if(flag) {
			
			req.setAttribute("msg", name);	
			Cookie ck = new Cookie("ck1",name);
			res.addCookie(ck);
			req.getRequestDispatcher("View.jsp").forward(req, res);			
		}
		else {
			req.setAttribute("msg", name);
			req.getRequestDispatcher("View2.jsp").forward(req, res);
		}
		
	}
}
