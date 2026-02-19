<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
h1{
Text-align:center;
color:orange;
}
button{
color:white;
background-color:orange;
}
</style>
</head>
<body>
<center>
<fieldset>
  <form action="add" method="post">
    <h1>Product Details</h1>
    Product Code: <input type="text" name="code"><br><br>
    Product Name: <input type="text" name="name"><br><br>
    Product Price: <input type="text" name="price"><br><br>
    Product Stock: <input type="text" name="stock"><br><br>
    <button>Submit</button>
  </form>
  </fieldset>
</body>
</html>