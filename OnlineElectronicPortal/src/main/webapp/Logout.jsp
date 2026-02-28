<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Admin Logout</title>

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
    flex-direction:column;
    justify-content:center;
    align-items:center;
    background: linear-gradient(135deg, #ff512f, #dd2476);
    padding:20px;
}

/* Glass Card */
.glass-container{
    width:100%;
    max-width:450px;
    padding:40px 30px;
    border-radius:20px;
    background: rgba(255,255,255,0.15);
    backdrop-filter: blur(15px);
    -webkit-backdrop-filter: blur(15px);
    border:1px solid rgba(255,255,255,0.3);
    box-shadow:0 8px 32px rgba(0,0,0,0.25);
    text-align:center;
    color:white;
    margin-bottom:30px;
}

.glass-container h2{
    margin-bottom:15px;
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
    <h2>
        <%
            session.invalidate();
            out.println("Admin Logged out successfully!!!");
        %>
    </h2>
</div>

<!-- Home Page Included Below -->
<jsp:include page="index.html"/>

</body>
</html>