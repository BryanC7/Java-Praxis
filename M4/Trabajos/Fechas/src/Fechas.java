import java.util.Scanner;

public class Fechas {
    public static void main(String[] args) {
        String fecha_1;
        String fecha_2;

        int dia_fecha_1;
        int dia_fecha_2;
        int mes_fecha_1;
        int mes_fecha_2;
        int anio_fecha_1;
        int anio_fecha_2;

        Scanner sc = new Scanner(System.in);

        System.out.println("-----------------------------------");
        System.out.println("Ingresa la fecha 1 como DD/MM/AAAA");
        System.out.println("-----------------------------------");
        fecha_1 = sc.nextLine();
        dia_fecha_1 = Integer.parseInt(fecha_1.substring(0, 2));
        mes_fecha_1 = Integer.parseInt(fecha_1.substring(3, 5));
        anio_fecha_1 = Integer.parseInt(fecha_1.substring(6, 10));

        System.out.println("-----------------------------------");
        System.out.println("Ingresa la fecha 2 como DD/MM/AAAA");
        System.out.println("-----------------------------------");
        fecha_2 = sc.nextLine();
        dia_fecha_2 = Integer.parseInt(fecha_2.substring(0, 2));
        mes_fecha_2 = Integer.parseInt(fecha_2.substring(3, 5));
        anio_fecha_2 = Integer.parseInt(fecha_2.substring(6, 10));

        if(anio_fecha_1 < anio_fecha_2) {
            System.out.println("Persona 1 es mayor");
        } else if (anio_fecha_1 == anio_fecha_2) {
            if(mes_fecha_1 < mes_fecha_2) {
                System.out.println("Persona 1 es mayor");
            } else if (mes_fecha_1 == mes_fecha_2) {
                if(dia_fecha_1 < dia_fecha_2) {
                    System.out.println("Persona 1 es mayor");
                } else if(dia_fecha_1 == dia_fecha_2) {
                    System.out.println("Tienen la misma edad");
                } else {
                    System.out.println("Persona 2 es mayor");
                }
            } else {
                System.out.println("Persona 2 es mayor");
            }
        } else{
            System.out.println("Persona 2 es mayor");
        }
    }
}
