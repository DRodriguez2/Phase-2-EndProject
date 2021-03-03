<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Configure Subject Master List</h2>
	<form action="/AdminPortal/Subjects" method="post">
		<fieldset>
			<legend>Add Subject to Subject Master List</legend>
			<p>
				Enter Subject: <input type="text" name="addSubject"><br>
				<input type="hidden" name="formAction" value="1" />
				<input type="submit">
			</p>
		</fieldset>
		<fieldset>
			<legend>Delete Subject From Subject Master List</legend>
			<p>
				Enter Subject: <input type="text" name="addSubject"><br>
				<input type="submit">
			</p>
		</fieldset>
	</form>
	<form action="Subjects" method="get">
		<fieldset>
			<p>
				<input type="submit" value="View Master List">
			</p>
		</fieldset>
	</form>
	<c:if test="${result != null}">
			${result}
	</c:if>
</body>
</html>