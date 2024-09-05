package clase30;

import java.util.Map;
import java.util.TreeMap;

public class Ejercicio3 {
    public static void main(String[] args) {
        Map<String, Integer> golosinas = new TreeMap<>();
        golosinas.put("Chocman", 100);
        golosinas.put("Trululú", 100);
        golosinas.put("Centella", 100);
        golosinas.put("Kilate", 50);
        golosinas.put("Miti-miti", 30);
        golosinas.put("Traga Traga", 150);
        golosinas.put("Tabletón", 5);

        System.out.println(golosinas);

        System.out.println("---------- Golosinas por menos de 100 pesos ----------");
        for(String golosina : golosinas.keySet()) {
            if(golosinas.get(golosina) < 100) {
                System.out.println(golosina + " antes costaba " + golosinas.get(golosina));
            }
        }
    }
}
