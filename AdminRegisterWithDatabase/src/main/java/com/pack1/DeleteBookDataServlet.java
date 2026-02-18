package com.pack1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteBookDataServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest req , HttpServletResponse res) throws ServletException,IOException{
		Books b = new Books();
		String id =req.getParameter("id") ;
		b.setId(id);
		
		DeleteBookDao db = new DeleteBookDao();
		int rowCount = db.deleteBook(b);
		if(rowCount>0) {
			req.setAttribute("msg", "Book with id: "+id+" deleted");
			req.getRequestDispatcher("deletebook.jsp").forward(req, res);
		}
		else {
			req.setAttribute("msg", "Book with id: "+id+" not found");
			req.getRequestDispatcher("deletebook.jsp").forward(req, res);
		}
}
}