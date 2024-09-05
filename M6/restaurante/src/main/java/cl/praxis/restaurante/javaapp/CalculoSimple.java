package cl.praxis.restaurante.javaapp;

import cl.praxis.restaurante.javaapp.models.Detalle;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class CalculoSimple implements CalculoDescuento {

    @Override
    public List<Double> calculoDescuento(List<Detalle> detalles) {
        List<Double> descuento = new ArrayList<>();
        detalles.forEach(detalle -> {
            if(detalle.getCantidadPlatos() > 5 && detalle.getCantidadPlatos() < 10 && detalle.getCategoriaPlato().equals("Entrada")) {
                descuento.add(0.03);
            } else if (detalle.getCantidadPlatos() > 5 && detalle.getCantidadPlatos() < 10 && detalle.getCategoriaPlato().equals("Plato Principal")) {
                descuento.add(0.05);
            } else if (detalle.getCantidadPlatos() > 5 && detalle.getCantidadPlatos() < 10 && detalle.getCategoriaPlato().equals("Postre")) {
                descuento.add(0.04);
            } else if (detalle.getCantidadPlatos() >= 10 && detalle.getCantidadPlatos() < 15) {
                descuento.add(0.1);
            } else if (detalle.getCantidadPlatos() >= 15 && detalle.getCategoriaPlato().equals("Entrada")) {
                descuento.add(0.15);
            } else if (detalle.getCantidadPlatos() >= 15 && detalle.getCategoriaPlato().equals("Plato Principal")) {
                descuento.add(0.3);
            } else if (detalle.getCantidadPlatos() >= 15 && detalle.getCategoriaPlato().equals("Postre")) {
                descuento.add(0.2);
            } else {
                descuento.add(0.0);
            }
        });
        return descuento;
    }
}
