package clase23.desafio_opcional;

public class Persona {
    private String nombre;
    private int rut;
    private int edad;

    public Persona() { }
    public Persona(String nombre, int rut, int edad) {
        this.nombre = nombre;
        this.rut = rut;
        this.edad = edad;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", rut=" + rut +
                ", edad=" + edad +
                '}';
    }
}
