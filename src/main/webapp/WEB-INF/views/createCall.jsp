<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="get" action="/savecalls/callsCreate">


    <p>
    <label for="start">Дата с: </label>
    <input type="date" id="start" name="start"/>
    </p>

    <%--<select name="passenger">--%>
        <%--<c:forEach items="${passengers}" var="passenger">--%>
            <%--<option value="${passenger.id}"><c:out value="${passenger.name}" /></option>--%>
        <%--</c:forEach>--%>
    <%--</select>--%>

    <select id="name" name="name">
        <c:forEach items="${names}" var="name">

        <option value="${name.getIdPersonal()}">
            <c:out value="${name.getName()}"/>
        </option>

    </c:forEach>
    </select>

    <select id="errors" name="error"> <c:forEach items="${errors}" var="error">
        <option value="${error.getIdDoctorsErrors()}"><c:out value="${error.getErrorsCharacter()}"/></option>
    </c:forEach>
    </select>

    <select id="callstypes" name="callstype"> <c:forEach items="${callstypes}" var="callstype">
        <option value="${callstype.getIdResultOfDoctorCalls()}"><c:out  value="${callstype.getTypeOfResult()}"/></option>

    </c:forEach>
    </select>



    <p>
        <button type="submit">Записать</button>
    </p>

</form>
<span>

    <a href="../persList" title="Отмена">Отмена</a>
</span>


</body>
</html>
