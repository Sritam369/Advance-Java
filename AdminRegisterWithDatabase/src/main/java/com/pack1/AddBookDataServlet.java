package com.pack1;

import java.awt.print.Book;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/add")
public class AddBookDataServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest req , HttpServletResponse res) throws ServletException,IOException{
		
		String id = req.getParameter("id");
		String bName = req.getParameter("bname");
		String aName = req.getParameter("aname");
		Double price = Double.parseDouble(req.getParameter("price"));
		Integer qty = Integer.parseInt(req.getParameter("qty"));
		
		Books book = new Books();
		book.setId(id);
		book.setBname(bName);
		book.setAname(aName);
		book.setPrice(price);
		book.setQty(qty);
		
		BookDao bd = new BookDao();
		int rowCount = bd.insertBook(book);
		if(rowCount>0) {
			req.setAttribute("msg", "Book Added Successfully!!!");
			req.getRequestDispatcher("Book.jsp").forward(req, res);
		}
		else {
			req.setAttribute("msg", "Book not added!!!");
			req.getRequestDispatcher("Book.jsp").forward(req, res);
		}
		
		
	}
}

