package clase23.desafio_opcional;

public class Tienda {
    private String nombre;
    private int stock;
    private Cliente cliente;
    private Vendedor vendedor;
    private Vehiculo vehiculo;

    public Tienda() { }

    public Tienda(String nombre, int stock, Cliente cliente, Vendedor vendedor, Vehiculo vehiculo) {
        this.nombre = nombre;
        this.stock = stock;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.vehiculo = vehiculo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String existeStock(int stock) {
        return stock > 0 ? "La cantidad de stock es: " + stock : "No hay stock";
    }

    @Override
    public String toString() {
        return "Tienda{" +
                "nombre='" + nombre + '\'' +
                ", stock=" + stock +
                ", cliente=" + cliente +
                ", vendedor=" + vendedor +
                ", vehiculo=" + vehiculo +
                '}';
    }
}
