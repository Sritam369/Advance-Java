<%@ page import="com.pack1.CustomerBean" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Order Success</title>

<style>
*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
}

body{
    min-height:100vh;
    display:flex;
    justify-content:center;
    align-items:center;
    background: linear-gradient(135deg, #00c6ff, #0072ff);
    padding:20px;
}

/* Glass Card */
.glass-container{
    width:100%;
    max-width:500px;
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
    margin-bottom:20px;
}

.message{
    margin:15px 0;
    font-size:16px;
}

.amount{
    font-size:20px;
    font-weight:bold;
    margin:15px 0;
}

.glass-container a{
    display:block;
    margin:15px 0;
    padding:10px;
    border-radius:10px;
    text-decoration:none;
    color:white;
    background: rgba(255,255,255,0.25);
    transition:0.3s ease;
}

.glass-container a:hover{
    background: rgba(255,255,255,0.45);
    transform: scale(1.05);
}

@media(max-width:480px){
    .glass-container{
        padding:25px 20px;
    }
}
</style>
</head>

<body>

<div class="glass-container">

    <%
      CustomerBean ab = (CustomerBean)session.getAttribute("cbean");
      int total = (int)request.getAttribute("total");
    %>

    <h2>
        <%
            out.println("Hello " + ab.getFname());
        %>
    </h2>

    <div class="amount">
        <%
            out.println("You have been charged " + total + " rs");
        %>
    </div>

    <div class="message">
        Your order is placed successfully!!!
    </div>

    <a href="cview">View Products</a>
    <a href="Logout">Logout</a>

</div>

</body>
</html>