/*
Esta clase contiene el método "desplazarLetra" que toma una letra y una clave como entrada,
devolviendo una letra encriptada mediante el desplazamiento de su código según el número dado
en la clave.
El método "unionDeLetrasEnPalabras" tiene como función recorrer cada letra de un texto inicial
mediante un bucle for y encriptar (mediante el método "desplazarLetra") cada una de las letras
contenidas utilizando la clave para ir construyendo el texto encriptado mediante un StringBuilder
y poder devolverlo como una cadena.
 */
public class DesplazadorDeLetras {

    private char desplazarLetra(char letraSinEncriptar, int clave) {
        int codigoLetraEncriptada = letraSinEncriptar + clave;
        char letraEncriptada = (char) codigoLetraEncriptada;
        return letraEncriptada;
    }

    String unionDeLetrasEnPalabras(String textoInicial, int clave) {
        StringBuilder creadorDeTextoEncriptado = new StringBuilder();
        for (int i = 0; i < textoInicial.length(); i++) {
            char letraSinEncriptar = textoInicial.charAt(i);
            char letraEncriptada = desplazarLetra(letraSinEncriptar, clave);
            creadorDeTextoEncriptado.append(letraEncriptada);
        }
        String textoEncriptado = creadorDeTextoEncriptado.toString();
        return textoEncriptado;
    }
}

