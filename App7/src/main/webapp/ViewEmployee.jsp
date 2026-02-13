<%@page import="java.util.Iterator" %>
<%@page import="com.pack1.EmpBean" %>
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
  <h1><u>Employee Data</u><br></h1>
    <h3>
      <%
           ArrayList<EmpBean> al =(ArrayList<EmpBean>) request.getAttribute("list");
      if(al.size()==0){
    	  out.println("Employee table is empty.");
      }
      else{
    	  Iterator<EmpBean> itr = al.iterator();
    	  while(itr.hasNext()){
    		  EmpBean eb = itr.next();
    		  out.println(eb.getId()+" "+eb.getFirat_name()+" "+eb.getLast_name()+" "+eb.getSal()+" "+eb.getAddress()+" <br><br>");
    		  
    	  }
      }
           
      %>
    </h3>
    <jsp:include page = "index.html"/>

</body>
</html>