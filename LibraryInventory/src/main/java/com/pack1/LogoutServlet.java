package com.pack1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet{
  protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
	  Cookie arr[]=req.getCookies();
	  if(arr!=null) {
			  req.removeAttribute("login");
			  for(Cookie c:arr) {
			  c.setMaxAge(0);
			  res.addCookie(c);
			  }
			  req.getRequestDispatcher("input.html").forward(req, res);
		  
	  }
  }
}
