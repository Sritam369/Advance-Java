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
               String data = (String)request.getAttribute("msg");
               out.println(data+"<br><br>");
                      
            %>
         </h1>
          <a href="customerlogin.html"><button>Login</button></a>
</body>
</html>