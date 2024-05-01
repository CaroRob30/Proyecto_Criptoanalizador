import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LectorDeArchivos lectorDeArchivos = new LectorDeArchivos();
        Encriptador encriptador = new Encriptador();
        GuardarArchivo guardarArchivo = new GuardarArchivo();
        Desencriptador desencriptador = new Desencriptador();
        GeneradorDeDialogos dialogos = new GeneradorDeDialogos();
        DesencriptadorPorFuerzaBruta desencriptadorPorFuerzaBruta = new DesencriptadorPorFuerzaBruta();


        int opcionMenu;
        do {
            System.out.println("\n¡Bienvenido al Criptoanalizador!\nSelecciona la opción deseada:");
            System.out.println("Menu de opciones:\n");
            System.out.println("1. Encriptar con clave");
            System.out.println("2. Encriptar con clave aleatoria");
            System.out.println("3. Desencriptar con clave");
            System.out.println("4. Desencriptar por fuerza bruta");
            System.out.println("5. Salir");
            System.out.println("\nIngrese la opción deseada:");
            opcionMenu = scanner.nextInt();
            scanner.nextLine();

            switch (opcionMenu) {
                case 1:
                    //Encriptar un archivo de texto con clave desde una ruta proporcionada.

                    String rutaParaEncriptar = dialogos.solicitarRutaEncriptar();
                    int claveParaEncriptar = dialogos.solicitarClaveEncriptar();

                    try {
                        String contenido = lectorDeArchivos.obtenerRutaDeArchivo(rutaParaEncriptar);
                        System.out.println("Encriptando...\n");

                        String rutaGuardarTextoEncriptado = dialogos.solicitarRutaGuardar();
                        String nuevoNombreTextoEncriptado = dialogos.solicitarNombreGuardar();

                        String textoEncriptado = encriptador.encriptarTextoConClave(contenido, claveParaEncriptar);

                        guardarArchivo.guardarTextoEncriptado(rutaGuardarTextoEncriptado,
                                nuevoNombreTextoEncriptado, textoEncriptado);

                    } catch (IOException e) {
                        System.out.println("Se ha producido un error al encriptar, intente de nuevo" + e.getMessage());
                    }
                    break;

                case 2:
                    //Encriptar un archivo de texto con una clave aleatoria desde una ruta proporcionada.

                    String rutaParaEncriptarAleatoriamente = dialogos.solicitarRutaEncriptar();
                    try {
                        String contenido = lectorDeArchivos.obtenerRutaDeArchivo(rutaParaEncriptarAleatoriamente);
                        System.out.println("Encriptando...\n");

                        String rutaGuardarTextoEncriptado = dialogos.solicitarRutaGuardar();
                        String nuevoNombreTextoEncriptado = dialogos.solicitarNombreGuardar();

                        String textoEncriptado = encriptador.encriptarTextoConClaveAleatoria(contenido);

                        guardarArchivo.guardarTextoEncriptado(rutaGuardarTextoEncriptado,
                                nuevoNombreTextoEncriptado, textoEncriptado);

                    } catch (IOException e) {
                        System.out.println("Se ha producido un error al encriptar, intente de nuevo" + e.getMessage());
                    }
                    break;

                case 3:
                    //Desencriptar un archivo de texto con clave desde una ruta proporcionada.
                    String rutaParaDesencriptar = dialogos.solicitarRutaDesencriptar();
                    int claveParaDesencriptar = dialogos.solicitarClaveDesencriptar();

                    try {
                        String contenido = lectorDeArchivos.obtenerRutaDeArchivo(rutaParaDesencriptar);
                        System.out.println("Desencriptando...\n");

                        String rutaGuardarTextoDesencriptado = dialogos.solicitarRutaGuardar();
                        String nuevoNombreTextoDesencriptado = dialogos.solicitarNombreGuardar();
                        String textoDesencriptado = desencriptador.desencriptarConClave(contenido, claveParaDesencriptar);
                        guardarArchivo.guardarTextoEncriptado(rutaGuardarTextoDesencriptado,
                                nuevoNombreTextoDesencriptado, textoDesencriptado);
                        dialogos.mostrarDesencriptadoExitoso(textoDesencriptado,claveParaDesencriptar);

                    } catch (IOException e) {
                        System.out.println("Se ha producido un error al desencriptar, intente nuevamente" + e.getMessage());
                    }
                    break;
                case 4:
                    // Desencriptar un archivo de texto por fuerza bruta.
                    String rutaParaDesencriptarPorFuerzaBruta = dialogos.solicitarRutaDesencriptar();

                    try {
                        String contenido = lectorDeArchivos.obtenerRutaDeArchivo(rutaParaDesencriptarPorFuerzaBruta);
                        System.out.println("Desencriptando ...\n");

                        String rutaGuardarTextoDesencriptado = dialogos.solicitarRutaGuardar();
                        String nuevoNombreTextoDesencriptado = dialogos.solicitarNombreGuardar();
                        String textoDesencriptado = desencriptadorPorFuerzaBruta.desencriptarPorFuerzaBruta(contenido);
                        guardarArchivo.guardarTextoEncriptado(rutaGuardarTextoDesencriptado,
                                nuevoNombreTextoDesencriptado, textoDesencriptado);

                    } catch (IOException e) {
                        System.out.println("Se ha producido un error al desencriptar, intente nuevamente" + e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("¡Gracias por utilizar el Criptoanalizador!");
                    break;
                default:
                    System.out.println("Opción no válida. Favor de seleccionar una opción válida.");
                    break;
            }
        } while (opcionMenu != 5);
    }
}