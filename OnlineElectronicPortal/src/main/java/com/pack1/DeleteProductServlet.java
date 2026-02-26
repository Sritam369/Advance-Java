package com.pack1;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/delete")
public class DeleteProductServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
		
		HttpSession session = req.getSession(false);
		if(session==null) {
			throw new RuntimeException("Session expired");
		}
		else {
			String pcode=req.getParameter("pcode");
			int rowCount = new DeleteProductDao().deleteProd(pcode);
			if(rowCount>0) {
				req.setAttribute("delete", "Product Deleted!!!");
				req.getRequestDispatcher("DeleteProduct.jsp").forward(req, res);
			}
			else {
				req.setAttribute("delete", "Product deletion Failed!!!");
				req.getRequestDispatcher("DeleteProduct.jsp").forward(req, res);
			}
			
		}
	}
}
