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
    <title>Register</title>
</head>
<body>
    <form method="POST" action="getRegister">
        <table>
            <tr>
                <td><label>*Firstname:</label></td>
                <td><input autocomplete="1" maxlength="30" required="1" type="text" name="firstname"/></td>
            </tr>
            <tr>
                <td><label>*Secondname:</label></td>
                <td><input autocomplete="1" maxlength="30" required="1" type="text" name="secondname"/></td>
            </tr>
            <tr>
                <td><label>*Login:</label></td>
                <td><input autocomplete="1" maxlength="30" required="1" type="text" name="login"/></td>
            </tr>
            <tr>
                <td><label>*Email:</label></td>
                <td><input placeholder="example@example.com" required="1" type="email" name="email"/></td>
            </tr>
            <tr>
                <td><label> Phone:</label></td>
                <td><input autocomplete="1" type="phone" name="phone"/></td>
            </tr>
            <tr>
                <td><label>*Password</label></td>
                <td><input type="password" required="1" name="password" maxlength="30"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Register"/></td>
                <td><a href="login">I already have an account</a></td>
            </tr>
            <tr><td>*-required</td></tr>
        </table>
    </form>
</body>
</html>
