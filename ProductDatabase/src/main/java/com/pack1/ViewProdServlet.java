package com.pack1;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/view")
public class ViewProdServlet extends HttpServlet {
	 protected void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
		 ViewDatabase vd = new ViewDatabase();
		 ArrayList<ProdBean> list = vd.view();
		 req.setAttribute("view", list);
		 req.getRequestDispatcher("View.jsp").forward(req, res);
	 }
}
