import java.util.HashSet;
/*
En esta clase se intenta desencriptar un texto encriptado mediante el proceso de fuerza bruta,
probando todas las posibles claves dentro de cierto rango predefinido en las variables finales
"claveMinima" y "claveMaxima". Utiliza un objeto de la clase "Desencriptador" para realizar la
desencriptación con cada clave mediante un bucle for, para luego verificar si el texto contiene
alguna palabra en español, que se encuentran definidas en un HashSet dentro de un método boolean,
de ser cierta esta condición, se devuelve el texto desencriptado junto con la clave encontrada.
De igual manera se hace uso de la clase "GeneradorDeDialogos" para mostrar en pantalla los resultados.
*/

public class DesencriptadorPorFuerzaBruta {

    private static final int claveMinima = 1;
    private static final int claveMaxima = 25;

    GeneradorDeDialogos dialogos = new GeneradorDeDialogos();
    Desencriptador desencriptador = new Desencriptador();

    String desencriptarPorFuerzaBruta(String textoEncriptado) {
        String textoTentativo = "";
        int claveUtilizada;
        for (int clave = claveMinima; clave <= claveMaxima; clave++) {
            textoTentativo = desencriptador.desencriptarConClave(textoEncriptado, clave);
            boolean contienePalabrasEnEspanol = incluyeAlgunaPalabraEnEspanol(textoTentativo);
            if (contienePalabrasEnEspanol) {
                claveUtilizada = clave;
                dialogos.mostrarDesencriptadoExitoso(textoTentativo, claveUtilizada);

                break;
            }
        }
        return textoTentativo;
    }

    boolean incluyeAlgunaPalabraEnEspanol(String texto) {
        HashSet<String> palabrasEnEspanol = new HashSet<>();
        palabrasEnEspanol.add(" el ");
        palabrasEnEspanol.add(" la ");
        palabrasEnEspanol.add(" los ");
        palabrasEnEspanol.add(" las ");
        palabrasEnEspanol.add(" y ");
        palabrasEnEspanol.add(" un ");
        palabrasEnEspanol.add(" una ");
        palabrasEnEspanol.add(" unos ");
        palabrasEnEspanol.add(" unas ");
        palabrasEnEspanol.add(" no ");
        palabrasEnEspanol.add(" aunque ");
        palabrasEnEspanol.add(" aún ");
        palabrasEnEspanol.add(" que ");
        palabrasEnEspanol.add(" con ");
        palabrasEnEspanol.add(" contra ");
        palabrasEnEspanol.add(" al ");
        palabrasEnEspanol.add(" en ");
        palabrasEnEspanol.add(" su ");
        palabrasEnEspanol.add(" sus ");
        palabrasEnEspanol.add(" se ");

        for (String palabra : palabrasEnEspanol) {
            if (texto.toLowerCase().contains(palabra)) {
                return true;
            }
        }
        return false;
    }

}

