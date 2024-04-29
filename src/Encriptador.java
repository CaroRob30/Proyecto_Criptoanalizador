import java.io.IOException;
import java.util.Random;

public class Encriptador {
    private static final int claveMinima = 1;
    private static final int claveMaxima = 25;


    public char encriptarLetra(char letraSinEncriptar, int clave) {
        if (Character.isLetter(letraSinEncriptar) || Character.isWhitespace(letraSinEncriptar)) {
            char codigoLetraMayus = Character.isUpperCase(letraSinEncriptar) ? 'A' : 'a';
            return (char) ((letraSinEncriptar - codigoLetraMayus + clave) % 26 + codigoLetraMayus);
        } else {
            return letraSinEncriptar;
        }
    }

    public String encriptarArchivo(String textoSinEncriptar) throws IOException {
        Random claveAleatoria = new Random();
        int clave = claveAleatoria.nextInt(claveMaxima - claveMinima + 1) + claveMinima;

        StringBuilder creadorDeTextoEncriptado = new StringBuilder();
        for (int i = 0; i < textoSinEncriptar.length(); i++) {
            char letraSinEncriptar = textoSinEncriptar.charAt(i);
            char letraEncriptada = encriptarLetra(letraSinEncriptar, clave);
            creadorDeTextoEncriptado.append(letraEncriptada);
        }
        System.out.println("Texto encriptado con éxito");
        System.out.println("La clave es: " + clave + "\n");
        String textoEncriptado = creadorDeTextoEncriptado.toString();

        return textoEncriptado;

    }
}

