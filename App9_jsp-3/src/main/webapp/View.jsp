<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.pack1.UserBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>
<jsp:useBean id="ub" class="com.pack1.UserBean" scope="session"/>
   UserName :  <jsp:getProperty property="userName" name="ub"/><br><br>
   Mail_id :  <jsp:getProperty property="userMail" name="ub"/><br><br>
   Mobile : <jsp:getProperty property="userMob"  name="ub"/>
</h1>
</body>
</html>