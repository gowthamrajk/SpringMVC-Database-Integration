<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%> 
<%@include file="./source.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>Customer Home Page</title>
<style>
#container {
	padding: 2% 7% 3% 7%;
	margin: 3% 10% 0% 10%;
	border-radius: 15px;
	box-shadow: 2px 2px 35px 4px darkgrey;
}
</style>
</head>
<body>
<div class="text-center" id="container">
		<h1 style="color: darkgreen; font-family: Impact;">Welcome to Customer Management System</h1>
		<h3 style="color: darkgreen; font-family: Verdana; font-weight: bold;">Hello ${sessionScope.customername}, have a quick tour of Home page...</h3>
		<br>
		<div>
		    <br><div class="text-center"><button type="button" class="btn btn-success"><a style="color:white; text-decoration:none; font-weight:bolder;" href="customerprofile/${sessionScope.customername}">visit Profile</a></button></div>
		    <br><div class="text-center"><button type="button" class="btn btn-info"><a style="color:white; text-decoration:none; font-weight:bolder;" href="getAllCustomers">view All customers</a></button></div>
		    <br><div class="text-center"><button type="button" class="btn btn-danger"><a style="color:white; text-decoration:none; font-weight:bolder;" href="logout"><i class="fa fa-sign-out">&nbsp;&nbsp;Logout</i></a></button></div>
		</div>
	</div>
	<!-- <center style="align-content: center">
		<h1>This is the Customer Home Page</h1><br>
		<h2>Welcome ${sessionScope.customername}</h2><br>
		
		<a href='customerprofile/${sessionScope.customername}'>view Profile</a><br><br>
		<a href='getAllCustomers'>view All Customers</a><br><br>
		<a href='logout'>Logout</a><br><br>
		<br><br>
		${customerDetails}<br>
	</center>  -->
</body>
</html>