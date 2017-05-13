<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.usersite.controller.UserServlet"%>
<%@ page import="com.usersite.models.User"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.SQLException" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>All User</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Username</th>
        <th>Role</th>
    </tr>
    </thead>


    <tbody>



    <c:forEach var="user" items="${users}">
    <tr>
        <td><c:out value="${user.id}" /> </td>
        <td><c:out value="${user.username}" /></td>
        <td><c:out value="${user.role}" /> </td>
        <td>
            <a href="/edit?id=<c:out value='${user.id}' />">Edit</a>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <a href="/delete?id=<c:out value='${user.id}' />">Delete</a>
        </td>
    </tr>
                </c:forEach>

    </tbody>





</table>
<p><a href="/add">Add User</a></p>

</body>
</html>