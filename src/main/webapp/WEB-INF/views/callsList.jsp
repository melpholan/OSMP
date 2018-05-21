<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Вызова</title>
</head>
<body>

<table border="2px">

    <tr>

        <th>DAte</th>
        <th>Surname</th>
        <th>Famil</th>
        <th>kk</th>
        <th>ID</th>

    </tr>

    <c:forEach var="itm" items="${calls}">

        <tr>

            <td><c:out value="${itm.dateOfCall}"> dateOfCall</c:out></td>
            <td><c:out value="${itm.personal.getName()}">"   Personal  "</c:out></td>
            <td><c:out value="${itm.doctorsErrors.getErrorScale()}">doctorsErrors</c:out></td>
            <td><c:out value="${itm.resultOfDoctorsCalls.getTypeOfResult()}">resultOfDoctorsCalls</c:out></td>
            <td><c:out value="${itm.idCalls}"></c:out></td>

        </tr>

    </c:forEach>

</table>


</body>
</html>
