package clase21;

public class Persona {
    private String nombre;
    private int rut;
    private double altura;

    public Persona() {}

    public Persona(String nombre, int rut, double altura) {
        this.nombre = nombre;
        this.rut = rut;
        this.altura = altura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", rut=" + rut +
                ", altura=" + altura +
                '}';
    }
}
