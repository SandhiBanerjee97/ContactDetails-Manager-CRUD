<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New/Edit Contact</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
</head>
<body>
<div align="center">
	<h1>New/Edit Contact</h1>
	<form:form action="save" modelAttribute="newUser">
		<table>
			<form:hidden path="id" />	<!--This is a hidden Form Field ,it is blank for new -->
			<tr>						<!--User and has a value when we edit an user's details-->
				<td>Name:</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td>Phone:</td>
				<td><form:input path="phone" /></td>
			</tr>
		</table><br>
		<input type="submit" value="Save Details" class="btn btn-primary btn-sm" />
	</form:form>
</div>
</body>
</html>