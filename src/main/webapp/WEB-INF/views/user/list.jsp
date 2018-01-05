<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des utilisateurs</title>
</head>
<body>


 <a href="${contextPath}/compte/list">comptes list</a>
	<table>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Login</th>
			<th>Password</th>
			<th>Action</th>
		</tr>
		<c:forEach var="u" items="${allUsers}">
			<tr>
				<td><c:out value="${u.firstName} " /></td>
				<td><c:out value="${u.lastName}" /></td>
				<td><c:out value="${u.login}" /></td>
				<td><c:out value="${u.password}" /></td>
				<td><a href="update/<c:out value="${u.id}" />">update</a>|<a
					href="delete/<c:out value="${u.id}" />">delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<form method="POST" action="../spring_security_logout">

		<input type="submit" value="logout">
	</form>


</body>
</html>