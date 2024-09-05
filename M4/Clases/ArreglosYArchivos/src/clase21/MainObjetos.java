package clase21;

import java.util.ArrayList;
import java.util.List;

public class MainObjetos {
    public static void main(String[] args) {
        Programador programador1 = new Programador("Javier", 183642841, 1.78, "Java");
        Programador programador2 = new Programador("Manuel", 135642381, 1.85, "PHP");
        Programador programador3 = new Programador("Roberto", 169065872, 1.74, "C#");

        List<Programador> programadores = new ArrayList<>();
        programadores.add(programador1);
        programadores.add(programador2);
        programadores.add(programador3);

        JefeProyecto jefeProyecto = new JefeProyecto("Carlos", 142930573, 1.82, "Desarrollo");

        Oficina oficina1 = new Oficina(5, jefeProyecto, programadores);

        System.out.println("Jefe de proyecto: " + jefeProyecto);
        System.out.println("Programadores: " + programadores);
        System.out.println(oficina1);
    }
}
