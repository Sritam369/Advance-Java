package com.pack1;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/viewbooks")
public class ViewAllBooksServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req , HttpServletResponse res) throws ServletException,IOException{
		
		Books book = new Books();
		ViewBookDao vd = new ViewBookDao();
		ArrayList<Books> viewBook = vd.viewBook(book);
		req.setAttribute("msg", viewBook);
		req.getRequestDispatcher("ViewAllBooks.jsp").forward(req, res);
	}
	
}
