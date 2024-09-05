package clase28;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ProductoServicio {
    private ArrayList<String> listaProductos = new ArrayList<>();
    private ArchivoServicio archivoServicio;

    public ProductoServicio() {
        this.archivoServicio = new ArchivoServicio();
    }

    public ProductoServicio(ArrayList<String> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public ArrayList<String> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<String> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public void listarProductos(String [] productos) {
        if (productos.length == 0) {
            System.out.println("No hay productos para listar.");
            return;
        }

        System.out.println("----- Lista de Productos -----");
        for (String linea : productos) {
            String[] columnas = linea.split(",");
            if (columnas.length >= 7) {
                System.out.println("Datos del Producto:");
                System.out.println("Nombre artículo: " + columnas[0]);
                System.out.println("Precio: " + columnas[1]);
                System.out.println("Descripción: " + columnas[2]);
                System.out.println("Código: " + columnas[3]);
                System.out.println("Talla: " + columnas[4]);
                System.out.println("Marca: " + columnas[5]);
                System.out.println("Color: " + columnas[6]);
                System.out.println("-----------------------------------");
            } else {
                System.out.println("Línea de datos inválida: " + linea);
            }
        }
    }

    public void editarProductos(String [] productos) {
        if (productos.length == 0) {
            System.out.println("No hay productos para editar.");
            return;
        }

        Scanner sc = new Scanner(System.in);
        Utilidad u = new Utilidad();

        listarProductos(productos);

        System.out.println("Ingrese el código del producto que desea editar:");
        String codigo = sc.nextLine();

        int indice = -1;
        for (int i = 0; i < productos.length; i++) {
            String[] columnas = productos[i].split(",");
            if (columnas.length >= 7 && columnas[3].equals(codigo)) {
                indice = i;
                break;
            }
        }

        if (indice == -1) {
            System.out.println("Código de producto no encontrado. Retornando al menú...");
            u.tiempoEspera();
            return;
        }

        String[] columnas = productos[indice].split(",");
        if (columnas.length < 7) {
            System.out.println("Línea de datos inválida: " + productos[indice]);
            return;
        }

        System.out.println("Seleccione el campo que desea editar:");
        System.out.println("1. Nombre artículo");
        System.out.println("2. Precio");
        System.out.println("3. Descripción");
        System.out.println("4. Código");
        System.out.println("5. Talla");
        System.out.println("6. Marca");
        System.out.println("7. Color");
        int campo = Integer.parseInt(sc.nextLine());

        if (campo < 1 || campo > 7) {
            System.out.println("Campo inválido.");
            return;
        }

        System.out.println("Ingrese el nuevo valor:");
        String nuevoValor = sc.nextLine();

        columnas[campo - 1] = nuevoValor;
        productos[indice] = String.join(",", columnas);
        u.limpiarPantalla();

        System.out.println("Producto actualizado.");
        u.tiempoEspera();
        listarProductos(productos);
    }

    @Override
    public String toString() {
        return "ProductoServicio{" +
                "listaProductos=" + listaProductos +
                '}';
    }
}
