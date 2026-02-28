<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.pack1.ProductBean" %>
<%@ page import="com.pack1.CustomerBean" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>View Products</title>

<style>
*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
}

body{
    min-height:100vh;
    background: linear-gradient(135deg, #667eea, #764ba2);
    padding:30px;
    color:white;
}

/* Glass Container */
.glass-wrapper{
    max-width:1100px;
    margin:auto;
    padding:30px;
    border-radius:20px;
    background: rgba(255,255,255,0.12);
    backdrop-filter: blur(15px);
    -webkit-backdrop-filter: blur(15px);
    border:1px solid rgba(255,255,255,0.3);
    box-shadow:0 8px 32px rgba(0,0,0,0.25);
}

.header{
    text-align:center;
    margin-bottom:30px;
}

/* Product Grid */
.product-grid{
    display:grid;
    grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
    gap:20px;
}

/* Product Card */
.product-card{
    padding:20px;
    border-radius:15px;
    background: rgba(255,255,255,0.18);
    border:1px solid rgba(255,255,255,0.3);
    transition:0.3s ease;
}

.product-card:hover{
    transform: translateY(-5px);
    background: rgba(255,255,255,0.28);
}

.product-card h3{
    margin-bottom:10px;
}

.product-card p{
    font-size:14px;
    margin:5px 0;
}

.buy-btn{
    display:inline-block;
    margin-top:10px;
    padding:8px 15px;
    border-radius:8px;
    text-decoration:none;
    color:white;
    background: rgba(0,0,0,0.3);
    transition:0.3s ease;
}

.buy-btn:hover{
    background: rgba(0,0,0,0.5);
}

.logout{
    display:block;
    text-align:center;
    margin-top:30px;
    text-decoration:none;
    color:white;
    font-weight:bold;
}

.logout:hover{
    text-decoration:underline;
}
</style>
</head>

<body>

<div class="glass-wrapper">

    <div class="header">
        <h2>
        <%
            ArrayList<ProductBean> list = (ArrayList<ProductBean>) session.getAttribute("pbeans");
            CustomerBean cb = (CustomerBean) session.getAttribute("cbean");

            if(cb != null){
                out.println("Hello " + cb.getFname());
            }
        %>
        </h2>
    </div>

    <div class="product-grid">
        <%
            if(list != null){
                Iterator<ProductBean> itr = list.iterator();
                while(itr.hasNext()){
                    ProductBean pb = itr.next();
        %>

        <div class="product-card">
            <h3><%= pb.getName() %></h3>
            <p><strong>Code:</strong> <%= pb.getCode() %></p>
            <p><strong>Company:</strong> <%= pb.getCompany() %></p>
            <p><strong>Price:</strong> <%= pb.getPrice() %></p>
            <p><strong>Stock:</strong> <%= pb.getQty() %></p>
            <a class="buy-btn" href="buy?pcode=<%= pb.getCode() %>">Buy</a>
        </div>

        <%
                }
            }
        %>
    </div>

    <a href="Logout" class="logout">Logout</a>

</div>

</body>
</html>