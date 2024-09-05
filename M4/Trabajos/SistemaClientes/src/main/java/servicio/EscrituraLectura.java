package servicio;

import modelo.Cliente;

import java.io.*;
import java.util.List;

public class EscrituraLectura {
    public void crearArchivo(String fileName, String extension) {
        File archivo = new File("src/main/java/datos/" + fileName + extension);
        try {
            if(!archivo.exists()) {
                if(archivo.createNewFile()){
                    System.out.println("Archivo creado exitosamente");
                } else{
                    System.out.println("Error al crear el archivo");
                }
            }
        } catch(IOException e){
            System.out.println("Error al crear el archivo" + e.getMessage());
        }
    }

    public String leerArchivo(String fileName, String extension){
        File archivo = new File("src/main/java/datos/" + fileName + extension);
        StringBuilder contenido = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                contenido.append(linea).append(System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return contenido.toString();
    }

    public void exportar(String fileName, List<Cliente> listaClientes, String extension) {
        crearArchivo(fileName, extension);

        File archivo = new File("src/main/java/datos/" + fileName + extension);

        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(archivo))) {
            if(leerArchivo(fileName, extension) != null) {
                bufferedWriter.write(leerArchivo(fileName, extension));
            }
            for (Cliente cliente : listaClientes) {
                bufferedWriter.write(cliente.toString());
                bufferedWriter.newLine();
            }
            System.out.println("Datos exportados correctamente");
        } catch (IOException e) {
            System.out.println("Error al crear el archivo: " + e.getMessage());
        }
    }
}
