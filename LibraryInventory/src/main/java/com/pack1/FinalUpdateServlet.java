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

@WebServlet("/upd")
public class FinalUpdateServlet extends HttpServlet{

	protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
				
		HttpSession session = req.getSession(false);
		if(session==null) {
			throw new RuntimeException("Session Expired");
		}
		else {
			String code=req.getParameter("pcode");
			String price=req.getParameter("price");
			String qty=req.getParameter("qty");
			
			ArrayList<ProductBean>list=(ArrayList<ProductBean>)session.getAttribute("msg");
			Iterator itr=list.iterator();
			ProductBean pb=null;
			while(itr.hasNext()) {
				pb = (ProductBean) itr.next();
				if(pb.getCode().equals(code)) {
					break;
				}
			}
			pb.setPrice(price);
			pb.setStock(qty);
					
			int rowCount = new UpdateProductDao().updateProd(pb);
			if(rowCount>0) {
				req.setAttribute("message", "Product Updated Successfully");
				req.getRequestDispatcher("FinalUpdate.jsp").forward(req, res);;
			}
			else {
				req.setAttribute("message", "Product Not Updated");
				req.getRequestDispatcher("FinalUpdate.jsp").forward(req, res);;
			}
			
		}
	}
}
