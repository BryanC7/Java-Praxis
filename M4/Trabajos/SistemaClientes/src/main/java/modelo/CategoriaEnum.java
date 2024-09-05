package modelo;

public enum CategoriaEnum {
    ACTIVO("Activo"),
    INACTIVO("Inactivo");

    private String nombre;

    CategoriaEnum(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
