<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
button{
color:white;
background-color:orange;
}
h1{
color:orange;
}
#cookie{
color:black;
}

</style>
</head>
<body>
<center><h1 id="cookie">
<%
Cookie[] arr = request.getCookies();
for(Cookie r:arr){
	   if("ck1".equals(r.getName())){
		   out.println("Page Belongs To: "+r.getValue()+" <br><br>");
	   }
	   else{
		   
	   }
}
%></h1>
<fieldset>
    <h1>Update product Details</h1><br><br>
   <form action="update" method="post"><br><br>
   Enter New Product Name: <input type="text" name="name"><br><br>
   Enter New Product Price: <input type="text" name="price"><br><br>
   Enter New Product Quantity: <input type="text" name="qty"><br><br>
   <button>Submit</button>
   </form>
   
</fieldset>
</body>
</html>