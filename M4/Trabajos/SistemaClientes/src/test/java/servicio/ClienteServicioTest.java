package servicio;

import modelo.CategoriaEnum;
import modelo.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ClienteServicioTest {
    private Cliente cliente;
    private ClienteServicio clienteServicio;
    private List<Cliente> listaClientes;

    @BeforeEach
    void setUp() {
        cliente = new Cliente();
        clienteServicio = new ClienteServicio();
        listaClientes = clienteServicio.getListaClientes();
    }

    @Test
    @DisplayName("Prueba para agregar un cliente")
    void agregarClienteTest() {
        String runCliente = "195832732";
        String nombreCliente = "Pablo";
        String apellidoCliente = "Torres";
        int aniosCliente = 3;
        CategoriaEnum nombreCategora = CategoriaEnum.ACTIVO;

        cliente.setRunCliente(runCliente);
        cliente.setNombreCliente(nombreCliente);
        cliente.setApellidoCliente(apellidoCliente);
        cliente.setAniosCliente(aniosCliente);
        cliente.setNombreCategoria(nombreCategora);

        clienteServicio.agregarCliente(cliente);

        assertEquals(1, listaClientes.size());
        Cliente clienteTest = listaClientes.get(0);
        assertEquals(runCliente, clienteTest.getRunCliente());
        assertEquals(nombreCliente, clienteTest.getNombreCliente());
        assertEquals(apellidoCliente, clienteTest.getApellidoCliente());
        assertEquals(aniosCliente, clienteTest.getAniosCliente());
        assertEquals(nombreCategora, clienteTest.getNombreCategoria());
    }

    @Test
    @DisplayName("Prueba para agregar un cliente sin datos")
    void agregarClienteNullTest() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> clienteServicio.agregarCliente(cliente));

        assertEquals("Los datos del cliente no pueden ser nulos", exception.getMessage());
    }
}
