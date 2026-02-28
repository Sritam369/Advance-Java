<%@page import="com.pack1.CustomerBean" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Customer Dashboard</title>

<style>
*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
}

body{
    height:100vh;
    display:flex;
    justify-content:center;
    align-items:center;
    background: linear-gradient(135deg, #36d1dc, #5b86e5);
}

/* Glass Card */
.glass-container{
    width:90%;
    max-width:420px;
    padding:40px 30px;
    border-radius:20px;
    background: rgba(255,255,255,0.15);
    backdrop-filter: blur(15px);
    -webkit-backdrop-filter: blur(15px);
    border:1px solid rgba(255,255,255,0.3);
    box-shadow:0 8px 32px rgba(0,0,0,0.25);
    text-align:center;
    color:white;
}

.glass-container h2{
    margin-bottom:25px;
}

.glass-container a{
    display:block;
    text-decoration:none;
    color:white;
    margin:15px 0;
    padding:12px;
    border-radius:10px;
    background: rgba(255,255,255,0.25);
    transition:0.3s ease;
}

.glass-container a:hover{
    background: rgba(255,255,255,0.45);
    transform: scale(1.05);
}

/* Responsive */
@media(max-width:480px){
    .glass-container{
        padding:30px 20px;
    }
}
</style>
</head>

<body>

<div class="glass-container">
    <h2>
        <%
            CustomerBean cb = (CustomerBean)session.getAttribute("cbean");
            if(cb != null){
                out.println("Welcome " + cb.getFname());
            }
        %>
    </h2>

    <a href="cview">View Products</a>
    <a href="Logout">Logout</a>
</div>

</body>
</html>