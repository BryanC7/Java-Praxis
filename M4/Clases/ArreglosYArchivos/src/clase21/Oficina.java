package clase21;

import java.util.List;

public class Oficina {
    private int cantidadPuestos;
    private JefeProyecto jefeProyecto;
    private List<Programador> programadores;

    public Oficina() { }
    public Oficina(int cantidadPuestos, JefeProyecto jefeProyecto, List<Programador> programadores) {
        if (puestosDisponibles(programadores, cantidadPuestos)) {
            this.cantidadPuestos = cantidadPuestos;
            this.jefeProyecto = jefeProyecto;
            this.programadores = programadores;
        } else {
            throw new IllegalArgumentException("La cantidad de puestos no puede ser menor a la cantidad de programadores");
        }
    }

    public int getCantidadPuestos() {
        return cantidadPuestos;
    }
    public void setCantidadPuestos(int cantidadPuestos) {
        this.cantidadPuestos = cantidadPuestos;
    }
    public JefeProyecto getJefeProyecto() {
        return jefeProyecto;
    }
    public void setJefeProyecto(JefeProyecto jefeProyecto) {
        this.jefeProyecto = jefeProyecto;
    }
    public List<Programador> getProgramadores() {
        return programadores;
    }
    public void setProgramadores(List<Programador> programadores) {
        this.programadores = programadores;
    }

    public Boolean puestosDisponibles(List<Programador> programadores, int cantidadPuestos) {
        return programadores.size() <= cantidadPuestos;
    }

    @Override
    public String toString() {
        return "Oficina {" +
                "jefeProyecto = " + jefeProyecto +
                ", programadores = " + programadores +
                ", cantidadPuestos = " + cantidadPuestos +
                "} ";
    }
}
