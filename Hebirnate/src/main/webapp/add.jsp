<%--
  Created by IntelliJ IDEA.
  User: Михаил
  Date: 2017-05-09
  Time: 19:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Add New</h1>
<form action="/add" method="post">
    <table>
        <tr><td>Username:</td><td><input type="text" name="username"/></td></tr>
        <tr><td>Password:</td><td><input type="password" name="password"/></td></tr>
        <tr><td>Role:</td><td>
            <select name="role" style="width:150px">
                <option>admin</option>
                <option>user</option>
                <option>moderator</option>
                <option>Other</option>
            </select>
        </td></tr>
        <tr><td colspan="2"><input type="submit" value="add"/></td></tr>
    </table>
</form>


</body>
</html>
