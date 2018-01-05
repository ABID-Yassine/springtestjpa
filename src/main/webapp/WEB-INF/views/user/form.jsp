<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add User</title>
</head>
<body>


 <a href="${contextPath}/compte/list">comptes list</a>
 
	<form method="POST" action="${action}">
		<input type="hidden" name="id" value="${user.id}">

		<table>
			<tr>
				<td>First Name</td>
				<td><input type="text" name="firstName" value="${user.firstName}"></td>
			</tr>

			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lastName" value="${user.lastName}"></td>
			<tr>
				<td>Login</td>
				<td><input type="text" name="login" value="${user.login}"></td>
			</tr>

			<tr>
				<td>Password</td>
				<td><input type="password" name="password" value="${user.password}"></td>
			</tr>

			<tr>
				<td></td>
				<td>
					<button type="submit"> ${action}</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>