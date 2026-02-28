package com.pack1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class UpdateProductServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		
		ProductBean pb = new ProductBean();
		pb.setPrice(req.getParameter("price"));
		pb.setQty(req.getParameter("qty"));
		pb.setId(req.getParameter("id"));
		
		int rowCount = new UpdateProductDao().update(pb);
		if(rowCount>0) {
			req.setAttribute("update", "Products updated successfully");
			req.getRequestDispatcher("UpdateProduct.jsp").forward(req, res);
		}
		else {
			throw new RuntimeException("Products didn't update");
		}
	}
}
