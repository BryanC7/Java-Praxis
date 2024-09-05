package clase25;

public class MainExcepciones {
    public static void main(String[] args) {
        Vehiculo vehiculo1 = new Vehiculo("Rojo", "DKMB49");
        Cliente cliente1 = new Cliente("Sebastián", 159283741, 41);

        Vehiculo vehiculo2 = new Vehiculo("Azul", "JKQS12");
        Cliente cliente2 = new Cliente("Armando", 135832912, 50);

        LibroVenta venta1 = new LibroVenta("Venta 1", "17052024", vehiculo1, cliente1);
        venta1.guardarVenta(vehiculo1, cliente1);

        LibroVenta venta2 = new LibroVenta("Venta 2", "18052024", vehiculo2, cliente2);
        venta2.guardarVenta(vehiculo2, cliente2);
    }
}
