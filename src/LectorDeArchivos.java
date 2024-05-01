import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LectorDeArchivos {

    private String leerArchivo(File archivo) throws IOException {
        StringBuilder contenido = new StringBuilder();
        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
        }
        String texto = contenido.toString();
        return texto;
    }

    public String obtenerRutaDeArchivo(String rutaArchivo) throws IOException {
        File archivo = new File(rutaArchivo);
        if (!archivo.exists()) {
            throw new IOException("El archivo no existe: \n" + rutaArchivo);
        }
        String texto = leerArchivo(archivo);
        System.out.println("\nEl texto encontrado es:\n" + texto);
        return texto;
    }

}
