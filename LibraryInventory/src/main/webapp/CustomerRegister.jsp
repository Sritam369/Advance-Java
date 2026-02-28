<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Registration Status</title>

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
    background: linear-gradient(135deg,#667eea,#764ba2);
}

.card{
    background:#ffffff;
    padding:40px;
    border-radius:12px;
    box-shadow:0 15px 35px rgba(0,0,0,0.2);
    width:90%;
    max-width:450px;
    text-align:center;
}

.card h1{
    margin-bottom:25px;
    font-size:22px;
    color:#333;
}

.btn-group{
    display:flex;
    justify-content:space-between;
    gap:15px;
}

.btn{
    flex:1;
    padding:12px;
    border:none;
    border-radius:8px;
    font-size:15px;
    font-weight:bold;
    cursor:pointer;
    transition:0.3s ease;
}

.login-btn{
    background:#28a745;
    color:white;
}

.login-btn:hover{
    background:#218838;
}

.logout-btn{
    background:#dc3545;
    color:white;
}

.logout-btn:hover{
    background:#c82333;
}

/* Responsive */
@media(max-width:480px){
    .btn-group{
        flex-direction:column;
    }
}
</style>
</head>

<body>

<div class="card">
    <h1>${register}</h1>

    <div class="btn-group">
        <a href="customerlogin.html">
            <button class="btn login-btn">Login</button>
        </a>

        <a href="logout">
            <button class="btn logout-btn">Logout</button>
        </a>
    </div>
</div>

</body>
</html>