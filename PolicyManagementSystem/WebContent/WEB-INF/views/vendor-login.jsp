<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vendor Login</title>
<style type="text/css">
html{    
    background: url("https://change.walkme.com/wp-content/uploads/2019/05/Change-Management-Policies-and-Procedures.jpg") no-repeat center fixed;     
    background-size: cover;
}
.login {
	display: flex;
	justify-content: center;
	align-content: center;
	vertical-align: middle;
	padding: 10px;
}
#success{
color:green;
}
.red {
	color: red;
}
</style>
</head>
<body>
<div class="login">
	<form:form
		action="${pageContext.request.contextPath}/vendorregistration/processlogin"
		modelAttribute="vendor" method="post">

UserName<form:input path="userName" name="userName" />
		<br>
		<br>
Password<form:input path="password" name="password" />
		<br>
		<br>

		<input type="submit" value="submit" placeholder="Login">

	</form:form>
</div>
New Vendor?<a href="${pageContext.request.contextPath}/vendorregistration/">RegisterHere</a>
<div id="failure">
<h4>${loginfailure}</h4>
</div>

</body>
</html>