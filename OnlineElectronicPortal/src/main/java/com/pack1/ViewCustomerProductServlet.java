package com.pack1;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/cview")
public class ViewCustomerProductServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		
		HttpSession session = req.getSession(false);
		if(session==null) {
			throw new RuntimeException("Session Expired");
		}
		else {
			ArrayList<ProductBean> view = new ViewCustomerProductsDao().view();
			session.setAttribute("pbeans", view);
			req.getRequestDispatcher("ViewCustomerProducts.jsp").forward(req, res);
		}
	}
}
