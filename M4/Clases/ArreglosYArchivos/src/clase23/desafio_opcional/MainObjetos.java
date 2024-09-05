package clase23.desafio_opcional;

public class MainObjetos {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Felipe", 172345861, 34);
        Vendedor vendedor = new Vendedor("Armando", 152834921, 40,"Calle falsa #123");
        Vehiculo vehiculo = new Vehiculo("Rojo", "SKDL23");
        Tienda tienda = new Tienda("Automotora Praxis", 10, cliente, vendedor, vehiculo);

        System.out.println(tienda);
        System.out.println(tienda.existeStock(tienda.getStock()));

        Taxi taxi1 = new Taxi("Negro", "LTGW45", 5000);
        taxi1.pagarPasaje(6000);

        Taxi taxi2 = new Taxi("Azul", "YJNK83", 5500);
        taxi2.pagarPasaje(5000);

        Bus bus = new Bus("Amarillo", "BNGM12", 50);
        System.out.println(bus.asientosDisponibles());

        Minibus minibus = new Minibus("Azul", "BCZQ73", 30, "Local");
        minibus.imprimeBus();
    }
}
