package com.pack1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/aps")
public class AddProductServlet extends HttpServlet{

	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		
		HttpSession session = req.getSession(false);
		if(session==null) {
			throw new RuntimeException("Session Expired!!!");
		}
		else {
		ProductBean pb = new ProductBean();
		pb.setCode(req.getParameter("code"));
		pb.setName(req.getParameter("name"));
		pb.setCompany(req.getParameter("comp"));
		pb.setPrice(req.getParameter("price"));
		pb.setQty(req.getParameter("qty"));
		
		AddProductDao ap = new AddProductDao();
		int rowCount = ap.addProd(pb);
		if(rowCount>0) {
			req.setAttribute("msg", "Products Inserted Successfully!!!");
			req.getRequestDispatcher("AddProduct.jsp").forward(req, res);
		}
		else {
			throw new RuntimeException("Product Insertion Failed!!!");
		}
		}
	}
}
