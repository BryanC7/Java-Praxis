<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page import="cl.praxis.reservassheraton.model.Habitacion" %>
<%@ page import="cl.praxis.reservassheraton.business.HabitacionBusiness" %>
<%
    int idHabitacion = Integer.parseInt(request.getParameter("idhabitacion"));
    int dias = Integer.parseInt(request.getParameter("dias"));

    HabitacionBusiness habitacionb = new HabitacionBusiness();

    Habitacion habitacion = new Habitacion();
    habitacion.setId(idHabitacion);

    habitacion = habitacionb.getHabitacionbyID(habitacion);
    int valorCompra = habitacionb.calculaValorCompra(habitacion.getPrecio(), dias);

%>
<!DOCTYPE html>
<html lang="es">
<%@include file="assets/html/head.jsp"%>
<body>
<%@include file="assets/html/header.jsp"%>

<section class="py-5">
    <div class="container px-4 px-lg-5 mt-5">
        <div class="row justify-content-center">
            <h1>
                Detalle Habitación:
                <strong><%=habitacion.getNombre()%></strong>
            </h1>
            <hr>
        </div>
    </div>
    <div class="container px-4 px-lg-5 mt-5">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Item</th>
                <th scope="col">Valor</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <th scope="row">1</th>
                <td>Nombre</td>
                <td><c:out value="${param.nombre}"/></td>
            </tr>
            <tr>
                <th scope="row">2</th>
                <td>Apellido</td>

                <td><c:out value="${param.apellido}"/></td>
            </tr>
            <tr>
                <th scope="row">3</th>
                <td>Email</td>
                <td><c:out value="${param.email}"/></td>
            </tr>
            <tr>
                <th scope="row">4</th>
                <td>Medio de Pago</td>
                <td><c:out value="${param.pago}"/></td>
            </tr>
            <tr>
                <th scope="row">5</th>
                <td>Días</td>
                <td><c:out value="${param.dias}"/></td>
            </tr>
            <tr>
                <th scope="row">6</th>
                <td>Fecha de Entrada</td>
                <td><c:out value="${param.fecha}"/></td>
            </tr>
            <tr>
                <th scope="row">7</th>
                <td>Valor de Pago</td>
                <td><strong>CL$ <%= valorCompra %></strong></td>
            </tr>
            </tbody>
        </table>
    </div>
</section>
<br /> <br />

<%@include file="assets/html/footer.jsp"%>
</body>
</html>
