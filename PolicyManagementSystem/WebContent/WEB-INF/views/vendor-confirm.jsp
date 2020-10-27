<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vendor Confirmation</title>
<style type="text/css">
html{    
    background: url("https://change.walkme.com/wp-content/uploads/2019/05/Change-Management-Policies-and-Procedures.jpg") no-repeat center fixed;     
    background-size: cover;
}
</style>
</head>
<body>
<h2>Welcome ${validVendor.getUserName()}</h2>
<a href="${pageContext.request.contextPath}/policyregistration/">PolicyRegistration</a><br>
<a href="${pageContext.request.contextPath}/vendorregistration/logout">Logout</a>
</body>
</html>