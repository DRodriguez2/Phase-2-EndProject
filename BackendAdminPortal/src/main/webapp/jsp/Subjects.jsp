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
	<h2>Configure Subject Master List</h2>
	<form action="/AdminPortal/Subjects" method="post">
		<fieldset class="fieldset-auto-width">
			<legend>Add Subject to Subject Master List</legend>
			<p>
				Enter Subject: <input type="text" name="addSubject"><br>
				<input type="hidden" name="formAction" value="1" /> <input
					type="submit">
			</p>
		</fieldset>
	</form>
	<br>
	<br>
	<form action="/AdminPortal/Subjects" method="post">
		<fieldset class="fieldset-auto-width">
			<legend>Delete Subject From Subject Master List</legend>
			<p>
				Enter Subject: <input type="text" name="deleteSubject"><br>
				<input type="hidden" name="formAction" value="2" /> <input
					type="submit">
			</p>
		</fieldset>
	</form>
	<br>
	<br>
	<form action="/AdminPortal/Subjects" method="get">
		<fieldset class="fieldset-auto-width">
			<legend>View Subject Master List</legend>
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
	<c:if test="${subjects != null}">
		<table>
			<tr>
				<th>Subject</th>
			</tr>
			<c:forEach var="subject" items="${subjects}">
				<tr>
					<td><c:out value="${subject.getSubject()}" /></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>