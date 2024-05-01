public class ModificadorDeLetras {

    private char modificadorDeLetra(char letraSinEncriptar, int clave) {
        int codigoLetraEncriptada = letraSinEncriptar + clave;
        char letraEncriptada = (char) codigoLetraEncriptada;
        return letraEncriptada;
    }

    String unionDeLetrasEnPalabras(String textoInicial, int clave) {
        StringBuilder creadorDeTextoEncriptado = new StringBuilder();
        for (int i = 0; i < textoInicial.length(); i++) {
            char letraSinEncriptar = textoInicial.charAt(i);
            char letraEncriptada = modificadorDeLetra(letraSinEncriptar, clave);
            creadorDeTextoEncriptado.append(letraEncriptada);
        }
        String textoEncriptado = creadorDeTextoEncriptado.toString();
        return textoEncriptado;
    }
}

