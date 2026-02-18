<%@page import="java.util.Iterator" %>
<%@page import="com.pack1.Books" %>
<%@page import="java.util.ArrayList" %> 

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <center>
  <h1>
    <%
    ArrayList<Books> data = (ArrayList<Books>) request.getAttribute("msg");
      Iterator<Books> itr  = data.iterator();
      while(itr.hasNext()){
    	  Books b = itr.next();
    	  out.println(b.getId()+" "+b.getBname()+" "+b.getAname()+" "+b.getPrice()+" "+b.getQty()+" <br><br>");
      }
    
    %>
    <br><br>
  </h1>
    <a href="add.jsp">ADD BOOK ?</a>  <br><br>
    <a href="delete.jsp">DELETE BOOK ?</a><br><br>  
    <a href ="update.jsp">UPDATE BOOK ?</a> <br><br> 
    <a href="viewbooks">VIEW ALL BOOKS ?</a> <br><br>
</body>
</html>