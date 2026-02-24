package com.pack1;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/View1")
public class ViewProductServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		
		HttpSession session = req.getSession(false);
		if(session==null) {
			throw new RuntimeException("Session expired!!!");
		}
		else {
			ArrayList<ProductBean>list=new ViewProductDao().view();
		if(list==null) {
			throw new RuntimeException("Product table is empty");
		}
		else {
			HttpSession session2=req.getSession();
			session2.setAttribute("msg", list);
			req.getRequestDispatcher("ViewProduct.jsp").forward(req, res);
		}
		}
	}
}
