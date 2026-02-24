package com.pack1;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/ms")
public class MainServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String parameter = req.getParameter("choice");
		
		if(parameter.equals("prime")) {
		req.getRequestDispatcher("/ps").forward(req, res);
		}
		else if(parameter.equals("factor")) {
			req.getRequestDispatcher("/fs1").forward(req, res);
		}
		else if(parameter.equals("factorial")) {
			req.getRequestDispatcher("/fs2").forward(req, res);
		}
		else {
			req.getRequestDispatcher("/ss").forward(req, res);
		}
	}

}
