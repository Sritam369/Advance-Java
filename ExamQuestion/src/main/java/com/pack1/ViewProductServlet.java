package com.pack1;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/view")
public class ViewProductServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		
		ArrayList<ProductBean>list = new ViewProductDao().view();
		if(list==null) {
			throw new RuntimeException("List is empty");
		}
		else {
			req.setAttribute("list", list);
			req.getRequestDispatcher("ViewProduct.jsp").forward(req, res);
		}
	}
}
