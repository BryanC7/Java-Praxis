<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>Calculadora</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
          crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1 class="my-5">Calculadora</h1>
    <form method="post" action="Calculadora">
        <div class="mb-3">
            <label class="formlabel">Número 1</label>
            <input type="number" class="form-control" name="nro1" required>
        </div>

        <div class="mb-3">
            <label class="formlabel">Número 2</label>
            <input type="number" class="form-control" name="nro2" required>
        </div>

        <div class="mb-3">
            <select class="form-select" name="opcion" required>
                <option disabled selected>Selecciona una operación</option>
                <option value="1">Suma</option>
                <option value="2">Resta</option>
                <option value="3">Multiplicación</option>
                <option value="4">División</option>
                <option value="5">Ordenar Números</option>
                <option value="6">Indicar Par / Impar</option>
            </select>
        </div>

        <div class="mb-3">
            <button type="submit" class="btn btn-primary">Calcular</button>
        </div>
    </form>
</div>
<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous">
</script>
</body>
</html>