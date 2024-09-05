package clase13;

import java.util.Arrays;
import java.util.Scanner;

public class Arreglos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de números a crear:");

        int cantidad = sc.nextInt();
        int resultado = sumar(cantidad);
        System.out.printf("El resultado de la suma de los valores del arreglo es: %d\n", resultado);
    }

    static int sumar(int cantidad) {
        double[] arregloNumeros = new double[cantidad];
        int resultado = 0;

        for (int i = 0; i < cantidad; i++) {
            double numeroAleatorio;
            do {
                numeroAleatorio = Math.round(Math.random() * 5);
            } while (numeroAleatorio == 0.0);

            arregloNumeros[i] = numeroAleatorio;
            resultado += numeroAleatorio;
        }

        System.out.println("El arreglo creado es: " + Arrays.toString(arregloNumeros));
        return resultado;
    }
}
