import java.util.Scanner;
/*
GeneradorDeDialogos tiene la función de proporcionar métodos para la interacción con el usuario
desde la consola, mostrando mensajes relacionados con el proceso de encriptación y desencriptación
del texto.
Los métodos "solicitarRutaParaEncriptar", "solicitarClaveParaEncriptar", "solicitarRutaParaDesencriptar"
y "solicitarClaveParaDesencriptar", solicitan al usuario que ingrese desde la consola la ruta del
archivo a encriptar, la clave de encriptación, la ruta del archivo a desencriptar y la clave de
desencriptación, respectivamente.
Los métodos "solicitarRutaParaGuardar" y "solicitarNombreParaGuardar", solicitan que se ingrese la ruta
en la cuál se desea crear el archivo encriptado o desencriptado, así como su nuevo nombre.
Los métodos "mostrarEncriptadoExitoso", "mostrarDesencriptadoExitoso" y "mostrarGuardadoExitoso" son
creados para darle dinamismo al programa y avisarle al usuario que su texto ya ha sido creado y puede
ir a la carpeta a verificar.
*/

public class GeneradorDeDialogos {

    private static final Scanner scanner = new Scanner(System.in);

    String solicitarRutaParaEncriptar() {
        System.out.println("Ingrese la ruta del texto que desea encriptar:");
        String rutaTextoEncriptar = scanner.nextLine();
        return rutaTextoEncriptar;
    }

    int solicitarClaveParaEncriptar() {
        System.out.println("Ingrese la clave del 1 al 26 con la cual desea encriptar su texto:");
        int clave = scanner.nextInt();
        scanner.nextLine();
        return clave;
    }

    String solicitarRutaParaDesencriptar() {
        System.out.println("Ingrese la ruta del texto que desea desencriptar:");
        String rutaDesencriptar = scanner.nextLine();
        return rutaDesencriptar;
    }

    int solicitarClaveParaDesencriptar() {
        System.out.println("Ingrese la clave para desencriptar el texto:");
        int clave = scanner.nextInt();
        scanner.nextLine();
        return clave;
    }

    String solicitarRutaParaGuardar() {
        System.out.println("Ingrese la ruta donde desea guardar el texto:");
        String rutaGuardar = scanner.nextLine();
        return rutaGuardar;
    }

    String solicitarNombreParaGuardar() {
        System.out.println("Ingrese el nombre con el cual desea guardar el texto " +
                "no olvides agregar la terminación \".txt\" en el nombre:");
        String nombreGuardar = scanner.nextLine();
        return nombreGuardar;
    }

    public void mostrarEncriptadoExitoso(String textoEncriptado, int clave) {
        System.out.println("\n¡Encriptado Exitoso!\n");
        System.out.println("El texto encriptado es:\n" + textoEncriptado);
        System.out.println("ADVERTENCIA: ¡No comparta la clave con nadie!"
                + "\nLa clave es:\n" + clave);
    }

    public void mostrarDesencriptadoExitoso(String textoDesencriptado, int clave) {
        System.out.println("\n¡Se desencriptó con éxito!\n");
        System.out.println("El texto desencriptado es:\n" + textoDesencriptado);
        System.out.println("La clave utilizada fue: " + clave + "\n");
    }

    public void mostrarGuardadoExitoso(String rutaCompleta) {
        System.out.println("El archivo se ha guardado con éxito en la siguiente " +
                "ruta con el nombre\n" + rutaCompleta);
        System.out.println();
    }
}
