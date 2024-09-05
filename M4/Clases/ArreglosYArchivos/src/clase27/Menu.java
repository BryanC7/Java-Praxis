package clase27;

import java.util.Scanner;

public class Menu {
    private ProductoServicio productoServicio;
    private ExportarTxt exportarTxt;
    private Utilidad u;
    private Scanner sc;
    public Menu() {
        this.productoServicio = new ProductoServicio();
        this.exportarTxt = new ExportarTxt();
        this.u = new Utilidad();
        this.sc = new Scanner(System.in);
    }

    public void inicio() {
        String opcion;

        do {
            System.out.println(" ");
            System.out.println(1 + " Listar Producto");
            System.out.println(2 + " Agregar Producto");
            System.out.println(3 + " Exportar Datos");
            System.out.println(4 + " Salir");
            System.out.println("Ingrese una opción:");
            opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    productoServicio.listarProductos();
                    break;
                case "2":
                    productoServicio.agregarProductos();
                    break;
                case "3":
                    exportarTxt.exportar(productoServicio);
                    break;
                case "4":
                    System.out.println("Finalizando aplicación. Espere por favor...");
                    u.tiempoEspera();
                    sc.close();
                    return;
                default:
                    System.out.println("Opción inválida. Intenta nuevamente");
            }
        } while (true);
    }
}
