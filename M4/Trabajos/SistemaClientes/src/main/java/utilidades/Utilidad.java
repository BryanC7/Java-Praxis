package utilidades;

public class Utilidad {
    public Utilidad() {}

    public void limpiarPantalla() {
        for(int i = 0; i < 5; i++) {
            System.out.println(" ");
        }
    }

    public void tiempoEspera() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Hilo interrumpido");
        }
    }
}
