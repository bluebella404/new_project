<%--
  Created by IntelliJ IDEA.
  User: Михаил
  Date: 2017-05-11
  Time: 03:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Update Employee</h1>
    <form action='/edit' method='post'>
    <table>
        <tr><td></td><td><input type='hidden' name='id' value=${user.id}></td></tr>
        <tr><td>Name:</td><td><input type='text' name='username' value=${user.username}></td></tr>
        <tr><td>Password:</td><td><input type='password' name='password' value=${user.password}></td></tr>
        <tr><td>Role:</td><td><input type='text' name='role' value=${user.role}></td></tr>
        <tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>
        </table>
    </form>




</body>
</html>
