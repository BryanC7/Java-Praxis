package clase28;

import java.util.Scanner;

public class Menu {
    private ProductoServicio productoServicio;
    private ArchivoServicio archivoServicio;
    private Utilidad u;
    private Scanner sc;
    public Menu() {
        this.productoServicio = new ProductoServicio();
        this.archivoServicio = new ArchivoServicio();
        this.u = new Utilidad();
        this.sc = new Scanner(System.in);
    }

    public void inicio() {
        String [] datos = new String[0];
        String opcion;

        do {
            System.out.println(" ");
            System.out.println(1 + " Listar Producto");
            System.out.println(2 + " Editar Productos");
            System.out.println(3 + " Importar Datos");
            System.out.println(4 + " Salir");
            System.out.println("Ingrese una opción:");
            opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    productoServicio.listarProductos(datos);
                    break;
                case "2":
                    productoServicio.editarProductos(datos);
                    break;
                case "3":
                    datos = archivoServicio.cargarDatos();
                    break;
                case "4":
                    System.out.println("Abandonando el sistema de clientes...");
                    u.tiempoEspera();
                    System.out.println("Acaba de salir del sistema");
                    sc.close();
                    return;
                default:
                    System.out.println("Opción inválida. Intenta nuevamente");
            }
        } while (true);
    }
}
