<%@ page import="java.util.ArrayList" %>
<%@ page import="com.pack1.CustomerBean" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
button{
width:150px;
background-color: blue;
color:white;
}
</style>
</head>
<body>
<center>
<h1>
<fieldset>
   <%
      CustomerBean cb = (CustomerBean)session.getAttribute("cbean");
      
      out.println("Welcome Customer : "+cb.getFname()+"<br><br>");
      
   
   %>
       <a href="view.jsp"><button>View Products</button></a>
       </fieldset>
       </h1>
</body>
</html>