<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vendor Registration</title>
<style type="text/css">
#register {
	display: flex;
	justify-content: center;
	align-content: center;
	vertical-align: middle;
	padding: 10px;
}
html{    
    background: url("https://change.walkme.com/wp-content/uploads/2019/05/Change-Management-Policies-and-Procedures.jpg") no-repeat center fixed;     
    background-size: cover;
}
.red {
	color: red;
}
</style>
</head>
<body>
<div id="register">
<form:form
		action="${pageContext.request.contextPath}/vendorregistration/process"
		modelAttribute="vendordetails" method="post">

FirstName<form:input path="firstName" name="firstName"/>
		<span><form:errors path="firstName" cssClass="red"></form:errors></span>
		<br>
		<br>
LastName<form:input path="lastName" name="lastName"/>
		<span><form:errors path="lastName" cssClass="red"></form:errors></span>
		<br>
		<br>
Age<form:input path="age" name="age"/>
		<span><form:errors path="age" cssClass="red"></form:errors></span>
		<br>
		<br>
Gender<select name="gender">
		<option value="male">Male</option>
		<option value="female">Female</option>
	  </select>
	  <br>
	  <br>
ContactNumber<form:input path="contactNumber" name="contactNumber"/>
		<span><form:errors path="contactNumber" cssClass="red"></form:errors></span>
		<br>
		<br>
UserName<form:input path="userName" name="userName"/>
		<span><form:errors path="userName" cssClass="red"></form:errors></span>
		<br>
		<br>
Password<form:input path="password" name="password" />
		<span><form:errors path="password" cssClass="red"></form:errors></span>
		<br>
		<br>

		<input type="submit" value="submit">

	</form:form>
</div>
<div id="success">
<h3>${message}</h3>
</div>
<a href="${pageContext.request.contextPath}/vendorregistration/processlogin">Already a user:Login</a>
</body>
</html>