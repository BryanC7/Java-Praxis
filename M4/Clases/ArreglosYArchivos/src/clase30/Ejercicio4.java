package clase30;

import java.util.LinkedList;
import java.util.Queue;

public class Ejercicio4 {
    public static void main(String[] args) {
        Queue<String> juegos = new LinkedList<>();
        juegos.add("Tombo");
        juegos.add("Congelado");
        juegos.add("Quemaditas");
        juegos.add("Cachipún");
        juegos.add("Pillarse");

        System.out.println("La cantidad de juegos es: " + juegos.size());

        for (String juego : juegos) {
            System.out.println(juego);
        }
    }
}
