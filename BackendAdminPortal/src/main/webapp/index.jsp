<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>
	<form action="Login" method="post">
		<fieldset>
			<legend>Administrator Login</legend>
			<p>
				Enter Administrator Password: <input type="text" name="password"><br>
				<input type="submit">
			</p>
		</fieldset>
	</form>
	<c:if test="${loginResult != null}">
			${loginResult}
	</c:if>

</body>
</html>
