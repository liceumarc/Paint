<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html>

        <head>
            <title>Iniciar Sesión - Paint Personal</title>
        </head>

        <body>
            <h1>Iniciar Sesión en el Editor Personal 🎨</h1>

            <c:if test="${not empty error}">
                <p>${error}</p>
            </c:if>

            <form method="post" action="login">
                <div>
                    <label for="login">Login (Nombre de Usuario):</label>
                    <input type="text" id="login" name="login" required>
                </div>

                <div>
                    <label for="password">Contraseña:</label>
                    <input type="password" id="password" name="password" required>
                </div>

                <input type="submit" value="Entrar">
            </form>

            <hr>

            <p>¿Aún no tienes una cuenta? <a href="Register">Regístrate aquí</a></p>

        </body>

        </html>