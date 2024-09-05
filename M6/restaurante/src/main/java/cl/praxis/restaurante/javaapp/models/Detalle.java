package cl.praxis.restaurante.javaapp.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Detalle {
    private int id;
    private int cantidadPlatos;
    private int capacidadMesa;
    private String categoriaPlato;
}
