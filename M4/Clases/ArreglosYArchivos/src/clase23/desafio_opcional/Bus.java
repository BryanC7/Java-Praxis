package clase23.desafio_opcional;

public class Bus extends Vehiculo {
    private Integer cantidadAsientos;

    public Bus(int cantidadAsientos) {
        this.cantidadAsientos = cantidadAsientos;
    }
    public Bus(String color, String patente, int cantidadAsientos) {
        super(color, patente);
        this.cantidadAsientos = cantidadAsientos;
    }

    public int getCantidadAsientos() {
        return cantidadAsientos;
    }

    public void setCantidadAsientos(int cantidadAsientos) {
        this.cantidadAsientos = cantidadAsientos;
    }

    public Integer asientosDisponibles() {
        return cantidadAsientos;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "cantidadAsientos=" + cantidadAsientos +
                "} " + super.toString();
    }
}
