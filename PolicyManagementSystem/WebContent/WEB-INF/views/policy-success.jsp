<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Policy Home</title>
<style type="text/css">
html{    
    background: url("https://change.walkme.com/wp-content/uploads/2019/05/Change-Management-Policies-and-Procedures.jpg") no-repeat center fixed;     
    background-size: cover;
}
#msg{
color:yellow;
}
</style>
</head>
<body>
<div id="msg">
<h2>Congratulations..You have been Successfully Registered for the policy!!</h2>
	<a href="${pageContext.request.contextPath}/">Home</a>
	<a href="${pageContext.request.contextPath}/userregistration/logout">Logout</a>
</div>
</body>
</html>