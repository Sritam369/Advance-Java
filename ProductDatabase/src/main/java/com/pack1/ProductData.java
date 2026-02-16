package com.pack1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/prod")
public class ProductData extends HttpServlet {
  protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
	  String code = req.getParameter("code");
	  String name = req.getParameter("name");
	  String comp = req.getParameter("company");
	  String price = req.getParameter("price");
	  String qty = req.getParameter("qty");
	  
	  ProdBean pb = new ProdBean();
	  pb.setCode(code);
	  pb.setName(name);
	  pb.setComp(comp);
	  pb.setPrice(price);
	  pb.setQty(qty);
	  
	  Database db = new Database();
	  int rowCount = db.connect(pb);
	  if(rowCount==0) {
	    throw new RuntimeException("Data not inserted");
	  }
	  else {
		  req.setAttribute("result", "Data inserted successfully!!!");
		  req.getRequestDispatcher("Display.jsp").forward(req, res);
	  }

  }
}
