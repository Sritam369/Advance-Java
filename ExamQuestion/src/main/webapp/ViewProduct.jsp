<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.pack1.ProductBean" %>
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
         ArrayList<ProductBean>list = (ArrayList<ProductBean>)request.getAttribute("list");
       Iterator<ProductBean> itr = list.iterator();
       while(itr.hasNext()){
    	   ProductBean pb = itr.next();
    	   out.println(pb.getId()+" "+pb.getName()+" "+pb.getPrice()+" "+pb.getQty()+" <br><br>");
       }
       %>
       <jsp:include page="index.html"/>
       </h1>
       
</body>
</html>