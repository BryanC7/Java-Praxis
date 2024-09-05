<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>Registro de Usuario</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
          crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1 class="text-center my-5">Registra tus Datos</h1>
    <form class="w-50 mx-auto" action="user?action=insert" method="post">
        <div class="mb-3">
            <label for="name">Nombre:</label>
            <input class="form-control" type="text" id="name" name="name" required>
        </div>
        <div class="mb-3">
            <label for="nick">Apodo:</label>
            <input class="form-control" type="text" id="nick" name="nick" required>
        </div>
        <div class="mb-3">
            <label for="email">Correo:</label>
            <input class="form-control" type="email" id="email" name="email" required>
        </div>
        <div class="mb-3">
            <label for="weight">Peso:</label>
            <input class="form-control" type="number" id="weight" name="weight" required>
        </div>
        <div class="mb-3">
            <label for="address">Dirección:</label>
            <input class="form-control" type="text" id="address" name="address" required>
        </div>
        <div class="mb-3">
            <label for="numbering">Numeración:</label>
            <input class="form-control" type="text" id="numbering" name="numbering" required>
        </div>
        <div class="mb-3">
            <label for="password">Contraseña:</label>
            <input class="form-control" type="password" id="password" name="password" required>
        </div>

        <div class="mb-3">
            <button type="submit" class="btn btn-primary">Registrar</button>
            <a class="btn btn-secondary" href="user">Regresa al login</a>
        </div>
    </form>

    <c:if test="${msgError != null}">
        <div class="mt-5 alert alert-danger" role="alert">
            <c:out value="${msgError}"></c:out>
        </div>
    </c:if>

</div>

<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous">
</script>
</body>
</html>