<%--
        Created by IntelliJ IDEA.
        User: devnull
        Date: 09.10.16
        Time: 22:36
        To change this template use File | Settings | File Templates.
        --%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Home</title>
<link type="text/css" rel="stylesheet" href="/resource/style.css" />
</head>
<body>
	<form action="newProduct" method="post">
		<input name="product_name" type="text" placeholder="Name" required >
		<input name="product_number" type="text" placeholder="Number" required >
		<input name="product_price" type="text" placeholder="Price" required>
		<button>Save product</button>
	</form>


</body>
</html>
