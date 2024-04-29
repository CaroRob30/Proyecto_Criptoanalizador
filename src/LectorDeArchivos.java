import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LectorDeArchivos {

    public String leerArchivo(String rutaArchivo) throws IOException {
        StringBuilder contenido = new StringBuilder();
        try (BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                contenido.append(linea).append("\n");

            }

        }
        String texto = contenido.toString();
        return texto;
    }
}
