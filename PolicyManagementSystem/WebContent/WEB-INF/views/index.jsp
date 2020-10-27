<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<style type="text/css">
html{    
    background: url("https://change.walkme.com/wp-content/uploads/2019/05/Change-Management-Policies-and-Procedures.jpg") no-repeat center fixed;     
    background-size: cover;
}
</style>
</head>
<body>
<h1>Welcome to Policy Management System</h1>
<a href="${pageContext.request.contextPath}/userregistration/">UserRegistration</a>
<a href="${pageContext.request.contextPath}/userregistration/processlogin">Already a user:Login</a>
<br>
<a href="${pageContext.request.contextPath}/vendorregistration/">VendorRegistration</a>
<a href="${pageContext.request.contextPath}/vendorregistration/processlogin">Already a user:Login</a>
<br>
</body>
</html>