<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body{
display:flex;
flex-direction:column;
height:100%;
width:100%;
justify-content:center;
align-content:center;

}
#d1{
margin-left:500px;
display:flex;
flex-direction:column;
height:150px;
width:500px;
justify-content:center;
align-content:center;
border:1px solid black;
background-color:pink;
color:black;

}
h1{
text-align:center;

}
button{
background-color:blue;
color:white;
}
#d2{
display:flex;
justify-content:center;
align-content:center;
gap:20px;
}
#cookie{

}
</style>
</head>
<body>
<div id="cookie">
<h1>
<% 
 Cookie[] arr = request.getCookies();
           for(Cookie r:arr){
        	   if("ck1".equals(r.getName())){
        		   out.println("Welcome: "+r.getValue()+"<br><br>");
        	   }
           }
           %>
           </h1>
          </div>
          
      <div id="d1">
        <h1>
        <%          
           String data = (String) request.getAttribute("msg");
           out.println(data);
        %>        
        </h1>
     <div id="d2">
    <a href="add.jsp"><button>Add Product</button></a>  
    <a href=viewproduct><button>View All Products </button></a>
    <a href=logout><button>Logout</button></a>      
   </div> 
   </div> 
</body>
</html>