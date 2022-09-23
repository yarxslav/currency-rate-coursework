<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>${requestScope.dateCurrency.name} Rate</title>
    <style type="text/css">
        <%@include file="css/main.css"%>
    </style>
</head>
<body>

<p class="logout-header"><a href="controller?action=main">Go home</a></p>

<jstl:choose>

    <jstl:when test="${not empty sessionScope.admin}">
        <div class="logout-header">
            <p>Logged in as: ${sessionScope.admin.login}</p>
            <p><a href="controller?action=logout">Log out</a></p>
        </div>

    </jstl:when>

    <jstl:otherwise>
        <div class="sign-up-in-header">
            <p><a href="registration.jsp">Sign up</a></p>
            <p><a href="login.jsp">Sign in</a></p>
        </div>

    </jstl:otherwise>
</jstl:choose>

<jstl:if test="${not empty requestScope.notContains}">
    <p class="alert">Currency not found</p>
</jstl:if>

<jstl:if test="${not empty requestScope.notDate}">
    <p class="alert">Enter another date</p>
</jstl:if>

<p>You entered: ${requestScope.dateCurrency.name}. The table below presents the exchange rate of hryvnia against this
    currency</p>

    <table>
        <tr>
            <th>Code</th>
            <th>Name</th>
            <th>Exchange rate</th>
            <th>Date</th>
        </tr>
    </table>
    <jstl:forEach items="${requestScope.listOfDate}" var="date">
        <table>
            <tr>
                <td>${requestScope.dateCurrency.code}</td>
                <td>${requestScope.dateCurrency.name}</td>
                <td>${date.rates.get(requestScope.dateCurrency)}</td>
                <td>${date.date}</td>
            </tr>
        </table>
    </jstl:forEach>

</body>
</html>
