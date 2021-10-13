<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="./source.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>Customer Profile</title>
<style>
#container {
	padding: 2% 7% 3% 7%;
	margin: 3% 10% 0% 10%;
	border-radius: 15px;
	box-shadow: 2px 2px 35px 4px darkgrey;
}
thead {
	color: white;
	background: maroon;
	font-weight: bolder;
	font-size: large;
}
</style>
</head>
<body>
	<div class="w-50 p-3 text-center" id="container">
		<h1 style="color: darkgreen; font-family: Impact;">Welcome ${sessionScope.customername}</h1>
		<h3 style="color: darkgreen; font-family: Verdana; font-weight: bold;">Have a glimpse of your profile here...</h3>
		<br>
		<div class="card text-left" style="margin:1% 0% 2% 25%; width: 50%; background: #fffff5; box-shadow: 2px 2px 25px 4px darkgrey; padding: 3%; font-weight: bolder; font-size:medium; border-radius:25px;">
			<div class="card-body" style="padding: 2% 2% 2% 2%;">
				<p class="card-text text-center" style="font-size:25px; color:darkblue; font-weight:bolder"><i class="fa fa-user-o">&nbsp;<b>${sessionScope.customername}</b></i></p>
				<hr>
				<p class="card-text"><b style="color:darkred;">ID :</b> ${customer.customerId}<span style="margin-left:30px;"></span><b style="color:darkred;">Mobile :</b> ${customer.mobile}</p>
				<p class="card-text"><b style="color:darkred;">Email :</b> ${customer.email}</p>
				<br><div class="text-center"><button type="button" class="btn btn-success"><i class="fa fa-edit">&nbsp;<a style="color:white; text-decoration:none; font-weight:bolder;" href="/Spring-MVC-Practice/editcustomer/${customer.customerId}">edit</a></i></button></div>
			</div>
		</div>
	</div>
</body>
</html>