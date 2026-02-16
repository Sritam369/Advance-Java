<%@page import="java.util.Iterator" %>
<%@page import="com.pack1.ProdBean" %>
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
     ArrayList<ProdBean> list =  (ArrayList<ProdBean>) request.getAttribute("view");
     Iterator<ProdBean> itr = list.iterator();
     while(itr.hasNext()){
    	 ProdBean pb = itr.next();
    	 out.println(pb.getCode()+" "+pb.getName()+" "+pb.getComp()+" "+pb.getPrice()+" "+pb.getQty()+" <br><br>");
     }
     %>
     <br><br>
     <a href="add.html"> Add Products</a><br><br>
     <a href="view"> View Products</a>
   </h1>

</body>
</html>