package clase15;

import java.util.*;

public class Ejercicios {
    public static void main(String[] args) {
        int[] sueldos = { 400000, 760000, 1100000, 650000, 654980, 987300, 700450, 442300 };
        System.out.println("El promedio de los sueldos mayores a 500000 es: " + calcularPromedio(sueldos));

        // agregarElemento();

        // notaMaxMin();

        // compararNombre("Andrea");
    }

    static double calcularPromedio(int[] sueldos) {
        double sumaSueldos = 0;
        int contador = 0;

        for (int i = 1; i < sueldos.length; i++) {
            if(sueldos[i] > 500000) {
                sumaSueldos += sueldos[i];
                contador++;
            }
        }
        return Math.round(sumaSueldos / contador);
    }

    static void agregarElemento() {
        ArrayList<String> elementos = new ArrayList<String>();
        elementos.add("Mesa");
        elementos.add("Refrigerador");
        elementos.add("Cocina");
        elementos.add("Lavadora");

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Ingrese un elemento que esté en una casa");
            String elemento = sc.nextLine();

            if (!elementos.contains(elemento)) {
                elementos.add(elemento);
                System.out.println("Elemento agregado: " + elemento);
                System.out.println(elementos);
            } else {
                System.out.println("Elemento ya existente");
                continue;
            }

            System.out.println("¿Desea agregar otro elemento?");
            System.out.println("Presione 1 --- Si");
            System.out.println("Presione 2 --- No");
            int respuesta = sc.nextInt();
            sc.nextLine();

            if (respuesta == 2) {
                System.out.println("Saliendo del programa...");
                break;
            }
        }
    }

    static void notaMaxMin() {
        ArrayList<Double> notas = new ArrayList<>();
        notas.add(4.7);
        notas.add(2.2);
        notas.add(5.4);
        notas.add(6.9);
        notas.add(4.4);
        notas.add(2.6);
        System.out.println("La nota más baja del arreglo es: " + Collections.min(notas));
        System.out.println("La nota más alta del arreglo es: " + Collections.max(notas));
    }

    static void compararNombre(String nombre) {
        ArrayList<String> nombres = new ArrayList<>();
        nombres.add("Nicolás");
        nombres.add("Francisco");
        nombres.add("Andrea");

        boolean nombreEncontrado = false;

        for (Iterator<String> iterador = nombres.iterator(); iterador.hasNext();) {
            String nombreActual = iterador.next();

            if (nombreActual.equals(nombre)) {
                System.out.printf("El nombre %s ya existe.%n", nombre);
                nombreEncontrado = true;
                break;
            }
        }

        if (!nombreEncontrado) {
            System.out.printf("Nombre %s no encontrado.%n", nombre);

            for (Iterator i = nombres.iterator(); i.hasNext();) {
                String nombreNoEncontradoActual = (String) i.next();

                if (!nombreNoEncontradoActual.equals(nombre)) {
                    System.out.printf("Nombre %s encontrado, no es igual al ingresado. \n", nombreNoEncontradoActual);
                    i.remove();
                }
            }
        }

        System.out.println("Lista actualizada de nombres: " + nombres);
    }
}
