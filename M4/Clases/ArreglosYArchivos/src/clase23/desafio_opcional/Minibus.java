package clase23.desafio_opcional;

public class Minibus extends Bus {
    private String tipoViaje;

    public Minibus(int cantidadAsientos, String tipoViaje) {
        super(cantidadAsientos);
        this.tipoViaje = tipoViaje;
    }
    public Minibus(String color, String patente, int cantidadAsientos, String tipoViaje) {
        super(color, patente, cantidadAsientos);
        this.tipoViaje = tipoViaje;
    }

    public String getTipoViaje() {
        return tipoViaje;
    }

    public void setTipoViaje(String tipoViaje) {
        this.tipoViaje = tipoViaje;
    }

    public void imprimeBus() {
        System.out.println(this.tipoViaje);
    }

    @Override
    public String toString() {
        return "Minibus{" +
                "tipoViaje='" + tipoViaje + '\'' +
                "} " + super.toString();
    }
}
