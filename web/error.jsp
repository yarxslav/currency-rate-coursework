<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error!</title>
    <style type="text/css">
        <%@include file="css/login-register.css"%>
    </style>
</head>
<body>
    <p class="alert"> Ooops, error occurred while trying to process your request on ${requestScope.ServletName}! </p>
    <p class="alert"> Please, try again</p>
    <p> <a href="controller?action=main"> </a></p>
</body>
</html>
