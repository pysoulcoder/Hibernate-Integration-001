<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error Page</title>
</head>
<body>

${message}
<br><br>
<h2>An error occurred</h2>
    <p>Sorry, the reservation form  could not be found or processed.</p>
    <a href="${pageContext.request.contextPath}/reservation/bookingForm">Return to Booking Form</a>

</body>
</html>