package com.pack1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class AddProductServlet extends HttpServlet {
protected void doPost(HttpServletRequest req , HttpServletResponse res) throws ServletException,IOException{
		
		String code = req.getParameter("code");
		String name = req.getParameter("name");
		String price = req.getParameter("price");
		String stock = req.getParameter("stock");
		
		
		ProductBean pd = new ProductBean();
		pd.setCode(code);
		pd.setName(name);
		pd.setPrice(price);
		pd.setStock(stock);
		
		
		AddProductDao ap = new AddProductDao();
		int rowCount = ap.insertProd(pd);
		if(rowCount>0) {
			req.setAttribute("msg", "Product Added Successfully!!!");
			req.getRequestDispatcher("AddProduct.jsp").forward(req, res);
		}
		else {
			req.setAttribute("msg", "Product not added!!!");
			req.getRequestDispatcher("AddProduct.jsp").forward(req, res);
		}
		
		
	}
}
