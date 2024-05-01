import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
/*
Esta clase tiene la función de leer archivos de texto mediante dos metodos.
El método privado "leerArchivo" toma un objeto de la case File como entrada y lee el contenido del
mismo línea por línea mediante un BufferedReader. Se utiliza un StringBuilder para que, mediante
un bucle while, se vaya agregando cada línea y se devuelva una cadena de texto.
El método público "obtenerRutaDeArchivo" toma una ruta de archivo, usa un objeto File y llama al
método "leerArchivo" para realizar la lectura de su contenido y devolver la cadena de texto.
 */

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
