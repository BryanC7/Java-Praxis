<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>Login de Usuario</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
          crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1 class="text-center my-5">Login Start Up</h1>
    <form class="w-50 mx-auto" action="user?action=login" method="post">
        <div class="mb-3">
            <label for="email">Correo:</label>
            <input class="form-control" type="email" id="email" name="email" required>
        </div>
        <div class="mb-3">
            <label for="password">Contraseña:</label>
            <input class="form-control" type="password" id="password" name="password" required>
        </div>

        <div class="mb-3">
            <button type="submit" class="btn btn-primary">Logearse</button>
            <a class="btn btn-secondary" href="user?action=register">Registra una cuenta</a>
        </div>
    </form>

    <c:choose>
        <c:when test = "${msgError != null}">
            <div class="mt-5 alert alert-danger" role="alert">
                <c:out value="${msgError}"/>
            </div>
        </c:when>

        <c:when test = "${msgNoAdmin != null}">
            <div class="mt-5 alert alert-danger" role="alert">
                <c:out value="${msgNoAdmin}"/>
            </div>
        </c:when>

        <c:when test = "${msgSuccess != null}">
            <div class="mt-5 alert alert-success" role="alert">
                <c:out value="${msgSuccess}"/>
            </div>
        </c:when>
    </c:choose>
</div>
</body>
</html>