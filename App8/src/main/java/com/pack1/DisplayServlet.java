package com.pack1;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dis")
public class DisplayServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name = req.getParameter("tname");
		req.setAttribute("name", name);
		String age = req.getParameter("tage");
		req.setAttribute("age", age);
		String gender = req.getParameter("gen");
		if (gender.equals("M")) {
			req.setAttribute("gen", "male");

		} else {
			req.setAttribute("gen", "female");
		}
       String add=req.getParameter("taddress");
       req.setAttribute("addr", add);
       String marry = req.getParameter("ms");
       if(marry.equals("married")) {
    	   req.setAttribute("marry", "married");
       }
       else {
    	   req.setAttribute("marry", "unmarried");   	   
       }
       String quali = req.getParameter("crs");
       if(quali.equals("java")) {
    	   req.setAttribute("quali", "java");  
       }
       else if(quali.equals(".net")) {
    	   req.setAttribute("quali", ".Net");
       }
       else {
    	   req.setAttribute("quali", "testing");
       }
       String[] hobby = req.getParameterValues("hb");
       ArrayList<String>list = new ArrayList<>();
       for(int i=0;i<hobby.length;i++){
    	   
    	   if(hobby[i].equals("read")) {
    		   list.add("Reading");
    	   }
    	   else if(hobby[i].equals("e-sports")) {
    		   list.add("Online Gaming");
    	   }
    	   else if(hobby[i].equals("travel")) {
    		   list.add("Travelling");
    	   }
       }
       
       req.setAttribute("hobby", list);
       req.getRequestDispatcher("Display.jsp").forward(req, res);
       
       
	}
}
