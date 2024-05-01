import java.io.IOException;
import java.util.Random;
/*
La clase Encriptador tiene como función la encriptación de un texto utilizando una clave específica
o una clave aleatoria. Contiene un rango en específico para generar la clave.
Para mayor funcionalidad del programa, si la clave no está dentro del rango establecido, se da
aviso sobre el rango y se genera una clave aleatoria por defecto.
El método "encriptarTextoConClave" llama al método "unionDeLetrasEnPalabras" de la clase
"DespalzadorDeLEtras" para poder realizar la encriptación del texto, de ser exitosa la encriptación
se llama al método "mostrarEncriptadoExitoso" de la clase "GeneradorDeDialogos".
El método "encriptarTextoConClaveAleatoria" utiliza un objeto de la clase "Random" y su método
"nextInt" para generar un número aleatorio entre 0 y la claveMáxima, sumando al final la claveMinima
para garantizar que el número aleatorio sea mayor a 0.
*/

public class Encriptador {

    private static final int claveMinima = 1;
    private static final int claveMaxima = 26;

    DesplazadorDeLetras desplazadorDeLetras = new DesplazadorDeLetras();
    GeneradorDeDialogos dialogos = new GeneradorDeDialogos();

    String encriptarTextoConClave(String textoSinEncriptar, int clave) throws IOException {
        String textoEncriptado;
        if (clave >= claveMinima && clave <= claveMaxima) {
            textoEncriptado = desplazadorDeLetras.unionDeLetrasEnPalabras(textoSinEncriptar, clave);
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

