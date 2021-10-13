<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="./source.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
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
   <div class="text-center"><h2 style="color: maroon; font-family: Impact;"><b><i class="fa fa-user">&nbsp;&nbsp;User Login</i></b></h2></div><br>
	<form:form action="loginCustomer" modelAttribute="customer">
		<form:errors path="*" class="errors"/>
		<div style="font-weight:bold; color:red;">${loginerror}${unauthorizedRole}</div>
		<div class="form-group">
			<label for="email">Email address</label><br>
			<form:input path="email" class="field" placeholder=" enter email address" required="required"/><br>
		</div>
		<div class="form-group">
			<label for="password">Password</label><br>
			<form:input path="password" class="field" placeholder=" enter your password" required="required"/>
		</div>
		<button type="submit" class="btn btn-primary"><i class="fa fa-sign-in">&nbsp;&nbsp;Login</i></button>
	</form:form>
	</div><br><br>
</body>
</html>