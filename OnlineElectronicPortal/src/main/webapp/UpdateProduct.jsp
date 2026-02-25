<%@ page import="com.pack1.AdminBean" %>
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
               String data = (String)request.getAttribute("message");
               AdminBean ab = (AdminBean)session.getAttribute("abean");
               out.println("Hello "+ab.getFname()+"<br><br>");
               out.println(data+"<br><br>");             
            %>
            
                <a href="AddProduct.html">Add Products</a><br><br>
                <a href="View1">View Products</a><br><br>
                <a href="Loout">Logout</a><br><br>
            
         </h1>
</body>
</html>