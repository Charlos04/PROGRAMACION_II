import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class ArchivoTexto {
    private String nombreDeArchivo = "logs.txt";
    
    public void crear(){
        File file = new File(nombreDeArchivo);
        try {
            file.createNewFile();
          } catch (Exception e) {
            System.out.println("Error al crear el archivo " + e.getMessage());
          }
        }

    public void escribir(String contenido, boolean concatener){
        File file = new File(nombreDeArchivo);
        if (!file.exists()) {
          System.out.println("Archivo no encontrado");
          return;
        }
        try {
            FileWriter writer = new FileWriter(file, concatener);
            writer.write(contenido + "\n");
            writer.close();
          } catch (Exception e) {
            System.out.println("Error en la escritura de " + e.getMessage());
          }
    }

    public void leer() {
        File file = new File(nombreDeArchivo);
        if (!file.exists()) {
          System.out.println("Archivo inexistente");
          return;
        } else {

          try {
            FileReader reader = new FileReader(file);
            int c;
            while ((c = reader.read()) != -1) {
              System.out.print((char) c);
            }
            reader.close();
          } catch (Exception e) {
            System.out.println("Error al leer el archivo " + e.getMessage());
          }
        }
    }
      public void borrarContenido() {
        File file = new File(nombreDeArchivo);
        if (!file.exists()) {
          System.out.println("Archivo inexistente");
          return;
        }
        try {
          FileWriter writer = new FileWriter(file);
          writer.write("");
          writer.close();
        } catch (Exception e) {
          System.out.println("Error al borrar contenido de archivo: " + e.getMessage());
        }
    }
}
