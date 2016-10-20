<%--
        Created by IntelliJ IDEA.
        User: devnull
        Date: 09.10.16
        Time: 22:36
        To change this template use File | Settings | File Templates.
        --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form method="POST" action="log">
    <table>
        <tr>
            <td><label>Login:</label></td>
            <td><input type="text" name="login"/></td>
        </tr>
        <tr>
            <td><label>Password</label></td>
            <td><input type="password" name="password"/></td>
        </tr>
        <tr>
            <td><input type="submit" name="log" value="Log in"/></td>
            <td><a href="register">Are you here for first time?</a></td>
        </tr>
    </table>
</form>
</body>
</html>
