package clase18;

import java.io.*;
import java.util.ArrayList;

public class DesafioEvaluado {
    public static void main(String[] args) throws IOException {
        crearArchivo("directorio", "fichero");
        buscarTexto("directorio","fichero", "perro");
    }
    static void crearArchivo(String nombreDirectorio, String fichero) throws IOException {
        File directorio = new File("src/" + nombreDirectorio);

        if (!directorio.exists()) {
            directorio.mkdir();
            System.out.println("Directorio creado satisfactoriamente");
        } else if(directorio.exists()){
            System.out.println("El directorio ya existe");
        } else {
            System.out.println("Error al crear el directorio");
        }

        ArrayList<String> lista = new ArrayList<>();
        lista.add("Perro");
        lista.add("Gato");
        lista.add("Juan");
        lista.add("Daniel");
        lista.add("Juan");
        lista.add("Gato");
        lista.add("Perro");
        lista.add("Camila");
        lista.add("Daniel");
        lista.add("Camila");

        escribirArchivo(nombreDirectorio, fichero, lista);
    }

    static void escribirArchivo(String nombreDirectorio, String fichero, ArrayList<String> lista) throws IOException {
        File archivo = new File("src/" + nombreDirectorio + "/" + fichero + ".txt");
        FileWriter archivoW = new FileWriter(archivo);
        BufferedWriter bufferedWriter = new BufferedWriter(archivoW);

        for (int i = 0; i < lista.size(); i++) {
            String elemento = lista.get(i);

            try {
                bufferedWriter.write(elemento);

                if (i < lista.size() - 1) {
                    bufferedWriter.newLine();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        bufferedWriter.close();
    }

    static void buscarTexto(String nombreDirectorio, String nombreFichero, String texto) throws IOException {
        File archivo = new File("src/" + nombreDirectorio + "/" + nombreFichero + ".txt");

        if(archivo.exists()) {
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);

            String linea;
            String textoBusqueda = texto.toLowerCase();
            int contador = 0;

            while ((linea = br.readLine()) != null) {
                String lineaEncontrada = linea.toLowerCase();

                if(lineaEncontrada.equals(textoBusqueda)) {
                    contador++;
                }
            }
            System.out.println("Cantidad de repeticiones del texto -> " + contador);
        } else {
            System.out.println("El fichero ingresado no existe");
        }
    }
}
