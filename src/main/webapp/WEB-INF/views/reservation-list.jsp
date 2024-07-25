<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f4f4f4;
    }
    .container {
        width: 80%;
        margin: auto;
        overflow: hidden;
    }
    header {
        background: #333;
        color: #fff;
        padding: 10px 0;
        text-align: center;
    }
    nav {
        display: flex;
        justify-content: center;
        margin: 10px 0;
    }
    nav a {
        color: #fff;
        text-decoration: none;
        padding: 10px 20px;
        margin: 0 10px;
        background: #555;
        border-radius: 5px;
        transition: background 0.3s;
    }
    nav a:hover {
        background: #666;
    }
    .content {
        padding: 20px;
        background: #fff;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0,0,0,0.1);
    }
    h2 {
        border-bottom: 2px solid #333;
        padding-bottom: 10px;
    }
    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
    }
    table th, table td {
        border: 1px solid #ddd;
        padding: 10px;
        text-align: left;
    }
    table th {
        background-color: #333;
        color: #fff;
    }
    table tr:nth-child(even) {
        background-color: #f2f2f2;
    }
    table tr:hover {
        background-color: #ddd;
    }
    .action-links a {
        text-decoration: none;
        color: #007bff;
        margin: 0 5px;
    }
    .action-links a:hover {
        text-decoration: underline;
    }
    .confirm-delete {
        color: #ff0000;
    }
</style>
</head>
<body>
    <header>
        <div class="container">
            <h1>Reservation Management</h1>
        </div>
    </header>
    
    <div class="container">
        <nav>
            <a href="${pageContext.request.contextPath}/reservation/bookingForm">Booking Form</a>
            <a href="${pageContext.request.contextPath}/reservation/list">List of Reservations</a>
        </nav>
        
        <div class="content">
            <h2>Reservations</h2>
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="reservation" items="${reservations}">
                        <tr>
                            <td><c:out value="${reservation.id}" /></td>
                            <td><c:out value="${reservation.firstName}" /></td>
                            <td><c:out value="${reservation.lastName}" /></td>
                            <td class="action-links">
                                <a href="${pageContext.request.contextPath}/reservation/editForm?id=${reservation.id}">Edit</a>
                            </td>
                            <td class="action-links">
                                <a href="${pageContext.request.contextPath}/reservation/delete?id=${reservation.id}" 
                                   onclick="return confirm('Are you sure you want to delete this reservation?')">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
