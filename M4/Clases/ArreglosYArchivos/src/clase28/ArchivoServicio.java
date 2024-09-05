package clase28;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArchivoServicio {
    private String datos;

    public ArchivoServicio() {}

    public ArchivoServicio(String datos) {
        this.datos = datos;
    }

    public String getDatos() {
        return datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }

    public String[] cargarDatos() {
        String linea;
        List<String> productos = new ArrayList<>();

        System.out.println("Cargar Datos");
        File archivo = new File("src/clase28/listadoproductos/ProductosImportados.csv");

        try(FileReader newReader = new FileReader(archivo);
            BufferedReader newBufferedR = new BufferedReader(newReader)) {

            while ((linea = newBufferedR.readLine()) != null) {
                productos.add(linea);
            }

            System.out.println(productos);
            System.out.println("Datos cargados correctamente en la lista");

        } catch (IOException e){
            System.out.println("Error al Leer el archivo" + e.getMessage());
        }
        return productos.toArray(new String[0]);
    }

    @Override
    public String toString() {
        return "ArchivoServicio{" +
                "datos='" + datos + '\'' +
                '}';
    }
}
