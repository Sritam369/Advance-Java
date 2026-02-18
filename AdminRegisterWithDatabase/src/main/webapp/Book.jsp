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
      String data = (String) request.getAttribute("msg");
      out.println(data);
    
    %>
  </h1><br><br>
    <a href="add.jsp">ADD BOOK ?</a>  <br><br>
    <a href="delete.jsp">DELETE BOOK ?</a>  <br><br>
    <a href = "update.jsp">UPDATE BOOK ?</a> <br><br> 
    <a href="viewbooks">VIEW ALL BOOKS ?</a> 
</body>
</html>