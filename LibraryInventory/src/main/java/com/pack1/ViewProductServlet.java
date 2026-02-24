package com.pack1;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/viewproduct")
public class ViewProductServlet extends HttpServlet{
protected void doGet(HttpServletRequest req , HttpServletResponse res) throws ServletException,IOException{
	
		ProductBean book = new ProductBean();
		ViewProductDao vd = new ViewProductDao();
		ArrayList<ProductBean> view = vd.viewBook(book);
		HttpSession session = req.getSession();
		session.setAttribute("pbean", session);
		req.setAttribute("msg", view);
		req.getRequestDispatcher("Viewproduct.jsp").forward(req, res);
	}
	
}
