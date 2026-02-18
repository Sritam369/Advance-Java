package com.pack1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class UpdateBookDataServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest req , HttpServletResponse res) throws ServletException,IOException{
		String id = req.getParameter("id");
		String bName = req.getParameter("bname");
		String aName = req.getParameter("aname");
		Double price = Double.parseDouble(req.getParameter("price"));
		
		Books b = new Books();
		b.setId(id);
		b.setBname(bName);
		b.setAname(aName);
		b.setPrice(price);
		
		UpdateBookDao ub = new UpdateBookDao();
		int rowCount = ub.updateBook(b);
		if(rowCount>0) {
			req.setAttribute("msg", "Book with id: "+id+" updated");
			req.getRequestDispatcher("updatebook.jsp").forward(req, res);
		}
		else {
			req.setAttribute("msg", "Book with id: "+id+" not found");
			req.getRequestDispatcher("updatebook.jsp").forward(req, res);
		}
	}
	}