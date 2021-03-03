<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<link href="css/basicStyling.css" rel="stylesheet" type="text/css">
<head>
<meta charset="ISO-8859-1">
<title>BackendAdminPortal</title>
</head>
<body>
	<h2>Configure Teacher Master List</h2>
	<form action="/AdminPortal/Teachers" method="post">
		<fieldset class="fieldset-auto-width">
			<legend>Add Teacher to Subject Master List</legend>
			<p>
				Enter Teacher ID: <input type="text" name="addTeacherID"><br>
				Enter First Name: <input type="text" name="addFirstName"><br>
				Enter Last Name: <input type="text" name="addLastName"><br>
				<input type="hidden" name="formAction" value="1" /> <input
					type="submit">
			</p>
		</fieldset>
	</form>
	<br>
	<br>
	<form action="/AdminPortal/Teachers" method="post">
		<fieldset class="fieldset-auto-width">
			<legend>Delete Teacher From Subject Master List</legend>
			<p>
				Enter Teacher ID: <input type="text" name="deleteTeacher"><br>
				<input type="hidden" name="formAction" value="2" /> <input
					type="submit">
			</p>
		</fieldset>
	</form>
	<br>
	<br>
	<form action="/AdminPortal/Teachers" method="get">
		<fieldset class="fieldset-auto-width">
			<legend>View Teacher Master List</legend>
			<p>
				<input type="hidden" name="formAction" value="0" /> <input
					type="submit" value="View">
			</p>
		</fieldset>
	</form>
	<br>
	<br>

	<fieldset class="fieldset-auto-width">
		<legend>Return Home</legend>
		<p>
			<a href="HomePage.jsp">Home</a>
		</p>
	</fieldset>
	<br>
	<br>
	<c:if test="${result != null}">
			${result}
	</c:if>
	<c:if test="${teachers != null}">
		<table>
			<tr>
				<th>Teacher ID</th>
				<th>First Name</th>
				<th>Last Name</th>
			</tr>
			<c:forEach var="teacher" items="${teachers}">
				<tr>
					<td><c:out value="${teacher.getTeacherID()}" /></td>
					<td><c:out value="${teacher.getFirstName()}" /></td>
					<td><c:out value="${teacher.getLastName()}" /></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>