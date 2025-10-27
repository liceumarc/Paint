<%@ page isELIgnored="false" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <html>

        <head>
            <title>Paint</title>
            <link rel="stylesheet" href="./../css/login.css">
        </head>

        <body>
            <section id="login">
                <form action="/login" method="post">
                    <label for="user">Username</label>
                    <input type="text" name="user">
                    <label for="password">Password</label>
                    <input type="password" name="password">
                    <input type="submit">
                </form>

                <div>
                    <c:if test="${not empty message}">
                        ${message}
                    </c:if>
                    <div>
            </section>
        </body>

        </html>