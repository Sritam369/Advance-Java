package com.pack1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteProductServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req , HttpServletResponse res) throws ServletException,IOException{
		
		String code = req.getParameter("code");
		ProductBean pd = new ProductBean();
		pd.setCode(code);
		DeleteProductDao dp = new DeleteProductDao();
		int rowCount =  dp.deleteProd(pd);
		if(rowCount>0) {
			req.setAttribute("msg", "Product with id "+code+" deleted");
			req.getRequestDispatcher("DeleteProduct.jsp").forward(req, res);
		}
		else {
			req.setAttribute("msg", code+" NOT Found");
			req.getRequestDispatcher("DeleteProduct.jsp").forward(req, res);
		}
		
			
			
		}
}
