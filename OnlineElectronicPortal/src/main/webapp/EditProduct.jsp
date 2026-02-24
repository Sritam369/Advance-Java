<%@page import="com.pack1.ProductBean" %>
<%@page import="com.pack1.AdminBean" %>
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
       AdminBean abean = (AdminBean)session.getAttribute("abean");
       ProductBean pbean = (ProductBean)request.getAttribute("p_bean");
       out.println(abean.getFname()+" below is the data available to edit<br><br>");      
      %>
      <form action="update" method="post">
       Product Price: <input type="text" name="price" value="<%= pbean.getPrice() %>"> <br><br>
       Product Quantity: <input type="text" name="qty" value="<%= pbean.getQty() %>"> <br><br>
       <input type="hidden" name=pcode value="<%= pbean.getCode() %>">
       <button>Update</button>
      </form>
   </h1>
</body>
</html>