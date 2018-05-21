<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Расчет премии</title>
</head>
<body>


<span>
     <a href="../persList" title="Отмена">Список сотрудников</a>
</span>
    <span>
    <a href="/savecalls/create">Записать вызов</a>
</span>

<table border="2px">

    <tr>

        <th>ID</th>
        <th>Фамилия</th>
        <th>Баллы</th>
        <th>Вызова</th>
        <th>Ошибки</th>
        <th>Нагрузка</th>
        <th>Часы</th>
        <th>Премия</th>

    </tr>

    <c:forEach var="itm" items="${premiumMap.keySet()}">


        <tr>
            <td><c:out value="${personal.get(itm).getIdPersonal()}"> dateOfCall</c:out></td>

            <td><c:out value="${personal.get(itm).getName()}">"   Personal  "</c:out></td>
            <td><c:out value="${premiumMap.get(itm).getBall()}"> dateOfCall</c:out></td>
        <td><c:out value="${premiumMap.get(itm).getCalls()}">doctorsErrors</c:out></td>
            <td><c:out value="${premiumMap.get(itm).getErrors()}">doctorsErrors</c:out></td>
            <td><c:out value="${premiumMap.get(itm).getLoad()}">doctorsErrors</c:out></td>
            <td><c:out value="${premiumMap.get(itm).getWorkHours()}">doctorsErrors</c:out></td>
            <td><c:out value="${premiumMap.get(itm).getPremium()}">doctorsErrors</c:out></td>

            <%--<td><c:out value="${itm.resultOfDoctorsCalls.getTypeOfResult()}">resultOfDoctorsCalls</c:out></td>--%>
            <%--<td><c:out value="${itm.getErrors()}"></c:out></td>--%>
            <%--<td><c:out value="${itm.getPremium()}"></c:out></td>--%>
            <%--<td><c:out value="${itm.getPremium()}"></c:out></td>--%>

        </tr>


    </c:forEach>

</table>
<span>
    Средняя нагрузка за период составила ${load} вызовов в сутки.
</span>


</body>
</html>