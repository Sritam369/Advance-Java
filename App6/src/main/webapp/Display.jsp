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
  String name = request.getParameter("pname");
  String id = request.getParameter("pid");
  String qty = request.getParameter("pqty");
  String price = request.getParameter("pprice");
  out.println("Product Name : "+name+" <br><br>");
  out.println("Product Id : "+id+" <br><br>");
  out.println("Product Quantity : "+qty+" <br><br>");
  out.println("Product Price : "+price+" <br><br>");
  %>
  </h1>
</body>
</html>