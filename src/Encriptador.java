import java.io.IOException;
import java.util.Random;
/*
Esta clase se encarga de realizar la encriptación de un texto proporcionado utilizando una clave
especifica si se desea o generando una clave aleatoria.De igual manera, si la clave no está dentro
del rango establecido, se asigna por defecto una clave aleatoria.
Para la encriptación con clave se utiliza el médoto "encriptarTextoConClave, en donde se llama al
método del objeto "modificadorDeLetras para aplicar la encriptación sobre el texto. Después se
muestra un mensaje de que ha sido exitosa la encriptación haciendo uso del objeto de la clase
"GeneradorDeDialogos".
En cuanto al método "encriptarTextoConClaveAleatoria", se crea un objeto de la clase Random
y se utiliza el método nextInt para generar un número aleatorio entre 0 y la claveMaxima, sumando
la clave mínima para garantizar que la clave no sea 0.
*/

public class Encriptador {

    private static final int claveMinima = 1;
    private static final int claveMaxima = 25;

    ModificadorDeLetras modificadorDeLetras = new ModificadorDeLetras();
    GeneradorDeDialogos dialogos = new GeneradorDeDialogos();

    String encriptarTextoConClave(String textoSinEncriptar, int clave) throws IOException {
        String textoEncriptado;
        if (clave >= claveMinima && clave <= claveMaxima) {
            textoEncriptado = modificadorDeLetras.unionDeLetrasEnPalabras(textoSinEncriptar, clave);
            dialogos.mostrarEncriptadoExitoso(textoEncriptado, clave);
            return textoEncriptado;
        } else {
            System.out.println("La clave tiene que ser mayor que 0 y menor que 26, " +
                    "se generará una clave aleatoria");
            textoEncriptado = encriptarTextoConClaveAleatoria(textoSinEncriptar);
        }
        return textoEncriptado;
    }

    public String encriptarTextoConClaveAleatoria(String textoSinEncriptar) throws IOException {
        Random claveAleatoria = new Random();
        int clave = claveAleatoria.nextInt(claveMaxima) + claveMinima;
        String textoEncriptado = encriptarTextoConClave(textoSinEncriptar, clave);
        return textoEncriptado;
    }
}

