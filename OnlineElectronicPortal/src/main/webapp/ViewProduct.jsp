<%@page import="com.pack1.ProductBean" %>
<%@page import="com.pack1.AdminBean" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.Iterator" %>
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
           ArrayList<ProductBean> list = (ArrayList<ProductBean>)session.getAttribute("msg");
           
           if(list.size()==0){
        	   out.println("Products are not available in the Inventory");
           }
           else{
           out.println("<u>Hello Mr. "+abean.getFname()+", These are your product details </u><br><br>");
           }
           
           Iterator<ProductBean>itr=list.iterator();
           while(itr.hasNext()){
        	   ProductBean pb = itr.next();
        	   out.println(pb.getCode()+" "+pb.getName()+" "+pb.getCompany()+" "+pb.getPrice()+" "+pb.getQty()+" "+
        	   "<a href='edit?pcode="+pb.getCode()+"'>Edit</a>"+" "+
        	   "<a href='delete?pcode="+pb.getCode()+"'>Delete</a>"+"<br><br>"); 	    	   
           }
        %>
        <a href="logout">Logout</a>
      </h1>

</body>
</html>