package clase27;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductoServicio {
    private ArrayList<String> listaProductos = new ArrayList<>();
    private ArrayList<Producto> productos = new ArrayList<>();
    private Utilidad u = new Utilidad();

    public ProductoServicio() {}

    public ProductoServicio(ArrayList<String> listaProductos, ArrayList<Producto> productos) {
        this.listaProductos = listaProductos;
        this.productos = productos;
    }

    public ArrayList<String> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<String> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public void listarProductos() {
        u.limpiarPantalla();
        System.out.println("----- Lista de Productos -----");
        for (String producto : getListaProductos()) {
            System.out.println(producto);
        }
    }

    public void agregarProductos() {
        Scanner sc = new Scanner(System.in);
        Producto producto = new Producto();

        System.out.println("Crear Producto");

        System.out.println("Ingresar nombre artículo: ");
        String nombre = sc.nextLine();
        getListaProductos().add(nombre);
        producto.setArticulo(nombre);

        System.out.println("Ingresa precio: ");
        producto.setPrecio(sc.nextLine());

        System.out.println("Ingresa descripción: ");
        producto.setDescripcion(sc.nextLine());

        System.out.println("Ingresa código: ");
        producto.setCodigo(sc.nextLine());

        System.out.println("Ingresa talla: ");
        producto.setTalla(sc.nextLine());

        System.out.println("Ingresa marca: ");
        producto.setMarca(sc.nextLine());

        System.out.println("Ingresa color: ");
        producto.setColor(sc.nextLine());

        getProductos().add(producto);
        u.limpiarPantalla();
        System.out.println("Producto agregado: " + producto);
    }

    @Override
    public String toString() {
        return "ProductoServicio{" +
                "listaProductos=" + listaProductos +
                ", productos=" + productos +
                '}';
    }
}
