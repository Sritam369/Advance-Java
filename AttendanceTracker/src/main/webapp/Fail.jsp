<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fail</title>
<style>
body{
  display:flex;
 justify-content:center;
 align-content:center;
 height:100%;
 width:100%;
}
#d1{
 display:flex:
 flex-direction:column;
 background-color:pink;
 gap:15px;
 height:300px;
 width:350px;
 justify-content:center;
 align-content:center;
 text-align:center;
 color:white;
}
#d2{
 color:blue;
 margin-top:20px;
 margin-bottom:20px;
}
#d3{
color:yellow;
}
</style>
</head>
<body>
<center>
<div id="d1">
<h1>
      
   <%
    Integer p = (Integer) request.getAttribute("result"); 
    out.println("Exam Eligibility Result");    
   %>  
   <div id="d2">
   <%
   out.println(p+".00%");
   %> 
   </div>
   </h1>
   <div id="d3">
   <h3>
   <%
    out.println("Sorry! You are not eligible for the exam");   
   %> 
   </h3>
   </div>
  </div>
</body>
</html>