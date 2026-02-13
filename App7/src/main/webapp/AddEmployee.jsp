<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AddEmployee.jsp</title>
</head>
<body>
  <center>
  <h1>
     <%
        String data = (String) request.getAttribute("msg");
        out.println(data+ "<br><br>");
     %>
     
      <a href = "emp.html">Add Employee Data</a><br><br>
      <a href = "view">View Employee Data</a>
      
  </h1>
 
</body>
</html>