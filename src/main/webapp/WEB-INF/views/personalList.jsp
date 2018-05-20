<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html/>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table border="2px">

    <tr>

        <th>Name</th>
        <th>Surname</th>
        <th>Famil</th>
        <th>ID</th>

    </tr>

    <c:forEach var="itm" items="${personalList}">

    <tr>

            <td><c:out value="${itm.name}"></c:out></td>
            <td><c:out value="${itm.surname}"></c:out></td>
            <td><c:out value="${itm.patronymic}"></c:out></td>
            <td><c:out value="${itm.idPersonal}"></c:out></td>

    </tr>

    </c:forEach>

</table>

</body>
</html>
