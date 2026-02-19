package com.pack1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reg")
public class AdminRegisterServlet extends HttpServlet{
  protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
  String name = req.getParameter("name");
  String pass = req.getParameter("pass");
  String fname = req.getParameter("fname");
  String lname = req.getParameter("lname");
  String mail = req.getParameter("mail");
  String phone = req.getParameter("phone");
  
  AdminBean ab = new AdminBean();
  ab.setName(name);
  ab.setPass(pass);
  ab.setFname(fname);
  ab.setLname(lname);
  ab.setMail(mail);
  ab.setPhone(phone);
  
  AdminRegisterDao adb = new AdminRegisterDao();
  int rowCount = adb.insertData(ab);
  if(rowCount==0) {
	  throw new RuntimeException("Register Failed");
  }
  else {
	  req.setAttribute("msg", "Admin Registered Successfully!!!");
	  req.getRequestDispatcher("Display.jsp").forward(req, res);
  }
  }  
}
