<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	 <h2>Edit Reservation</h2>
    
    <form action="${pageContext.request.contextPath}/reservation/update" method="post">
        <!-- CSRF token or other security measures if needed -->
        
        <!-- Bind reservation object to the form -->
        <input type="hidden" name="id" value="${reservation.id}" />
        
        <label for="firstName">First Name:</label>
        <input type="text" id="firstName" name="firstName" value="${reservation.firstName}" />
        
        <label for="lastName">Last Name:</label>
        <input type="text" id="lastName" name="lastName" value="${reservation.lastName}" />
        
        <!-- Add other fields as necessary -->
        
        <input type="submit" value="Update" />
    </form>
    
    <a href="${pageContext.request.contextPath}/reservation/list">Back to List</a>
</body>
</html>