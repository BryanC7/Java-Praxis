package servicio;

import modelo.Cliente;

import java.util.ArrayList;
import java.util.List;

public interface Exportador {
    String FileName = "";
    List<Cliente> listaClientes = new ArrayList<>();
}
