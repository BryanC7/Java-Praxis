package clase15;

import java.util.Arrays;

public class DesafioEvaluado {
    public static void main(String[] args) {

        /*
        * Para ejecutar este archivo se debe hacer uso de la terminal, en la cual el directorio debe estar posicionado en el package clase15.
        * Luego de esto, el código a ingresar para la ejecución es "java DesafioEvaluado.java [palabra clave] [numeros separados por un espacio]" (sin las comillas dobles).
        * El código varía dependiendo de que método se quiera utilizar y los valores que uno quiera ingresar, por ejemplo, como se indica en el switch case de la línea 18
        * se evalua el primer parametro que vendría a ser [palabra clave] y luego para crear el arreglo de valores van los [numeros separados por un espacio].
        *
        * Ejemplos a utilizar de acuerdo a la información del desafio:
        *
        * java DesafioEvaluado.java visitas 3001 1402 1304 1505
        * java DesafioEvaluado.java pasos 300 405 403 506 100020040 45006 -1044
        * java DesafioEvaluado.java multiplos 10 20 30 33 21 8 2 61
        */

        if (args.length < 1) {
            System.out.println("Debe proporcionar al menos un parámetro.");
            return;
        }

        String parametro = args[0];

        switch (parametro) {
            // Ejercicio 1 - Visitas
            case "visitas":
                int[] visitasDiarias = construirArreglo(args);
                System.out.println("El promedio de visitas diarias es: " + promedio(visitasDiarias));
                break;
            // Ejercicio 2 - SmartWatch
            case "pasos":
                int[] pasosDiarios = construirArreglo(args);
                System.out.println("El promedio de pasos diarios es: " + clearSteps(pasosDiarios));
                break;
            // Ejercicio 3 - Múltiplos de 3
            case "multiplos":
                int[] multiplosDe3 = construirArreglo(args);
                double[] resultadoMultiplos3 = suma(multiplosDe3);
                System.out.println("La suma de los múltiplos de 3 es: " + resultadoMultiplos3[0]);
            // Ejercicio 4 - Promedio de los múltiplos de 3
                System.out.println("El promedio de los múltiplos de 3 es: " + resultadoMultiplos3[1]);
                break;
            default:
                System.out.println("Parámetro no reconocido. Opciones válidas: visitas, pasos, multiplos");
        }
    }

    public static int[] construirArreglo(String[] args) {
        int[] valores = new int[args.length - 1];
        for (int i = 1; i < args.length; i++) {
            try {
                valores[i - 1] = Integer.parseInt(args[i]);
            } catch (NumberFormatException e) {
                System.out.println("Los argumentos deben ser números enteros.");
                return new int[0];
            }
        }

        return valores;
    }

    static double promedio(int[] visitas) {
        if (visitas.length == 0) {
            return 0;
        }

        int suma = 0;
        for (int visita : visitas) {
            suma += visita;
        }

        return (double) suma / visitas.length;
    }

    static double clearSteps(int[] pasos) {
        if (pasos.length == 0) {
            return 0;
        }

        int suma = 0;
        for (int paso : pasos) {
            if (paso > 200 && paso < 100000) {
                suma += paso;
            }
        }

        return (double) suma / pasos.length;
    }

    static double[] suma(int[] multiplos) {
        if (multiplos.length == 0) {
            return new double[0];
        }

        int suma = 0;
        int contador = 0;

        for (int multiplo : multiplos) {
            if (multiplo % 3 == 0) {
                suma += multiplo;
                contador++;
            }
        }

        return new double[]{suma, (double) suma / contador};
    }
}
