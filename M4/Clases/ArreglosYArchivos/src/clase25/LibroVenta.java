package clase25;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LibroVenta {
    private String nombreVenta;
    private String fechaVenta;
    private Vehiculo vehiculo;
    private Cliente cliente;

    public LibroVenta() { }

    public LibroVenta(String nombreVenta, String fechaVenta, Vehiculo vehiculo, Cliente cliente) {
        this.nombreVenta = nombreVenta;
        this.fechaVenta = fechaVenta;
        this.vehiculo = vehiculo;
        this.cliente = cliente;
    }

    public String getNombreVenta() {
        return nombreVenta;
    }

    public void setNombreVenta(String nombreVenta) {
        this.nombreVenta = nombreVenta;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void guardarVenta(Vehiculo vehiculo, Cliente cliente) {
        File archivo = new File("src/clase25/ficheros/" + getNombreVenta() + ".txt");

        try {
            if(!archivo.exists()) {
                if(archivo.createNewFile()){
                    System.out.println("Archivo creado exitosamente");
                } else{
                    System.out.println("Error al crear el archivo");
                }
            } else{
                System.out.println("El archivo existe");
            }
        } catch(IOException e){
            System.out.println("Error al crear el archivo" + e.getMessage());
        }

        List<String> datos = new ArrayList<>();
        datos.add(vehiculo.getPatente());
        datos.add(String.valueOf(cliente.getEdad()));
        datos.add(getFechaVenta());
        datos.add(getNombreVenta());

        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(archivo))) {
            for (String dato : datos) {
                bufferedWriter.write(dato);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al crear el archivo: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "LibroVenta{" +
                "nombreVenta='" + nombreVenta + '\'' +
                ", fechaVenta='" + fechaVenta + '\'' +
                ", vehiculo=" + vehiculo +
                ", cliente=" + cliente +
                '}';
    }
}
