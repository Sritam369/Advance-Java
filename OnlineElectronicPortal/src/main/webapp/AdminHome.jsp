<%@page import="com.pack1.AdminBean" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body{
display:flex;
height:100%;
width:100%;
justify-content:center;
align-items:center;
}
#d1{
display:flex;
flex-direction:column;
height:200px;
width:500px;
background-color: pink;
color:black;
justify-content:center;
}
#d2{
display:flex;
justify-content:space-around;
margin-left:20px;
}
button{
background-color: blue;
color:white;
height:30px;
width:120px;
}
</style>
</head>
<body>
<center>
<h1>
<div id="d1">
<%
  AdminBean abean = (AdminBean)session.getAttribute("abean");
  out.println("<u>Welcome "+abean.getFname()+"</u> <br><br>");
%>
<div id="d2">
<a href="AddProduct.html"><button>Add Products</button></a><br><br>
<a href="View1"><button>View Products</button></a><br><br>
<a href="logout"><button>Logout</button></a><br><br>
</div>
</div>
</h1>
</body>
</html>