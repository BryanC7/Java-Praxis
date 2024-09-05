package clase16;

import java.util.Arrays;
import java.util.List;

public class Ejemplos {
    public static void main(String[] args) {
        List<String> palabras = Arrays.asList("Java", "es", "genial");

        long cantidad = palabras.stream()
                .filter(palabra -> palabra.length() > 2)
                .filter(palabra -> palabra.startsWith("g"))
                .map(String::toUpperCase)
                .count();

        System.out.println("Cantidad de palabras procesadas: " + cantidad);
    }
}
