import java.util.Scanner;

public class PatronesAnidados {
    public static void main(String[] args) {
        mostrarMenu();
    }

    static void mostrarMenu() {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Ingresa un valor");
            int valor = sc.nextInt();

            System.out.printf("Elige un patrón de acuerdo a su número\n");
            System.out.printf("1 -- Patrón Cuadrado\n");
            System.out.printf("2 -- Patrón Letra Z\n");
            System.out.printf("3 -- Patrón Letra X\n");
            System.out.printf("4 -- Patrón Serpiente\n");
            System.out.printf("5 -- Salir\n");
            System.out.printf("Escribe '5' para terminar el programa\n\n");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    patronCuadrado(valor);
                    break;
                case 2:
                    patronLetraZeta(valor);
                    break;
                case 3:
                    patronLetraEquis(valor);
                    break;
                case 4:
                    patronSerpiente(valor);
                    break;
                case 5:
                    System.out.println("Terminando aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }

            if (opcion != 5) {
                System.out.println("Reiniciando aplicación...");
                sc.nextLine();
            } else {
                break;
            }
        } while (true);

        sc.close();
    }

    static void patronCuadrado(int cantidad) {
        System.out.println("Patrón Cuadrado");
        for (int i = 1; i <= cantidad; i++) {
            for (int j = 1; j <= cantidad; j++) {
                if(i == 1 || i == cantidad || j == 1 || j == cantidad) {
                    System.out.printf("* ");
                } else {
                    System.out.printf("  ");
                }
            }
            System.out.println();
        }
    }

    static void patronLetraZeta(int cantidad) {
        System.out.println("Patrón Letra Z");
        for (int i = 1; i <= cantidad; i++) {
            for (int j = 1; j <= cantidad; j++) {
                if (i == 1 || i == cantidad) {
                    System.out.print("* ");
                } else if (i == cantidad - j + 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    static void patronLetraEquis(int cantidad) {
        System.out.println("Patrón Letra X");
        for (int i = 1; i <= cantidad; i++) {
            for (int j = 1; j <= cantidad; j++) {
                if (i == j || i == cantidad - j + 1) {
                    System.out.print("X ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    static void patronSerpiente(int cantidad) {
        System.out.println("Patrón Serpiente");
        for (int i = 1; i <= cantidad; i++) {
            for (int j = 1; j <= cantidad; j++) {
                if ((i == 1 && j != cantidad) || (i == cantidad && j != 1)) {
                    System.out.print("* ");
                } else if(i > 1 && i < cantidad && j > 1 && j < cantidad) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
