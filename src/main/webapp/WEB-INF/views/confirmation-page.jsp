<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>Your reservation is confirmed successfully. Please, re-check the details.</p>
<br>First Name : ${reservation.firstName}
<br>Last Name : ${reservation.lastName}
<br><br>
<a href="${pageContext.request.contextPath}/reservation/list">List of Reservations</a>
</body>
</html>