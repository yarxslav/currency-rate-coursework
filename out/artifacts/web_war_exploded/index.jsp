<%@ page contentType="text/html;charset=UTF-16" language="java" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Currency Rate</title>
    <style type="text/css">
        <%@include file="css/main.css"%>
    </style>
</head>
<body>

<jstl:choose>

    <jstl:when test="${not empty sessionScope.admin}">
        <div class="logout-header">
            <p>Logged in as: ${sessionScope.admin.login}</p>
            <p><a href="controller?action=logout">Log out</a></p>
        </div>

        <jstl:if test="${not empty requestScope.contains}">
            <p class="alert">This currency already exists</p>
        </jstl:if>

        <div class="admin-panel">
        <form method="post" action="controller?action=create">
            <input class="input-data" type="text" name="code" placeholder="Currency code"/>
            <input class="input-data" name="name" placeholder="Currency name"/>
            <input class="btn" type="submit" value="Create"/>
        </form>

        <form method="post" action="controller?action=set">
            <input class="input-data" type="text" name="code" placeholder="Currency code"/>
            <input class="input-data" type="date" name="date"/>
            <input class="input-data" type="text" name="rate" placeholder="Currency rate"/>
            <input class="btn" type="submit" value="Set rate"/>
        </form>

        <jstl:if test="${not empty requestScope.notEdit}">
            <p class="alert">Currency not found</p>
        </jstl:if>

        <form method="post" action="controller?action=edit">
            <input class="input-data" type="text" name="code" placeholder="Currency code"/>
            <input class="input-data" type="text" name="newCode" placeholder="New code"/>
            <input class="input-data" type="text" name="name" placeholder="New name"/>
            <input class="btn" type="submit" value="Edit"/>
        </form>

        <jstl:if test="${not empty requestScope.notDelete}">
            <p class="alert"><jstl:out value="Currency not found"/></p>
        </jstl:if>

        <form method="post" action="controller?action=delete">
            <input class="input-data" type="text" name="code" placeholder="Currency code"/>
            <input class="btn" type="submit" value="Delete"/>
        </form>
        </div>

    </jstl:when>

    <jstl:otherwise>
        <div class="sign-up-in-header">
            <p id="sign-in"><a href="login.jsp">Sign in</a></p>
            <p id="sign-up"><a href="registration.jsp">Sign up</a></p>
        </div>
    </jstl:otherwise>
</jstl:choose>

<jstl:if test="${not empty requestScope.notContains}">
    <p class="alert">Currency not found</p>
</jstl:if>

<p>Check currency rate for the exact time period</p>
<form method="post" action="controller?action=search">
    <input class="input-data" type="text" name="code" placeholder="Currency code"/>
    From:<input class="input-data" type="date" name="dateFrom"/>
    To:<input class="input-data" type="date" name="dateTo"/>
    <input class="btn" type="submit" value="Find"/>
</form>

<jstl:if test="${requestScope.todayCurrencies.size() > 0}">

    <p>Today is: ${requestScope.today.date}. The official exchange rate is shown in the table below</p>

    <table>
        <tr>
            <th>Code</th>
            <th>Name</th>
            <th>Exchange rate</th>
        </tr>
    </table>
    <jstl:forEach items="${requestScope.todayCurrencies}" var="currency">
        <table>
            <tr>
                <td>${currency.code}</td>
                <td>${currency.name}</td>
                <td>${currency.dateRate.get(requestScope.today)}</td>
            </tr>
        </table>
    </jstl:forEach>
</jstl:if>


</body>
</html>

