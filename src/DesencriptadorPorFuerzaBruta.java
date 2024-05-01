import java.util.HashSet;
/*
Esta clase se encarga de desencriptar el texto por medio del proceso "Desencriptación por
fuerza bruta", que se refiere a que se prueban todas las posibles claves dentro de cierto
rango predefinido en las variables privadas y finales "claveMinima" y "claveMaxima".
Se utiliza un objetod de la clase "Desencriptador" dentro de un bucle for para probar con
cada clave y verificar si el texto contiene alguna palabra en español, mismas que están
definidas en un HashSet, de tener algunas de estas palabras incluidas en el texto, se detiene
el bucle y se guarda esa clave como la clave desencriptadora.
El método boolean "incluyeAlgunaPalabraEnEspanol" tiene como función devolver verdadero o falso
y se encuentra dentro del bucle for para lograr descifrar la clave.
*/

public class DesencriptadorPorFuerzaBruta {

    private static final int claveMinima = 1;
    private static final int claveMaxima = 26;

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

