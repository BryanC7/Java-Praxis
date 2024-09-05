package cl.praxis.restaurante.javaapp;

import cl.praxis.restaurante.javaapp.models.Detalle;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class CalculoComplejo implements CalculoDescuento {
    @Override
    public List<Double> calculoDescuento(List<Detalle> detalles) {
        List<Double> descuento = new ArrayList<>();
        detalles.forEach(detalle -> {
            if(detalle.getCantidadPlatos() > 5 && detalle.getCapacidadMesa() < 4) {
                descuento.add(0.15);
            } else if ((detalle.getCantidadPlatos() >= 5 && detalle.getCantidadPlatos() <= 15) && (detalle.getCapacidadMesa() >= 4 && detalle.getCapacidadMesa() <= 6)) {
                descuento.add(0.2);
            } else if (detalle.getCantidadPlatos() > 15 && detalle.getCapacidadMesa() > 6) {
                descuento.add(0.3);
            } else if (detalle.getCantidadPlatos() > 5 && detalle.getCapacidadMesa() == 2) {
                descuento.add(0.15);
            } else {
                descuento.add(0.0);
            }
        });
        return descuento;
    }
}
