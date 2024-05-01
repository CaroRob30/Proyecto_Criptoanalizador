/*
Esta clase se encarga de desencriptar un texto utilizando una clave en específico.
Contiene un objeto privado de la clase "ModificadorDeLetras", el cuál se encarga de realizar
la desencriptación mediante su método "unionDeLetrasEnPalabras", pasando como parámetros
el texto encriptado y la clave en negativa. El método "desencriptarConClave" toma
como entrada el texto encriptado, la clave correspondiente y utliliza el método de
"modificadorDeLetras", devolviendo así el texto desencriptado.
*/
public class Desencriptador {

    private ModificadorDeLetras modificadorDeLetras = new ModificadorDeLetras();

    public String desencriptarConClave(String textoEncriptado, int clave) {
        String textoDesencriptado = modificadorDeLetras.unionDeLetrasEnPalabras(textoEncriptado, -clave);

        return textoDesencriptado;
    }

}



