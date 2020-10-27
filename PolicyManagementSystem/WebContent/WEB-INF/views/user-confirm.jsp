<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Profile</title>
<style type="text/css">
html{    
    background: url("https://venngage-wordpress.s3.amazonaws.com/uploads/2018/09/Orange-Pattern-Simple-Background-Image.jpg") no-repeat center fixed;     
    background-size: cover;
}
</style>
</head>
<body>
	<h2>Welcome ${validUser.getUserName()}</h2>
	<a
		href="${pageContext.request.contextPath}/userregistration/policydetails">PolicyDetails</a>
	<h3>The policy Details are</h3>
	<form:form
		action="${pageContext.request.contextPath}/userregistration/getpolicy"
		method="post">
		<table border="1">
			<th>PolicyId</th>
			<th>PolicyName</th>
			<th>PolicyType</th>
			<th>CompanyName</th>
			<th>Duration</th>
			<th>Amount</th>
			<th>Status</th>
			<c:forEach items="${policydetails}" var="policy">
				<tr>
					<td>${policy.pid}</td>
					<td>${policy.policyName}</td>
					<td>${policy.policyType}</td>
					<td>${policy.companyName}</td>
					<td>${policy.duration}</td>
					<td>${policy.amount}</td>
					<td><input type="submit" value="GetPolicy"></td>
				</tr>
			</c:forEach>
		</table>
	</form:form>
	<a href="${pageContext.request.contextPath}/userregistration/logout">Logout</a>
	${message}
</body>
</html>