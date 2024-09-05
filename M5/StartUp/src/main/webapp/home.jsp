<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
          crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <h1>Bienvenido Administrador ${admin.name}</h1>
        <h2 class="my-5">Lista de Usuarios</h2>

        <table class="table table-hover table-bordered text-center">
            <thead class="table-dark">
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Nombre</th>
                <th scope="col">Apodo</th>
                <th scope="col">Correo electrónico</th>
                <th scope="col">Peso</th>
                <th scope="col">Fecha de registro</th>
                <th scope="col">Última fecha de actualización</th>
                <th scope="col">Rol Asignado</th>
                <th scope="col">Dirección</th>
                <th scope="col">Numeración</th>
            </tr>
            </thead>
            <tbody>

            </tbody>

            <c:forEach var="user" items="${usersList}">
                <tr>
                    <td>${user.userId}</td>
                    <td>${user.name}</td>
                    <td>${user.nick}</td>
                    <td>${user.email}</td>
                    <td>${user.weight}</td>
                    <td>${user.createdAt}</td>
                    <td>${user.updatedAt}</td>

                    <c:if test="${user.rolId == 1}">
                        <td>Administrador</td>
                    </c:if>
                    <c:if test="${user.rolId == 2}">
                        <td>Usuario</td>
                    </c:if>

                    <td>${user.address}</td>
                    <td>${user.numbering}</td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous">
    </script>
</body>

</html>