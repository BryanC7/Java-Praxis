package cl.praxis.restaurante.javaapp;

public class Main {
    public static void main(String[] args) {
        Repository repository = new Repository();

        CalculoDescuento descuentoSimple = new CalculoSimple();
        CalculoDescuento descuentoComplejo = new CalculoComplejo();

        System.out.println("Descuentos del Calculo Simple");
        System.out.println(descuentoSimple.calculoDescuento(repository.getDetalles()));
        System.out.println("--------------------");
        System.out.println("Descuentos del Calculo Complejo");
        System.out.println(descuentoComplejo.calculoDescuento(repository.getDetalles()));
    }
}
