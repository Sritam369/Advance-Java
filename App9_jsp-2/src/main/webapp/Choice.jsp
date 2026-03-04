<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="Error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Operation Choice</title>
</head>
<body>
<%
    String s = request.getParameter("choice");
    if ("add".equals(s)) {
%>
    <jsp:forward page="Addition.jsp">
        <jsp:param name="data" value="<%= new java.util.Date() %>" />
    </jsp:forward>
<%
    } else {
%>
    <jsp:forward page="Substraction.jsp">
        <jsp:param name="data" value="<%= new java.util.Date() %>" />
    </jsp:forward>
<%
    }
%>
</body>
</html>