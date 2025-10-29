<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

        <!DOCTYPE html>
        <html>

        <head>
            <title>Registro de Usuario</title>
        </head>

        <body>
            <h2>Registrar una nueva cuenta</h2>

            <c:if test="${not empty message}">
                <p>${message}</p>
            </c:if>

            <form method="post" action="Register">
                <div>
                    <label for="name">Nombre Completo:</label>
                    <input type="text" id="name" name="name" required>
                </div>

                <div>
                    <label for="login">Login (Nombre de Usuario):</label><br>
                    <input type="text" id="login" name="login" required><br><br>
                </div>

                <div>
                    <label for="password">Contraseña (Mín. 8 chars, 1 mayús, 1 especial, 1 dígito):</label>
                    <input type="password" id="password" name="password" required minlength="8">
                </div>

                <div>
                    <input type="submit" value="Crear Cuenta">
                </div>
            </form>

            <hr>
            <p>¿Ya tienes cuenta? <a href="login">Inicia Sesión aquí</a></p>
        </body>

        </html>