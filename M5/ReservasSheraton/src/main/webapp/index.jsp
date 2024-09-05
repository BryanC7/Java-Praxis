<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page import="java.util.List" %>
<%@ page import="cl.praxis.reservassheraton.business.HabitacionBusiness" %>
<%@ page import="cl.praxis.reservassheraton.model.Habitacion" %>
<%
  HabitacionBusiness habitacionb = new HabitacionBusiness();
  List<Habitacion> listaHabitaciones = habitacionb.getHabitaciones();
  request.setAttribute("listaHabitaciones", listaHabitaciones);
%>

<!DOCTYPE html>
<html lang="es">
<%@include file="assets/html/head.jsp"%>
<body>
<%@include file="assets/html/header.jsp"%>

<form method="post" action="procesa.jsp">
  <section class="py-5">
    <div class="container px-4 px-lg-5 mt-5">
      <div class="row justify-content-center">
        <h1>
          Habitaciones Disponibles
          (<%=listaHabitaciones.size()%>)
        </h1>
        <hr/>
      </div>
      <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
        <c:forEach var="habitacion" items="${listaHabitaciones}">
          <div class="col mb-5">
            <div class="card h-100">
              <img class="card-img-top" src="${habitacion.imagen}" alt="${habitacion.nombre}" />
              <div class="card-body p-4">
                <div class="text-center">
                  <h5 class="fw-bolder"><c:out value="${habitacion.nombre}" /></h5>
                  <p><c:out value="${habitacion.descripcion}" /></p>
                  CL$ <c:out value="${habitacion.precio}" />
                </div>
              </div>
              <input class="mb-3" type="radio" name="idhabitacion" value="${habitacion.id}" checked />
            </div>
          </div>
        </c:forEach>

      </div>
    </div>
  </section>

  <section>
    <div class="container px-4 px-lg-5 mt-5">
      <h1>Información de Reserva Habitación</h1>
      <hr />
      <form method="post" action="procesa.jsp">
        <div class="row g-3">
          <div class="col-md-6">
            <label class="formlabel">Nombre</label>
            <input type="text" class="form-control" name="nombre" value="Arturo Erasmo">
          </div>
          <div class="col-md-6">
            <label class="formlabel">Apellido</label>
            <input type="text" class="form-control" name="apellido" value="Vidal Pardo">
          </div>
          <div class="col-md-6">
            <label class="formlabel">Email</label>
            <input type="text" class="form-control" name="email" value="arturo.vidal@anfp.cl">
          </div>

          <div class="col-md-6">
            <div class="row">
              <div class="col">
                <label class="formlabel">Medio de pago</label>
                <select name="pago" class="form-select">
                  <option value="Contado">Contado</option>
                  <option value="Cuotas">Cuotas</option>
                </select>
              </div>
              <div class="col">
                <label class="formlabel">Días</label>
                <select name="dias" class="form-select">
                  <c:forEach var="i" begin="1" end="15">
                    <option value="${i}">${i} día(s)</option>
                  </c:forEach>
                </select>
              </div>
              <div class="col">
                <label class="formlabel">Fecha Entrada</label>
                <select name="fecha" class="form-select">
                  <c:forEach var="i" begin="1" end="31">
                    <option value="${i} de Julio del 2024">${i} de Julio del 2024</option>
                  </c:forEach>
                </select>
              </div>
            </div>
          </div>
          <div class="col-md-6">
            <button type="submit" class="btn btn-primary">Enviar Solicitud de Compra</button>
          </div>
        </div>
      </form>
    </div>
  </section>
  <br /> <br />

<%@include file="assets/html/footer.jsp"%>
</body>
</html>