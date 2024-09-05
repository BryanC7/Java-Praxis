<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Proveedores</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
          crossorigin="anonymous">
</head>

<body>
<div class="container">
    <h1 class="mt-3">Lista de Proveedores</h1>
    <a class="btn btn-primary my-3" href="supplier?action=new">Agregar nuevo proveedor</a>

    <table class="table table-hover table-bordered text-center">
        <thead class="table-dark">
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Nombre</th>
                <th scope="col">Rut</th>
                <th scope="col">Dirección</th>
                <th scope="col">Correo</th>
                <th scope="col">Número de teléfono</th>
                <th scope="col">Contacto</th>
                <th scope="col">Número de contacto</th>
                <th scope="col">Acciones</th>
            </tr>
        </thead>
        <tbody>

        </tbody>

        <c:forEach var="supplier" items="${listSuppliers}">
            <tr>
                <td>${supplier.supplierId}</td>
                <td>${supplier.name}</td>
                <td>${supplier.rut}</td>
                <td>${supplier.address}</td>
                <td>${supplier.email}</td>
                <td>${supplier.phoneNumber}</td>
                <td>${supplier.contact}</td>
                <td>${supplier.contactPhone}</td>
                <td>
                    <div class="d-flex gap-2">
                        <a class="btn btn-success" role="button" href="supplier?action=view&id=${supplier.supplierId}">Ver</a>
                        <a class="btn btn-warning" role="button" href="supplier?action=edit&id=${supplier.supplierId}">Editar</a>
                        <a class="btn btn-danger" role="button" href="supplier?action=delete&id=${supplier.supplierId}" onclick="return confirm('¿Estás seguro de eliminar a ${supplier.name} de la lista?')">Eliminar</a>
                    </div>
                </td>
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

