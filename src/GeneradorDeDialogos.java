import java.util.Scanner;
/*
Esta clase proporciona métodos para interactuar con el usuario desde la consola y mostrar
mensajes relacionados con el proceso de encriptación y desencriptación del texto.
Los métodos solicitarRutaEncriptar, solicitarClaveEncriptar, solicitarRutaDesencriptar
y solicitarClaveDesencriptar solicitan al usuario que ingrese la ruta del archivo de texto a
encriptar, la clave de encriptación, la ruta del archivo de texto a desencriptar y la clave
de desencriptación, respectivamente. Por otra parte, los métodos solicitarRutaGuardar y
solicitarNombreGuardar solicitan que se ingrese la ruta y el nombre del archivo donde
desea guardar el texto encriptado o desencriptado.
Por útlimo, se agregan los métodos mostrarEncriptadoExitoso y mostrarDesencriptadoExitoso
después de realizar la encriptación y desencriptación.
*/

public class GeneradorDeDialogos {

    private static final Scanner scanner = new Scanner(System.in);

    String solicitarRutaEncriptar() {
        System.out.println("Ingrese la ruta del texto que desea encriptar:");
        String rutaTextoEncriptar = scanner.nextLine();
        return rutaTextoEncriptar;
    }

    int solicitarClaveEncriptar() {
        System.out.println("Ingrese la clave con la cual desea encriptar su texto:");
        int clave = scanner.nextInt();
        scanner.nextLine();
        return clave;
    }

    String solicitarRutaDesencriptar() {
        System.out.println("Ingrese la ruta del texto que desea desencriptar:");
        String rutaDesencriptar = scanner.nextLine();
        return rutaDesencriptar;
    }

    int solicitarClaveDesencriptar() {
        System.out.println("Ingrese la clave para desencriptar el texto:");
        int clave = scanner.nextInt();
        scanner.nextLine();
        return clave;
    }

    String solicitarRutaGuardar() {
        System.out.println("Ingrese la ruta donde desea guardar el texto:");
        String rutaGuardar = scanner.nextLine();
        return rutaGuardar;
    }

    String solicitarNombreGuardar() {
        System.out.println("Ingrese el nombre con el cual desea guardar el texto:");
        String nombreGuardar = scanner.nextLine();
        return nombreGuardar;
    }

    public void mostrarEncriptadoExitoso(String textoEncriptado, int clave) {
        System.out.println("\n¡Encriptado Exitoso!\n");
        System.out.println("El texto encriptado es:\n" + textoEncriptado);
        System.out.println("ADVERTENCIA: ¡No comparta la clave con nadie!" + "\nLa clave es:\n" + clave);
    }

    public void mostrarDesencriptadoExitoso(String textoDesencriptado, int clave) {
        System.out.println("\n¡Se desencriptó con éxito!\n");
        System.out.println("El texto desencriptado es:\n" + textoDesencriptado);
        System.out.println("La clave utilizada fue: " + clave + "\n");
    }
}
