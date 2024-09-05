package clase23.desafio_opcional;

public class Taxi extends Vehiculo {
    private int valorPasaje;

    public Taxi(int valorPasaje) {
        this.valorPasaje = valorPasaje;
    }
    public Taxi(String color, String patente, int valorPasaje) {
        super(color, patente);
        this.valorPasaje = valorPasaje;
    }

    public int getValorPasaje() {
        return valorPasaje;
    }

    public void setValorPasaje(int valorPasaje) {
        this.valorPasaje = valorPasaje;
    }

    public void pagarPasaje(int monto) {
        if(monto >= this.valorPasaje) {
            int vuelto = monto - this.valorPasaje;
            System.out.println("Pasaje pagado, su vuelto es: " + vuelto);
        } else {
            System.out.println("El monto no alcanza a costear el pasaje. Su valor es: " + this.valorPasaje);
        }
    }

    @Override
    public String toString() {
        return "Taxi{" +
                "valorPasaje=" + valorPasaje +
                "} " + super.toString();
    }
}
