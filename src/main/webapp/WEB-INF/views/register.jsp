<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"%>
        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Register</title>
</head>
<body>
    <form action="getRegister" method="POST">
        <table>
            <tr>
                <td><label>*Firstname:</label></td>
                <td><input autocomplete="autocomplete" maxlength="30" required="1" type="text" name="reg_fname"/></td>
            </tr>
            <tr>
                <td><label>*Secondname:</label></td>
                <td><input autocomplete="autocomplete" maxlength="30" required="1" type="text" name="reg_sname"/></td>
            </tr>
            <tr>
                <td><label>*Login:</label></td>
                <td><input autocomplete="autocomplete" maxlength="30" required="1" type="text" name="reg_login"/></td>
            </tr>
            <tr>
                <td><label>*Email:</label></td>
                <td><input placeholder="example@example.com" required="1" type="email" name="reg_email"/></td>
            </tr>
            <tr>
                <td><label > Phone:</label></td>
                <td><input autocomplete="autocomplete" type="phone" name="reg_phone"/></td>
            </tr>
            <tr>
                <td><label>*Password</label></td>
                <td><input type="password" required="required" name="reg_password" maxlength="30"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Register" name="getRegister"/></td>
                <td><a href="login">I already have an account</a></td>
            </tr>
            <tr><td>*-required</td></tr>
        </table>
    </form>
</body>
</html>
