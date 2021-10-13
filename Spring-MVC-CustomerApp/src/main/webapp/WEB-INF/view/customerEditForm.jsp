<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="./source.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>Edit Customer</title>
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
   <div class="text-center"><h2 style="color: maroon; font-family: Impact;"><i class="fa fa-user">&nbsp;&nbsp;<b>Edit User</b></i></h2></div><br>
	<form:form action="/Spring-MVC-Practice/editsave" modelAttribute="customer">
		<form:errors path="*" class="errors"/>
		<form:hidden  path="customerId"/>
		<div class="form-group">
			<label for="customername">Customer Name</label><br>
			<form:input path="customerName" class="field" required="required"/>
		</div>
		<div class="form-group">
			<label for="email">Email address</label><br>
			<form:input path="email" class="field" required="required"/><br>
		</div>
		<div class="form-group">
			<label for="mobile">Mobile Number</label><br>
			<form:input path="mobile" class="field" required="required"/><br>
		</div>
		<form:hidden  path="password"/>
		<form:hidden  path="confirmPassword"/>
		<button type="submit" class="btn btn-info"><i class="fa fa-edit">&nbsp;&nbsp;submit</i></button>
	</form:form>
	</div><br><br>
</body>
</html>