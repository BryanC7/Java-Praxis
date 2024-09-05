package servicio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import modelo.CategoriaEnum;
import modelo.Cliente;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ArchivoServicio {
    public void cargarDatos(String fileName, List<Cliente> listaClientes) {

        System.out.println("Cargar Datos");
        File archivo = new File("src/main/java/datos/" + fileName);

        try(FileReader newReader = new FileReader(archivo);
            BufferedReader newBufferedR = new BufferedReader(newReader)) {
            String linea;

            while ((linea = newBufferedR.readLine()) != null) {
                String[] datos = linea.split(",");

                if (datos.length == 5) {
                    String runCliente = datos[0].trim();
                    String nombreCliente = datos[1].trim();
                    String apellidoCliente = datos[2].trim();
                    int aniosCliente = Integer.parseInt(datos[3].trim());
                    CategoriaEnum categoria = CategoriaEnum.valueOf(datos[4].trim().toUpperCase());

                    Cliente cliente = new Cliente(runCliente, nombreCliente, apellidoCliente, aniosCliente, categoria);
                    validarDatosCargados(cliente, listaClientes);
                }
            }

        } catch (IOException e) {
            System.out.println("Error al Leer el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error al convertir número: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error al interpretar estado del cliente: " + e.getMessage());
        }
    }

    public void validarDatosCargados(Cliente cliente, List<Cliente> listaClientes) {
        Optional<Cliente> clienteEncontrado = listaClientes.stream()
                .filter(clienteListado -> clienteListado.getRunCliente().equals(cliente.getRunCliente()))
                .findAny();

        if(clienteEncontrado.isPresent()) {
            System.out.println("El cliente con RUN " + cliente.getRunCliente() + " ya existe en la lista.");
        } else {
            listaClientes.add(cliente);
            System.out.println("Cliente cargado con éxito");
        }
    }
}
