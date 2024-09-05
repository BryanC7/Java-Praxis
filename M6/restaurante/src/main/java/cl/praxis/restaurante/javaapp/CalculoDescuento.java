package cl.praxis.restaurante.javaapp;

import cl.praxis.restaurante.javaapp.models.Detalle;

import java.util.List;

public interface CalculoDescuento {
    List<Double> calculoDescuento(List<Detalle> detalles);
}
