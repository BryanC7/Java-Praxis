import java.util.Scanner;

public class Patrones {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Patrón 1
        System.out.println("Ingrese un número para realizar el patrón 1");
        int numero1 = sc.nextInt();

        for (int i = 1; i <= numero1; i++) {
            if (i % 2 == 1) {
                System.out.printf("*");
            } else {
                System.out.printf(".");
            }
        }

        System.out.println();

        // Patrón 2
        System.out.println("Ingrese un número para realizar el patrón 2");
        int numero2 = sc.nextInt();

        for (int i = 0; i < numero2; i++) {
            for (int j = 1; j <= 4; j++) {
                System.out.print(j);
            }
        }

        System.out.println();

        // Patrón 3
        System.out.println("Ingrese un número para realizar el patrón 3");
        int numero3 = sc.nextInt();

        for (int i = 1; i <= numero3; i++) {
            if (i % 3 == 0) {
                System.out.printf("*");
            } else {
                System.out.printf("|");
            }
        }
    }
}
