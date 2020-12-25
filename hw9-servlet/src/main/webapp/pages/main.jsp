
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <title>Title</title>
    </head>

    <body>
        <h1> ADD NEW CAR TO CLUB </h1>

        <form action="${currentPath}/save" method="post">
            <label> enter model:
                <input type="text" name="model" placeholder="car model">
            </label> <br> <br>

            <label> enter color:
                <input type="text" name="color" placeholder="car color">
            </label> <br> <br>

            <label> enter producer:
                <input type="text" name="producer" placeholder="car producer">
            </label> <br> <br>

            <label> enter owner nickname:
                <input type="text" name="ownerNickname" placeholder="car owner nickname">
            </label> <br> <br>

            <label> enter owner age:
                <input type="number" name="ownerAge" placeholder="car owner age">
            </label> <br> <br>

            <button> save </button>
        </form>

        <hr>
        <h2 style="text-align: center"> Cars from database: </h2>
        <hr>

        <div style="text-align: center">
            <c:forEach items="${cars}" var="car">
                <h3> ${car.getId()}. ${car.getModel()} ${car.getColor()} </h3>
                <h4> producer: ${car.getProducer()} </h4>
                <p> owner: ${car.getOwnerNickname()} - ${car.getOwnerAge()} </p>
                <br>
            </c:forEach>
        </div>

    </body>
</html>
