import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GuardarArchivo {
    public String guardarTextoEncriptado(String rutaDestino, String nombreArchivo, String textoEncriptado) {
        String rutaCompleta = rutaDestino + File.separator + nombreArchivo;

        try (BufferedWriter creadorDeArchivos = new BufferedWriter(new FileWriter(rutaCompleta))) {
            creadorDeArchivos.write(textoEncriptado);
            System.out.printf("El archivo se ha guardado con éxito en la siguiente " +
                    "ruta con el nombre:\n%s\n", rutaCompleta);
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo:\n" + e.getMessage());
        }
        return rutaCompleta;
    }
}
