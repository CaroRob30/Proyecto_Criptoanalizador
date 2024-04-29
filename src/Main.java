import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la ruta de archivo que desea leer:");
        String rutaArchivo = scanner.nextLine();

        LectorDeArchivos lectorDeArchivos = new LectorDeArchivos();
        Encriptador encriptador = new Encriptador();
        GuardarArchivo guardarArchivo = new GuardarArchivo();
        try {
            String contenido = lectorDeArchivos.leerArchivo(rutaArchivo);
            System.out.println("El contenido del archivo es:\n" + contenido);
            System.out.println("Encriptando...\n");

            String textoEncriptado = encriptador.encriptarArchivo(contenido);
            System.out.println("El texto encriptado es :\n" + textoEncriptado);

            guardarArchivo.guardarTextoEncriptado(rutaArchivo, textoEncriptado);

        } catch (IOException e) {
            System.out.println("Error al leer o encriptar el archivo:\n" + e.getMessage());
        }

    }
}
