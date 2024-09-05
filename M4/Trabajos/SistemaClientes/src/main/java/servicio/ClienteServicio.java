package servicio;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import modelo.CategoriaEnum;
import modelo.Cliente;
import utilidades.Utilidad;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
@Setter
public class ClienteServicio {
    private List<Cliente> listaClientes = new ArrayList<>();
    private Utilidad u = new Utilidad();

    public ClienteServicio(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public void listarClientes(List<Cliente> clientes) {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes para listar.");
            return;
        }

        for (Cliente cliente : clientes) {
            System.out.println("---------- Datos del Cliente ----------");
            System.out.println(" ");
            System.out.println("RUN del Cliente: " + cliente.getRunCliente());
            System.out.println("Nombre del Cliente: " + cliente.getNombreCliente());
            System.out.println("Apellido del Cliente: " + cliente.getApellidoCliente());
            System.out.println("Años del Cliente: " + cliente.getAniosCliente());
            System.out.println("Categoría del Cliente: " + cliente.getNombreCategoria());
            System.out.println("---------------------------------------");
            System.out.println(" ");
        }
    }

    public void crearCliente() {
        Cliente cliente = new Cliente();
        Scanner sc = new Scanner(System.in);
        System.out.println("---------- Crear Cliente ----------");
        System.out.println(" ");

        System.out.println("Ingresa RUN del Cliente: ");
        cliente.setRunCliente(sc.nextLine());

        System.out.println("Ingresa Nombre del Cliente: ");
        cliente.setNombreCliente(sc.nextLine());

        System.out.println("Ingresa Apellido del Cliente: ");
        cliente.setApellidoCliente(sc.nextLine());

        System.out.println("Ingresa Años del Cliente: ");
        cliente.setAniosCliente(sc.nextInt());

        cliente.setNombreCategoria(CategoriaEnum.ACTIVO);

        agregarCliente(cliente);
        System.out.println("Cliente agregado correctamente");
        u.tiempoEspera();
        u.limpiarPantalla();

        System.out.println(" ");
        System.out.println("---------------------------------------");

    }

    public void agregarCliente(Cliente cliente) {
        if(cliente.getRunCliente() == null || cliente.getNombreCliente() == null || cliente.getApellidoCliente() == null || cliente.getAniosCliente() == 0 || cliente.getNombreCategoria() == null) {
            throw new IllegalArgumentException("Los datos del cliente no pueden ser nulos");
        } else {
            getListaClientes().add(cliente);
        }
    }

    public void editarCliente(List<Cliente> clientes) {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes para editar.");
            return;
        }

        Scanner sc = new Scanner(System.in);
        String opcion;
        String actualizarOpcion;

        listarClientes(clientes);

        System.out.println("Seleccione el rut de un Cliente");
        String run = sc.nextLine();

        List<Cliente> clienteEncontrado = clientes.stream()
                .filter(cliente -> cliente.getRunCliente().equals(run))
                .collect(Collectors.toList());

        if (clienteEncontrado.isEmpty()) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        Cliente cliente = clienteEncontrado.get(0);

        do {
            System.out.println("---------- Editar Cliente ----------");
            System.out.println("Seleccione qué desea hacer:");
            System.out.println(1 + " Cambiar el estado del Cliente");
            System.out.println(2 + " Editar los datos ingresados del Cliente");
            System.out.println(" ");
            System.out.println("Ingrese opción:");
            opcion = sc.nextLine();

            if(opcion.equals("1")) {
                System.out.println("---------- Actualizando Estado del Cliente ----------");
                System.out.println("Seleccione el nuevo estado:");
                System.out.println(1 + " ACTIVO");
                System.out.println(2 + " INACTIVO");
                String estadoOpcion = sc.nextLine();

                if (estadoOpcion.equals("1")) {
                    cliente.setNombreCategoria(CategoriaEnum.ACTIVO);
                } else if (estadoOpcion.equals("2")) {
                    cliente.setNombreCategoria(CategoriaEnum.INACTIVO);
                } else {
                    System.out.println("Opción incorrecta. Inténtalo de nuevo.");
                }

                System.out.println("---------------------------------------");
                System.out.println("Estado cambiado con éxito");
            } else if(opcion.equals("2")) {
                System.out.println("---------- Actualizando Datos del Cliente ----------");
                for (Cliente actualizarCliente : clienteEncontrado) {
                    System.out.println(1 + " El RUN del Cliente es: " + actualizarCliente.getRunCliente());
                    System.out.println(2 + " El Nombre del Cliente es: " + actualizarCliente.getNombreCliente());
                    System.out.println(3 + " El Apellido del Cliente es: " + actualizarCliente.getApellidoCliente());
                    System.out.println(4 + " Los Años como Cliente son: " + actualizarCliente.getAniosCliente());
                }
                System.out.println("Ingrese una opción para actualizar el dato respectivo del cliente");
                actualizarOpcion = sc.nextLine();

                System.out.println("---------------------------------------");
                switch (actualizarOpcion) {
                    case "1":
                        System.out.println("Ingrese el nuevo RUN del Cliente:");
                        cliente.setRunCliente(sc.nextLine());
                        break;
                    case "2":
                        System.out.println("Ingrese el nuevo Nombre:");
                        cliente.setNombreCliente(sc.nextLine());
                        break;
                    case "3":
                        System.out.println("Ingrese el nuevo Apellido:");
                        cliente.setApellidoCliente(sc.nextLine());
                        break;
                    case "4":
                        System.out.println("Ingrese los nuevos Años como Cliente:");
                        cliente.setAniosCliente(Integer.parseInt(sc.nextLine()));
                        break;
                    default:
                        System.out.println("Opción incorrecta. Inténtalo de nuevo.");
                }

                System.out.println("---------------------------------------");
                System.out.println("Datos cambiados con éxito");
            } else {
                System.out.println("Opción incorrecta. Inténtalo de nuevo");
            }
        } while (!opcion.equals("1") && !opcion.equals("2"));
    }
}
