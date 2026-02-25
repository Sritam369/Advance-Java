package com.pack1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/update")
public class UpdateProductServlet extends HttpServlet{

	protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
		  HttpSession session = req.getSession();
		  if(session==null) {
				throw new RuntimeException("Session expired!!!");
			}
			else {
			  String code = req.getParameter("pcode");
			  String price = req.getParameter("price");
			  String qty = req.getParameter("qty");
			  
			  ArrayList<ProductBean>list =(ArrayList<ProductBean>)session.getAttribute("msg");
				Iterator<ProductBean> itr = list.iterator();
				ProductBean pb=null;
				while(itr.hasNext()) {
				   pb=itr.next();
				   if(code.equals(pb.getCode())) {
					   break;
				   }
				}
				pb.setPrice(price);
				pb.setQty(qty);
				
				int rowCount = new UpdateProductDao().updateProd(pb);
				if(rowCount>0) {
					req.setAttribute("message", "Product Inventory Updated Successfully !!!");
					req.getRequestDispatcher("UpdateProduct.jsp").forward(req, res);
				}
				else {
					req.setAttribute("message", "Product Inventory NOT Updated !!!");
					req.getRequestDispatcher("UpdateProduct.jsp").forward(req, res);
				}
			}
	}
}
