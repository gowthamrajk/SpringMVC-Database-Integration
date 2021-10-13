<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="./source.jsp"%>
<!DOCTYPE html>
<html>
<head>
<!-- <link rel="stylesheet" href="resources/css/profile.css" type="text/css">  -->
<title>New Employee</title>
<style>

#container {
	padding: 2% 7% 3% 7%;
	margin: 2% 28% 0% 28%;
	border-radius: 15px;
	box-shadow: 2px 2px 35px 4px darkgrey;
}

.field {
    width : 90%;
    border: none;
    border-radius : 5px;
    height: 30px;
    background : #fafafa;
}
.errors {
    font-weight : bold;
    color : red;
}
</style>
</head>
<body>
   <div class="text-left" id="container">
   <div class="text-center"><h2 style="color: maroon; font-family: Impact;"><i class="fa fa-user">&nbsp;&nbsp;<b>New User Registration</b></i></h2></div><br>
	<form:form action="validateNewCustomer" modelAttribute="customer">
		<form:errors path="*" class="errors"/>
		<div class="form-group">
			<label for="customername">Customer Name</label><br>
			<form:input path="customerName" class="field" placeholder=" enter customer name" required="required"/>
		</div>
		<div class="form-group">
			<label for="email">Email address</label><br>
			<form:input path="email" class="field" placeholder=" enter email address" required="required"/><br>
			<small id="emailHelp" class="form-text text-muted">email address should be with a valid domain.</small>
		</div>
		<div class="form-group">
			<label for="mobile">Mobile Number</label><br>
			<form:input path="mobile" type="tel" class="field" placeholder="123-45-678" required="required"/><br>
			<small class="form-text text-muted">proper 10 digit mobile number.</small>
		</div>
		<div class="form-group">
			<label for="password">Password</label><br>
			<form:input path="password" class="field" placeholder=" enter your passord" required="required"/><br>
			<small id="emailHelp" class="form-text text-muted">should be with minimum length of 6-15 characters</small>
		</div>
		<div class="form-group">
			<label for="confirmPassword">Confirm Password</label><br>
			<form:input path="confirmPassword" class="field" placeholder=" re-enter your password for confirmation" required="required"/>
		</div>
		<button type="submit" class="btn btn-primary"><i class="fa fa-plus">&nbsp;&nbsp;Register</i></button>
	</form:form>
	</div><br><br>
</body>
</html>