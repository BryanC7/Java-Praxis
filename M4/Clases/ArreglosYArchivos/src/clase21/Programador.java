package clase21;

public class Programador extends Persona{
    private String lenguaje;

    public Programador() {}

    public Programador(String nombre, int rut, double altura, String lenguaje) {
        super(nombre, rut, altura);
        this.lenguaje = lenguaje;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }

    @Override
    public String toString() {
        return super.toString() + " Programador{" +
                "lenguaje = " + lenguaje + '\'' +
                "} ";
    }
}
