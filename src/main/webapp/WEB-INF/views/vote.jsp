<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vote Page</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
	crossorigin="anonymous">
</head>
<body>
	<jsp:include page='navbar.jsp'></jsp:include>
	<h1>Pizza Options for Party:</h1>
	<h2><c:out value="${party.name}"/></h2>
	<table class="table">
		<thead>
			<tr>
				<th>Name</th>
				<th>Description</th>
				<th>Votes</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="option" items="${partyOptions}">
				<tr>
					<td><c:out value="${option.name}" /></td>
					<td><c:out value="${option.description}" /></td>
					<td><c:out value="${option.votes}" /></td>
					<td><a href="/addvote?id=${option.id}&partyId=${party.id}">Vote</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<h2>Add an Option</h2>
	<form action="/addOption" method="post">
	<label>Name:</label>
	<input type="text" name="name"/>
	<label>Description:</label>
	<input type="text" name="description"/>
	<input type="hidden" name="party" value="${party.id}"/>
	<input type="submit"/>
	</form>
</body>
</html>