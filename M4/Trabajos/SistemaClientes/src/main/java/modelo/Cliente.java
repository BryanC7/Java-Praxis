package modelo;

import lombok.*;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cliente {
    private String runCliente;
    private String nombreCliente;
    private String apellidoCliente;
    private int aniosCliente;
    private CategoriaEnum nombreCategoria;

    @Override
    public String toString() {
        return runCliente + ", " + nombreCliente + ", " + apellidoCliente + ", " + Integer.toString(aniosCliente) + ", " + nombreCategoria.getNombre();
    }
}
