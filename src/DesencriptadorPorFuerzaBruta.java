import java.util.HashSet;

public class DesencriptadorPorFuerzaBruta {
    private static final int claveMinima = 1;
    private static final int claveMaxima = 25;
    private Encriptador encriptador;
    private HashSet<String> palabrasEnEspañol;

    public DesencriptadorPorFuerzaBruta() {
        this.encriptador = new Encriptador();
        this.palabrasEnEspañol = new HashSet<>();
        cargarPalabrasEnEspañol();

    }

    private void cargarPalabrasEnEspañol() {
        palabrasEnEspañol.add(" el ");
        palabrasEnEspañol.add(" la ");
        palabrasEnEspañol.add(" los ");
        palabrasEnEspañol.add(" las ");
        palabrasEnEspañol.add(" y ");
        palabrasEnEspañol.add(" un ");
        palabrasEnEspañol.add(" una ");
        palabrasEnEspañol.add(" unos ");
        palabrasEnEspañol.add(" unas ");
        palabrasEnEspañol.add(" no ");
        palabrasEnEspañol.add(" aunque ");
        palabrasEnEspañol.add(" aún ");
        palabrasEnEspañol.add(" que ");

    }

    public String desencriptarPorFuerzaBruta(String textoEncriptado) {
        String textoDesencriptado = "";
        String textoMejorDesencriptado = "";
        int claveUtilizada = 0;

        for (int clave = claveMinima; clave <= claveMaxima; clave++) {
            String textodesencriptado = desencriptarTexto(textoEncriptado, clave);
            if (contienePalabrasEnEspañol(textoDesencriptado)) {
                textoMejorDesencriptado = textoDesencriptado;
                claveUtilizada = clave;
                System.out.println("Texto desencriptado con clave " + clave + ": " + textoDesencriptado);
                break;
            }
        }
        System.out.println("La clave utilizada para encriptar es: " + claveUtilizada);
        return textoMejorDesencriptado;
    }

    private String desencriptarTexto(String textoEncriptado, int clave) {
        StringBuilder textoDesencriptado = new StringBuilder();
        for (int i = 0; i < textoEncriptado.length(); i++) {
            char letraEncriptada = textoDesencriptado.charAt(i);
            char letraDesencriptada = encriptador.encriptarLetra(letraEncriptada, -clave);
            textoDesencriptado.append(letraDesencriptada);

        }
        return textoDesencriptado.toString();
    }

    private boolean contienePalabrasEnEspañol(String texto) {
        String[] palabras = texto.split("\\s+");
        for (String palabra : palabras) {
            if (palabrasEnEspañol.contains(palabra.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}


