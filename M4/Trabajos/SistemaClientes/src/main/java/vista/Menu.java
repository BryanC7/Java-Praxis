package vista;

import modelo.Cliente;
import servicio.ArchivoServicio;
import servicio.ClienteServicio;
import servicio.ExportadorCsv;
import servicio.ExportadorTxt;
import utilidades.Utilidad;

import java.util.List;
import java.util.Scanner;

public class Menu {
    private ClienteServicio clienteServicio;
    private ArchivoServicio archivoServicio;
    private ExportadorCsv exportadorCsv;
    private ExportadorTxt exportadorTxt;
    private Utilidad u;
    private Scanner sc;
    private String fileName = "Clientes";
    private String fileName1 = "DBClientes.csv";
    public Menu() {
        this.clienteServicio = new ClienteServicio();
        this.archivoServicio = new ArchivoServicio();
        this.exportadorCsv = new ExportadorCsv();
        this.exportadorTxt = new ExportadorTxt();
        this.u = new Utilidad();
        this.sc = new Scanner(System.in);
    }

    public void iniciarMenu() {
        String opcion;

        do {
            System.out.println(" ");
            System.out.println(1 + " Listar Clientes");
            System.out.println(2 + " Agregar Cliente");
            System.out.println(3 + " Editar Cliente");
            System.out.println(4 + " Cargar Datos");
            System.out.println(5 + " Exportar Datos");
            System.out.println(6 + " Salir");
            System.out.println("Ingrese una opción:");
            opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    clienteServicio.listarClientes(clienteServicio.getListaClientes());
                    break;
                case "2":
                    clienteServicio.crearCliente();
                    break;
                case "3":
                    clienteServicio.editarCliente(clienteServicio.getListaClientes());
                    break;
                case "4":
                    archivoServicio.cargarDatos(fileName1, clienteServicio.getListaClientes());
                    break;
                case "5":
                    subMenuExportar();
                    break;
                case "6":
                    terminarPrograma();
                    return;
                default:
                    System.out.println("Opción inválida. Intenta nuevamente");
            }
        } while (true);
    }

    public void terminarPrograma() {
        System.out.println("Abandonando el sistema de clientes...");
        u.tiempoEspera();
        System.out.println("Acaba de salir del sistema");
        sc.close();
    }

    public void subMenuExportar() {
        String opcionExportar;
        do {
            System.out.println("Selecciona uno de los 2 formatos para exportar los datos:");
            System.out.println(1 + " Exportar .txt");
            System.out.println(2 + " Exportar .csv");
            opcionExportar = sc.nextLine();

            if(opcionExportar.equals("1")) {
                exportadorTxt.exportar(fileName, clienteServicio.getListaClientes(), ".txt");
            } else if(opcionExportar.equals("2")) {
                exportadorCsv.exportar(fileName, clienteServicio.getListaClientes(), ".csv");
            } else {
                System.out.println("Opción incorrecta. Inténtalo de nuevo");
            }
        } while (!opcionExportar.equals("1") && !opcionExportar.equals("2"));
    }
}
