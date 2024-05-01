import java.io.IOException;
import java.util.Scanner;
/*
En esta clase se implementa la lógica principal del programa que interactúa con el usuario para
ofrecer diferentes opciones de encriptado y desencriptado de archivos de texto.
Dentro del método main, se crea un bucle do-while para mostrar un menú de opciones al usuario,
leyendo la selección y, dependiendo de la selección elegida, se realizan diferentes opciones
como encriptación con clave, encriptación aleatoria, desencriptación con clave o desencriptación
por fuerza bruta.
Las clases de los objetos creados en el main son "LectorDeArchivos", "Encriptador", Desencriptador",
"DesencriptadorPorFuerzaBruta", "GeneradorDeDialogos", GuardarArchivos". Cada uno de los objetos tiene
como funcion realizar las acciones correspondientes de lectura, encriptación, desencriptación y
guardado de un texto.
Se hace el manejo de excepciones en cada uno de los casos si es que surge algún error en la ejecución
del programa.
Finalemente el bucle termina y con él el programa cuando se selecciona la opcion 5 que es la salida
del programa.
*/

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

                    String rutaParaEncriptar = dialogos.solicitarRutaParaEncriptar();
                    int claveParaEncriptar = dialogos.solicitarClaveParaEncriptar();

                    try {
                        String contenido = lectorDeArchivos.obtenerRutaDeArchivo(rutaParaEncriptar);
                        System.out.println("Encriptando...\n");

                        String rutaGuardarTextoEncriptado = dialogos.solicitarRutaParaGuardar();
                        String nuevoNombreTextoEncriptado = dialogos.solicitarNombreParaGuardar();

                        String textoEncriptado = encriptador.encriptarTextoConClave(contenido, claveParaEncriptar);

                        String rutaCompleta = guardarArchivo.guardarTextoEncriptado
                                (rutaGuardarTextoEncriptado, nuevoNombreTextoEncriptado, textoEncriptado);
                        dialogos.mostrarGuardadoExitoso(rutaCompleta);

                    } catch (IOException e) {
                        System.out.println("Se ha producido un error al encriptar, intente de nuevo" + e.getMessage());
                    }
                    break;

                case 2:
                    //Encriptar un archivo de texto con una clave aleatoria desde una ruta proporcionada.

                    String rutaParaEncriptarAleatoriamente = dialogos.solicitarRutaParaEncriptar();
                    try {
                        String contenido = lectorDeArchivos.obtenerRutaDeArchivo(rutaParaEncriptarAleatoriamente);
                        System.out.println("Encriptando...\n");

                        String rutaGuardarTextoEncriptado = dialogos.solicitarRutaParaGuardar();
                        String nuevoNombreTextoEncriptado = dialogos.solicitarNombreParaGuardar();

                        String textoEncriptado = encriptador.encriptarTextoConClaveAleatoria(contenido);

                        String rutaCompleta = guardarArchivo.guardarTextoEncriptado
                                (rutaGuardarTextoEncriptado, nuevoNombreTextoEncriptado, textoEncriptado);
                        dialogos.mostrarGuardadoExitoso(rutaCompleta);

                    } catch (IOException e) {
                        System.out.println("Se ha producido un error al encriptar, intente de nuevo" + e.getMessage());
                    }
                    break;

                case 3:
                    //Desencriptar un archivo de texto con clave desde una ruta proporcionada.
                    String rutaParaDesencriptar = dialogos.solicitarRutaParaDesencriptar();
                    int claveParaDesencriptar = dialogos.solicitarClaveParaDesencriptar();

                    try {
                        String contenido = lectorDeArchivos.obtenerRutaDeArchivo(rutaParaDesencriptar);
                        System.out.println("Desencriptando...\n");

                        String rutaGuardarTextoDesencriptado = dialogos.solicitarRutaParaGuardar();
                        String nuevoNombreTextoDesencriptado = dialogos.solicitarNombreParaGuardar();
                        String textoDesencriptado = desencriptador.desencriptarConClave(contenido, claveParaDesencriptar);
                        String rutaCompleta = guardarArchivo.guardarTextoEncriptado
                                (rutaGuardarTextoDesencriptado, nuevoNombreTextoDesencriptado, textoDesencriptado);
                        dialogos.mostrarDesencriptadoExitoso(textoDesencriptado, claveParaDesencriptar);
                        dialogos.mostrarGuardadoExitoso(rutaCompleta);


                    } catch (IOException e) {
                        System.out.println("Se ha producido un error al desencriptar, intente nuevamente" + e.getMessage());
                    }
                    break;
                case 4:
                    // Desencriptar un archivo de texto por fuerza bruta.
                    String rutaParaDesencriptarPorFuerzaBruta = dialogos.solicitarRutaParaDesencriptar();

                    try {
                        String contenido = lectorDeArchivos.obtenerRutaDeArchivo(rutaParaDesencriptarPorFuerzaBruta);
                        System.out.println("Desencriptando ...\n");

                        String rutaGuardarTextoDesencriptado = dialogos.solicitarRutaParaGuardar();
                        String nuevoNombreTextoDesencriptado = dialogos.solicitarNombreParaGuardar();
                        String textoDesencriptado = desencriptadorPorFuerzaBruta.desencriptarPorFuerzaBruta(contenido);
                        String rutaCompleta = guardarArchivo.guardarTextoEncriptado
                                (rutaGuardarTextoDesencriptado, nuevoNombreTextoDesencriptado, textoDesencriptado);
                        dialogos.mostrarGuardadoExitoso(rutaCompleta);

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