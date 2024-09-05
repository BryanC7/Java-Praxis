package clase27;

import java.io.*;

public class ExportarTxt extends Exportador {
    private File archivo = new File("src/clase27/registros/productos.txt");
    public ExportarTxt() {}
    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public void crearArchivo() {
        try {
            if(!getArchivo().exists()) {
                if(getArchivo().createNewFile()){
                    System.out.println("Archivo creado exitosamente");
                } else{
                    System.out.println("Error al crear el archivo");
                }
            }
        } catch(IOException e){
            System.out.println("Error al crear el archivo" + e.getMessage());
        }
    }

    public String leerArchivo(){
        String productos = "";

        try(FileReader newReader = new FileReader(getArchivo());
            BufferedReader newBufferedR = new BufferedReader(newReader)){

            while((productos = newBufferedR.readLine())!=null){
                System.out.println(productos);
            }

        } catch (IOException e){
            System.out.println("Error al Leer el archivo" + e.getMessage());
        }

        return productos;
    }

    @Override
    public void exportar(ProductoServicio productoServicio) {
        crearArchivo();

        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(getArchivo()))) {
            if(leerArchivo() != null) {
                bufferedWriter.write(leerArchivo());
            }
            for (Producto producto : productoServicio.getProductos()) {
                bufferedWriter.write(String.valueOf(producto));
                bufferedWriter.newLine();
            }
            System.out.println("Datos exportados correctamente");
        } catch (IOException e) {
            System.out.println("Error al crear el archivo: " + e.getMessage());
        }
    }
}
