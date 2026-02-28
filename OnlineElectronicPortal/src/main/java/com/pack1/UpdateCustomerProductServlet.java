package com.pack1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/cbuy")
public class UpdateCustomerProductServlet extends HttpServlet{

	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		
		HttpSession session =req.getSession(false);
		if(session==null) {
			throw new RuntimeException("Session Expired!!!");
		}
		else {
		String r = req.getParameter("req");
		int r2 = Integer.parseInt(r);
		String pcode = req.getParameter("code");
		String qty = req.getParameter("qty");
		int quantity = Integer.parseInt(qty);
		int price = Integer.parseInt(req.getParameter("price"));
		if(r2>quantity) {
			req.setAttribute("msg", "Required number can not be greater than stock!!!");
			req.getRequestDispatcher("OrderFailed.jsp").forward(req, res);
		}
		else if(r2<=0) {
			req.setAttribute("msg", "Minuimun requirement must be 1");
			req.getRequestDispatcher("OrderFailed.jsp").forward(req, res);
		}
		else {
		Integer updatedQty = quantity-r2;
		String qty2 = updatedQty.toString();
		int total = price*Integer.parseInt(r);
		int rowCount = new BuyProductdao().buy(pcode, qty2);
		if(rowCount>0) {
			req.setAttribute("total", total);
			req.getRequestDispatcher("OrderConfirmed.jsp").forward(req, res);
		}
		else {
			req.setAttribute("msg", "We couldn't placed your order");
			req.getRequestDispatcher("OrderFailed.jsp").forward(req, res);
		}
		}
	}
}
}