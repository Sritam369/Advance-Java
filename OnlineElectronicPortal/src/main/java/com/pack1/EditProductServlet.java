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

@WebServlet("/edit")
public class EditProductServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
		
		HttpSession session = req.getSession(false);
		if(session==null) {
			throw new RuntimeException("Session expired!!!");
		}
		else {
		String pcode=req.getParameter("pcode");
		ArrayList<ProductBean>list =(ArrayList<ProductBean>)session.getAttribute("msg");
		Iterator<ProductBean> itr = list.iterator();
		ProductBean pb=null;
		while(itr.hasNext()) {
		   pb=itr.next();
		   if(pcode.equals(pb.getCode())) {
			   break;
		   }
		}
		req.setAttribute("p_bean", pb);
		req.getRequestDispatcher("EditProduct.jsp").forward(req, res);
		}
	}
}
