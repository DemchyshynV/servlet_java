
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <title>Title</title>
    </head>

    <body>

        <hr>
        <h2 style="text-align: center"> users with cars from database: </h2>
        <hr>

        <div style="text-align: center">
            <c:forEach items="${users_with_cars}" var="user_with_car">
                <p> ${user_with_car} </p>
            </c:forEach>
        </div>
        <hr>

        <h3> add user to database: </h3>
        <form action="/users" method="post">
            <label> enter age:
                <input type="text" name="age" placeholder="user age">
            </label> <br> <br>

            <label> enter name:
                <input type="text" name="name" placeholder="user name">
            </label> <br> <br>

            <button> save </button>
        </form>
        <hr>

        <form action="/cars" method="post">
            <label> select user for adding car:
                <select name="userid">
                    <c:forEach items="${users}" var="user">
                        <option value="${user.getId()}">
                                ${user.getName()}
                        </option>
                    </c:forEach>
                </select>
            </label> <br> <br>

            <label> enter brand:
                <input type="text" name="brand" placeholder="car brand">
            </label> <br> <br>

            <button> save </button>
        </form>

    </body>
</html>
