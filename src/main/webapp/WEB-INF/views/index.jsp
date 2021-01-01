<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Manager</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

</head>
<body>
<h1 align="center">Users List</h1>
	<div class="container">
	<h2>Add New User
		<a href="new"><i class="medium material-icons">add_circle</i></a>
	</h2>
		<table border="1" class="table table-striped">
			<thead class="thead-dark">
				<tr>
					<th>ID</th>
					<th>NAME</th>
					<th>EMAIL</th>
					<th>NUMBER</th>
					<th>EDIT</th>
					<th>DELETE</th>
				</tr>
			</thead>
			<c:forEach items="${userListKey}" var="temp">
				<tr>
					<td>${temp.id}</td>
					<td>${temp.name}</td>
					<td>${temp.email}</td>
					<td>${temp.phone}</td>
					<td align="center"><a href="edit?id=${temp.id}"><i class="medium material-icons">edit</i></a></td>		
					<td align="center"><a href="delete?id=${temp.id}"><i class="medium material-icons" >delete</i></a></td>
					
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>