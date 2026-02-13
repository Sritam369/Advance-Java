package com.pack1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/aes")
public class AddEmpServlet extends HttpServlet{
	
    @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		
    	EmpBean eb = new EmpBean();
		eb.setId(req.getParameter("id"));
		eb.setFirat_name(req.getParameter("fn"));
		eb.setLast_name(req.getParameter("ln"));
		eb.setSal(Integer.parseInt(req.getParameter("sal")));
		eb.setAddress(req.getParameter("addr"));
		
		AddEmpDao add = new AddEmpDao();
		int rowCount = add.insertEmpData(eb);
		
		if(rowCount>0) {
			req.setAttribute("msg", "Employee Record Inserted Successfully!!!");
			req.getRequestDispatcher("AddEmployee.jsp").forward(req, res);
		}
		else {
			throw new RuntimeException("Employee Record NOT inserted!!!");
		}
	}
}
