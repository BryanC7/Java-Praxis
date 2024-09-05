package servicio;

import modelo.Cliente;

import java.util.List;

public class ExportadorCsv extends EscrituraLectura implements Exportador {
    @Override
    public void exportar(String fileName, List<Cliente> listaClientes, String extension) {
        super.exportar(fileName, listaClientes, extension);
    }
}
