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
		<h1 style="color: darkgreen; font-family: Impact;">Customer Management Dashboard</h1>
		<h4 style="color: darkgreen; font-family: Verdana; font-weight: bold;">Available customers are listed below...</h4>
		<br>
		<table class="table table-bordered">
			<thead style="">
				<tr>
					<th class="text-center">ID</th>
					<th class="text-center">Name</th>
					<th class="text-center">Email</th>
					<th class="text-center">Mobile</th>
					<th class="text-center">Updates</th>
				</tr>
			</thead>
			<tbody>
			 <c:forEach var="customer" items="${customerList}">   
				<tr style="font-weight:bolder;">
					<td>${customer.customerId}</td>
					<td>${customer.customerName}</td>
					<td>${customer.email}</td>
					<td>${customer.mobile}</td>
					<td>
					    <div class="text-center"><button type="button" class="btn btn-success"><i class="fa fa-edit">&nbsp;<a style="color:white; text-decoration:none; font-weight:bolder;" href="editcustomer/${customer.customerId}">edit</a></i></button>&nbsp;&nbsp;
						<button type="button" class="btn btn-danger"><i class="fa fa-trash">&nbsp;<a style="color:white; text-decoration:none; font-weight:bolder;" href="deletecustomer/${customer.customerId}">delete</a></i></button></div>
					</td>
				</tr>
			 </c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>