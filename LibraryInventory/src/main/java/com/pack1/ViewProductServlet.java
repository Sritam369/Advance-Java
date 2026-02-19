package com.pack1;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/viewproduct")
public class ViewProductServlet extends HttpServlet{
protected void doGet(HttpServletRequest req , HttpServletResponse res) throws ServletException,IOException{
	
		ProductBean book = new ProductBean();
		ViewProductDao vd = new ViewProductDao();
		ArrayList<ProductBean> view = vd.viewBook(book);
		req.setAttribute("msg", view);
		req.getRequestDispatcher("Viewproduct.jsp").forward(req, res);
	}
	
}
