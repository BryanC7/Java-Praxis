package clase23;

import java.util.List;

public class Botilleria {
    private List<Cerveza> cervezas;
    private String nombre;

    public Botilleria() { }

    public Botilleria(List<Cerveza> cervezas, String nombre) {
        this.cervezas = cervezas;
        this.nombre = nombre;
    }

    public List<Cerveza> getCervezas() {
        return cervezas;
    }

    public void setCervezas(List<Cerveza> cervezas) {
        this.cervezas = cervezas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Botilleria{" +
                "cervezas=" + cervezas +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
