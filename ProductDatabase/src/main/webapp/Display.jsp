<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display</title>
</head>
<body>
     <center>
     <h1>
       <%
           String data = (String) request.getAttribute("result");
           out.println(data);
       %>
       <br><br>
       <a href="add.html"> Add Products</a><br><br>
       <a href="view"> View Products</a>
     </h1>
     </center>
</body>
</html>