package clase30;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio1 {
    public static void main(String[] args) {
        List<String> marcas = new ArrayList<>();
        marcas.add("Coca-Cola");
        marcas.add("Nike");
        marcas.add("Apple");
        marcas.add("Microsoft");
        marcas.add("Toyota");
        marcas.add("McDonald's");
        marcas.add("Samsung");
        marcas.add("Adidas");
        marcas.add("Pepsi");
        marcas.add("Sony");
        System.out.println("---------- Primeras 10 marcas ----------");
        System.out.println(marcas);

        marcas.add("Blokbaster");
        marcas.add("Carrefour");
        marcas.add("Jetix");
        System.out.println("---------- Marcas Extras ----------");
        System.out.println(marcas);

        marcas.set(marcas.indexOf("Blokbaster"), "Blockbuster");
        marcas.remove("Carrefour");
        System.out.println("---------- Marcas Corregidas ----------");
        System.out.println(marcas);

        List<String> posiblesMarcas = new ArrayList<>();
        posiblesMarcas.add("Ford");
        posiblesMarcas.add("Honda");
        posiblesMarcas.add("Disney");
        posiblesMarcas.add("Intel");
        posiblesMarcas.add("Nestlé");
        marcas.addAll(posiblesMarcas);
        System.out.println("---------- Listado final de marcas ----------");
        System.out.println(marcas);

        System.out.println("Elementos que contiene el listado marcas: " + marcas.size());
    }
}
