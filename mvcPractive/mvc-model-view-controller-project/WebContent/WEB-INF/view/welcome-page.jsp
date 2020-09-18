<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mom's Cafe</title>
</head>
<body>
	<h1><center>${myCafeName}</center>	</h1>
	<hr />
	<!--  priya: example to read value from Contorller -->
	<!-- <span>My name is: ${myNameValue}</span>-->
	<form action="processOrder">
	<div align="center">
	<label for="itemName"><b>Item Name: </b></label>
	<input id="itemName" type="text" name="foodType" placeHolder="Food of your choice ??">
	<input type="submit" value="Order now">
	</div>
	</form>
</body>
</html>