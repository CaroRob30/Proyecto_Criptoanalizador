import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/*
La clase "GuardarArchivo" contiene el método "guardarTextoEncriptado" y su función es guardar un
texto encriptado o desencriptado en una ruta especificada por el usuario.
Toma como entrada una ruta destino, el nombre con el cual se desea guardar y el texto encriptado o
desencriptado.
Dentro del método se concatena la ruta de destino con el nombrre del archivo utilizando el separador
de archivos de la calse File. Luego se utiliza un BufferedWritter para escribir el texto encriptado
o desencriptado.
 */

public class GuardarArchivo {
    public String guardarTextoEncriptado(String rutaDestino, String nombreArchivo,
                                         String textoEncriptado) {
        String rutaCompleta = rutaDestino + File.separator + nombreArchivo;

        try (BufferedWriter creadorDeArchivos = new BufferedWriter(new FileWriter(rutaCompleta))) {
            creadorDeArchivos.write(textoEncriptado);
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo:\n" + e.getMessage());
        }
        return rutaCompleta;
    }
}
