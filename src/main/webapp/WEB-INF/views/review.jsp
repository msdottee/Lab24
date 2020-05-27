<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Review</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
	crossorigin="anonymous">
</head>
<body>
<jsp:include page='navbar.jsp'></jsp:include>
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
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>