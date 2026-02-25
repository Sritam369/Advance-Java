<%@ page import= "com.pack1.ProductBean" %>
<%@ page import= "com.pack1.AdminBean" %>
<%@ page import= "java.util.ArrayList" %>
<%@ page import= "java.util.Iterator" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style >
body{
display:flex;
height:100%;
width:100%;
justify-content:center;
align-content:center;
text-align:center;
}
#d1{
display:flex;
height:400px;
width:400px;
flex-direction: column;

}
#d2{
display:flex;
margin-top:20px;
margin-left:0px;
gap:20px;
}
a {
  text-decoration: none;
}
#t1{
background-color: black;
color:white;
}
</style>
</head>
<body>
<div id="d1">
<h1>
<%
   Cookie[] arr = request.getCookies();
if(arr!=null){
   for(Cookie c:arr){
	   if("ck1".equals(c.getName())){
		   out.println("This Page belongs to: "+c.getValue());
	   }
   }
}
else{
	out.println("No cookie");
}
   ArrayList<ProductBean> list = (ArrayList<ProductBean>) session.getAttribute("msg");
   
%>
</h1>
<table>
<thead id="t1">
  <tr>
  <th>Code</th>
  <th>Name</th>
  <th>Price</th>
  <th>Quantity</th>
  <th colspan="2">Action</th>
  </tr>
</thead>
<tbody>

<%
	 Iterator itr=list.iterator();
	 while(itr.hasNext()){
  	   ProductBean pb = (ProductBean)itr.next(); %>
	 <tr>
	 
	 <td><% out.println(pb.getCode());%></td>  	
	 <td><% out.println(pb.getName());%></td>
	 <td><% out.println(pb.getPrice());%></td>
	 <td><% out.println(pb.getStock());%></td>
	 <td><a href="Update?pcode=<%= pb.getCode() %>">Edit</a></td>
	 <td><a href="Delete?pcode=<%=pb.getCode()%>">Delete</a></td> 
	 
	 </tr>
<%} %>


</tbody>
</table>
<div id="d2">
   <a href="add.jsp">Add Product</a>
   <a href=logout>Logout</a>
   </div>
</div>

</body>
</html>