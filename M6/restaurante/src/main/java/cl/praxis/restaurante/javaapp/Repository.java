package cl.praxis.restaurante.javaapp;

import cl.praxis.restaurante.javaapp.models.Detalle;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Repository {
    private List<Detalle> detalles = new ArrayList<>();

    public Repository() {
        detalles.add(new Detalle(1, 3, 3, "Entrada"));
        detalles.add(new Detalle(2, 6, 3, "Plato Principal"));
        detalles.add(new Detalle(3, 7, 4, "Postre"));
        detalles.add(new Detalle(4, 8, 2, "Plato Principal"));
        detalles.add(new Detalle(5, 11, 6, "Postre"));
        detalles.add(new Detalle(6, 12, 5, "Entrada"));
        detalles.add(new Detalle(7, 16, 5, "Entrada"));
        detalles.add(new Detalle(8, 18, 5, "Plato Principal"));
        detalles.add(new Detalle(9, 20, 10, "Entrada"));
        detalles.add(new Detalle(10, 25, 5, "Postre"));
    }
}
