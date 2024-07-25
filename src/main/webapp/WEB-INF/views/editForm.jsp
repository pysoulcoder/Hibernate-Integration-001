<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<title>Edit Reservation Form</title>
</head>
<body>
	<h2>Edit Reservation Form</h2>
	<form:form method="post"
		action="${pageContext.request.contextPath}/reservation/update"
		modelAttribute="reservation">
		<form:hidden path="id" />
		<div>
			<form:label path="firstName">First Name:</form:label>
			<form:input path="firstName" />
		</div>
		<div>
			<form:label path="lastName">Last Name:</form:label>
			<form:input path="lastName" />
		</div>
		<input type="submit" value="Update" />
	</form:form>

</body>
</html>
