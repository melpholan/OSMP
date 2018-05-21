<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <title>Премия за период</title>
</head>
<body>

<a href="../persList" title="Отмена">Список сотрудников</a>

<h1> за период</h1>
<div>

    <form method="get" action="/prem/calculatePremium">
        <p>
            <label for="start">Дата с: </label>
            <input type="date" id="start" name="start"/>
        </p>

        <p>
            <label for="finish">Дата по: </label>
            <input type="date" id="finish" name="finish"/>
        </p>

        <p>
            <label for="money">Сумма фонда : </label>
            <input type="number" id="money" name="money"/>
        </p>

        <p>
            <label for="coefficient">Коэффициент поощрения: </label>
            <input type="number" id="coefficient" name="coefficient"
                   value="0" min="0" max="1" step="0.01"/>
        </p>

        <p>
            <label for="callsNorm">Норма вызовов: </label>
            <input type="number" id="callsNorm" name="callsNorm"/>
        </p>

        <p>
            <button type="submit">Рассчитать</button>
        </p>

    </form>

</div>

</body>
</html>