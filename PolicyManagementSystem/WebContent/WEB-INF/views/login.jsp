<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login</title>
<style>
html{    
    background: url("https://change.walkme.com/wp-content/uploads/2019/05/Change-Management-Policies-and-Procedures.jpg") no-repeat center fixed;     
    background-size: cover;
}
.login,.logout {
	display: flex;
	justify-content: center;
	align-content: center;
	vertical-align: middle;
	padding: 10px;
}
</style>

</head>
<body>
	<div class="login">
		<form:form
			action="${pageContext.request.contextPath}/userregistration/processlogin"
			modelAttribute="user" method="post">
UserName<form:input path="userName" name="userName" />
			<br>
			<br>
Password<form:input path="password" name="password" />
			<br>
			<br>

			<input type="submit" value="submit">
		</form:form>
	</div>
	Not a User?<a href="${pageContext.request.contextPath}/userregistration/">RegisterHere</a><br>
</body>
</html>