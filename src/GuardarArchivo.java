import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GuardarArchivo {
    public String guardarTextoEncriptado(String rutaArchivo, String textoEncriptado) {
        String archivoNuevo = rutaArchivo.replaceAll(".txt", "Encriptado.txt");
        try (BufferedWriter creadorDeArchivos = new BufferedWriter(new FileWriter(archivoNuevo))) {
            creadorDeArchivos.write(textoEncriptado.toString());
            System.out.printf("El archivo se ha guardado con éxito en la siguiente ruta con el nombre:\n%s", archivoNuevo);
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo:\n" + e.getMessage());
        }
        return archivoNuevo;

    }

}
