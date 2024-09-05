<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Desafio 1</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
          crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1 class="text-center my-3">Desafío 1 - JEE & JSP</h1>
    <div class="row">
        <div class="col">
            <table class="table table-light table-hover table-bordered text-center">
                <thead>
                <tr class="table-dark">
                    <th scope="col">Números</th>
                    <th scope="col">Calcular Factorial</th>
                    <th scope="col">¿Es Par o Impar?</th>
                </tr>
                </thead>
                <tbody>
                <%
                    for (int x = 0; x <= 10; x++) {
                %>
                <tr>
                    <td>Número <%=x%></td>
                    <td><a href="Fibonacci?value=<%=x%>">Factorial de <%=x%></a></td>
                    <td><a href="PairOdd?value=<%=x%>">¿Es par o impar el número <%=x%>?</a></td>
                </tr>
                <%
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>
</div>
<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous">
</script>
</body>
