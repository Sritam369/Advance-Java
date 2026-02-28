package com.pack1;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class AddProductServlet extends HttpServlet{

	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		ProductBean pb = new ProductBean();
		pb.setId(req.getParameter("id"));
		pb.setName(req.getParameter("name"));
		pb.setPrice(req.getParameter("price"));
		pb.setQty(req.getParameter("qty"));
		
		int rowCount = new AddProductDao().add(pb);
		if(rowCount>0) {
			req.setAttribute("add", "Products added successfully");
			req.getRequestDispatcher("AddProduct.jsp").forward(req, res);
		}
		else {
			throw new RuntimeException("Products didn't add");
		}
		
	}
}
