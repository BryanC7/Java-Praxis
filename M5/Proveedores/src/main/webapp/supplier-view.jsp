<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>Detalles del Proveedor</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
          crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <h1 class="text-center my-5">Todos los detalles del proveedor seleccionado</h1>

        <table class="table w-50 mx-auto">
            <thead>
                <tr>
                    <th scope="col"></th>
                    <th scope="col"></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <th scope="row">ID:</th>
                    <td class="text-center">${supplier.supplierId}</td>
                </tr>
                <tr>
                    <th scope="row">Nombre del Proveedor:</th>
                    <td class="text-center">${supplier.name}</td>
                </tr>
                <tr>
                    <th scope="row">Rut del Proveedor:</th>
                    <td class="text-center">${supplier.rut}</td>
                </tr>
                <tr>
                    <th scope="row">Dirección del Proveedor:</th>
                    <td class="text-center">${supplier.address}</td>
                </tr>
                <tr>
                    <th scope="row">Correo electrónico:</th>
                    <td class="text-center">${supplier.email}</td>
                </tr>
                <tr>
                    <th scope="row">Número de teléfono:</th>
                    <td class="text-center">${supplier.phoneNumber}</td>
                </tr>
                <tr>
                    <th scope="row">Contacto del Proveedor:</th>
                    <td class="text-center">${supplier.contact}</td>
                </tr><tr>
                    <th scope="row">Número del Contacto:</th>
                    <td class="text-center">${supplier.contactPhone}</td>
                </tr>
            </tbody>
        </table>
        <div class="text-center mt-5">
            <a class="btn btn-secondary" href="supplier">Regresa a la lista</a>
        </div>
    </div>

<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous">
</script>
</body>
</html>