<%@ page contentType="text/html;charset=UTF-16" language="java" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Sign up</title>
    <style type="text/css">
        <%@include file="css/login-register.css"%>
    </style>
</head>
<body>

<jstl:if test="${not empty requestScope.notAdd}">
    <p class="alert">Admin with this login already exists</p>
</jstl:if>

<div class="login-page">
    <div class="form">
        <form method="post" action="controller?action=register">
            <p><input type="text" name="login" size="10" placeholder="Login"/></p>
            <p><input type="password" name="password" size="10" placeholder="Password"/></p>
            <p><input type="submit" value="Sign up"/></p>
        </form>
    </div>
</div>

</body>
</html>
