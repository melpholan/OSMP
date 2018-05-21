<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <title>Вызовы за период</title>
</head>
<body>

<h1>Получить вызовы за период</h1>
<div>

    <form method="get" action="/calls/callsByDateInterval">
        <p>
            <label for="start">Дата с: </label>
            <input type="date" id="start" name="start"/>
        </p>
        <p>
            <label for="finish">Дата по: </label>
            <input type="date" id="finish" name="finish"/>
        </p>
        <p>
            <button type="submit">Найти</button>
        </p>
    </form>

</div>
<%--<form:form method="POST" action="/calls/callsList" commandName="calls">--%>
<%--<table>--%>
<%--<tr>--%>
<%--<td><form:label path="start">Дата с</form:label></td>--%>
<%--<td><form:input path="start" /></td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td><form:label path="finish">Дата по</form:label></td>--%>
<%--<td><form:input path="finish" /></td>--%>
<%--</tr>--%>

<%--<tr>--%>
<%--<td colspan="2">--%>
<%--<input type="submit" value="Submit" />--%>
<%--</td>--%>
<%--</tr>--%>
<%--</table>--%>
<%--</form:form>--%>

</body>
</html>
