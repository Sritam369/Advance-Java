package com.pack1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class UpdateProductServlet extends HttpServlet {
protected void doPost(HttpServletRequest req , HttpServletResponse res) throws ServletException,IOException{
		
	ProductBean pd = new ProductBean();

	String code=null;
		Cookie arr[] = req.getCookies();
		for(Cookie c:arr) {
			if("ck2".equals(c.getName())) {
				code=c.getValue();
				
			}
			
		}
		String name = req.getParameter("name");
		String price = req.getParameter("price");
		String stock = req.getParameter("qty");
		
		pd.setCode(code);		
		pd.setName(name);
		pd.setPrice(price);
		pd.setStock(stock);
		
		
		UpdateProductDao up = new UpdateProductDao();
		int rowCount = up.updateProd(pd);
		if(rowCount>0) {
			req.setAttribute("msg", "Product with id "+code+" updated Successfully!!!");
			req.getRequestDispatcher("UpdateProduct.jsp").forward(req, res);
		}
		else {
			req.setAttribute("msg", "Product not updated!!!");
			req.getRequestDispatcher("UpdateProduct.jsp").forward(req, res);
		}
		
		
	}
}
