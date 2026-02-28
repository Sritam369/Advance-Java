<%@ page import="com.pack1.ProductBean" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Buy Product</title>

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
    background: linear-gradient(135deg, #667eea, #764ba2);
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
    color:white;
}

.glass-container h2{
    text-align:center;
    margin-bottom:25px;
}

.input-group{
    margin-bottom:15px;
}

.input-group label{
    display:block;
    margin-bottom:5px;
    font-size:14px;
}

.input-group input{
    width:100%;
    padding:10px;
    border:none;
    border-radius:8px;
    outline:none;
    background: rgba(255,255,255,0.25);
    color:white;
}

.input-group input[readonly]{
    background: rgba(255,255,255,0.18);
}

button{
    width:100%;
    padding:12px;
    border:none;
    border-radius:10px;
    background: rgba(0,0,0,0.3);
    color:white;
    font-size:16px;
    cursor:pointer;
    transition:0.3s ease;
    margin-top:10px;
}

button:hover{
    background: rgba(0,0,0,0.5);
    transform: scale(1.03);
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
        ProductBean pb = (ProductBean)request.getAttribute("products");
    %>

    <h2>Buy Product</h2>

    <form action="cbuy" method="post">

        <div class="input-group">
            <label>pcode</label>
            <input type="text" value="<%= pb.getCode() %>" name="code" readonly>
        </div>

        <div class="input-group">
            <label>pname</label>
            <input type="text" value="<%= pb.getName() %>" name="name" readonly>
        </div>

        <div class="input-group">
            <label>pcompany</label>
            <input type="text" value="<%= pb.getCompany() %>" name="company" readonly>
        </div>

        <div class="input-group">
            <label>price</label>
            <input type="text" value="<%= pb.getPrice() %>" name="price" readonly>
        </div>

        <div class="input-group">
            <label>pqty</label>
            <input type="text" value="<%= pb.getQty() %>" name="qty" readonly>
        </div>

        <div class="input-group">
            <label>Required no</label>
            <input type="text" name="req">
        </div>

        <button>Buy</button>

    </form>

</div>

</body>
</html>