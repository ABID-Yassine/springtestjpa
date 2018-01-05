<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des comptes</title>
</head>
<body>

 <a href="${contextPath}/user/list">users list</a>
	<table>
		<tr>
			<th>id</th>
			<th>num</th>
			<th>firstName</th> 
			<th>Action</th>
		</tr>
		<c:forEach var="u" items="${allComptes}">
			<tr>
				<td><c:out value="${u.id} " /></td>
				<td><c:out value="${u.num}" /></td>
				<td><c:out value="${u.user.firstName}" /></td> 
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