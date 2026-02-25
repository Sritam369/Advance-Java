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

@WebServlet("/Delete")
public class DeleteProductServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req , HttpServletResponse res) throws ServletException,IOException{
		
		HttpSession session = req.getSession(false);
		ArrayList<ProductBean>list=(ArrayList<ProductBean>)session.getAttribute("msg");
		String code=req.getParameter("pcode");
		Iterator itr=list.iterator();
		ProductBean pb=null;
		while(itr.hasNext()) {
			pb =(ProductBean) itr.next();
			if(code.equals(pb.getCode())) {
				break;
			}
		}
		pb.setCode(code);
		int rowCount = new DeleteProductDao().deleteProd(pb);
		if(rowCount>0) {
		req.setAttribute("pbean", "Product with id"+code+" deleted successfully!!!");
		req.getRequestDispatcher("DeleteProduct.jsp").forward(req, res);
		
		}
		else {
			req.setAttribute("pbean", "Product with id "+code+" not found!!!");
			req.getRequestDispatcher("DeleteProduct.jsp").forward(req, res);
		}
}
}