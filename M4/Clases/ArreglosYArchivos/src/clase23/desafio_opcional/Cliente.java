package clase23.desafio_opcional;

public class Cliente extends Persona {
    public Cliente(String nombre, int rut, int edad) {
        super(nombre, rut, edad);
    }

    @Override
    public String toString() {
        return "Cliente{" + "} " + super.toString();
    }
}
