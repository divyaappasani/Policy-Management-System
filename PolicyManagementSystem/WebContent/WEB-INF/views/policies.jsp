<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PolicyRegistration</title>
<style type="text/css">
html{    
    background: url("https://venngage-wordpress.s3.amazonaws.com/uploads/2018/09/Orange-Pattern-Simple-Background-Image.jpg") no-repeat center fixed;     
    background-size: cover;
}
.red {
	color: red;
}
</style>
</head>
<body>
	<h1>Policy Details</h1>
	<form:form
		action="${pageContext.request.contextPath}/policyregistration/process"
		modelAttribute="policydetails" method="post">
		<table>
			<tr>
				<td>PolicyId</td>
				<td><form:input path="pid" />
				</td>
				
			</tr>
			<tr>
				<td>PolicyName</td>
				<td><form:input path="policyName" />
				<span><form:errors path="policyName" cssClass="red"></form:errors></span>
				</td>
			</tr>
			<tr>
				<td>PolicyType</td>
				<td><form:input path="policyType" />
				<span><form:errors path="policyType" cssClass="red"></form:errors></span>
				</td>
			</tr>
			<tr>
				<td>CompanyName</td>
				<td><form:input path="companyName" />
				<span><form:errors path="companyName" cssClass="red"></form:errors></span>
				</td>
			</tr>
			<tr>
				<td>Duration</td>
				<td><form:input path="duration" /></td>
			</tr>
			<tr>
				<td>Amount</td>
				<td><form:input path="amount" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" name="action" value="Add">
					<input type="submit" name="action" value="Update">
					<input type="submit" name="action" value="Delete">					
				</td>
			</tr>
		</table>
	</form:form>
	<br>
	<table border="1">
		<th>PolicyId</th>
		<th>PolicyName</th>
		<th>PolicyType</th>
		<th>CompanyName</th>
		<th>Duration</th>
		<th>Amount</th>
		<c:forEach items="${policiesList}" var="policy">
			<tr>
				<td>${policy.pid}</td>
				<td>${policy.policyName}</td>
				<td>${policy.policyType}</td>
				<td>${policy.companyName}</td>
				<td>${policy.duration}</td>
				<td>${policy.amount}</td>
			</tr>
		</c:forEach>
		
	</table>
	<div id="success">
		<h4>${message}</h4>
		The generated id is ${generatedid}
	</div>
<a href="${pageContext.request.contextPath}/">Home</a>
<a href="${pageContext.request.contextPath}/userregistration/logout">Logout</a>
</body>
</html>