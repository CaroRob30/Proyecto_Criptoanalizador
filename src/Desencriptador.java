/*
Esta clase es la encargada de desencriptar un texto utilizando una clave espeífica.
Contiene un objeto privado de la clase "DesplazadorDeLetras" que se encarga de
realizar la desencriptación mediante el método "unionDeLetrasEnPalabras", pasando
cpmo parámetros el texto encriptado y la clave.
El método "desencriptarConClave" usa como entrada el texto encriptado y la clave pero
en negativo por medio del método "unionDeLetrasEnPalabras", devolviendo de esta manera
el texto desencriptado.
*/
public class Desencriptador {

    private DesplazadorDeLetras desplazadorDeLetras = new DesplazadorDeLetras();

    public String desencriptarConClave(String textoEncriptado, int clave) {
        String textoDesencriptado = desplazadorDeLetras.unionDeLetrasEnPalabras(textoEncriptado, -clave);

        return textoDesencriptado;
    }

}



