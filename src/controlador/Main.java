package controlador;

import java.io.FileNotFoundException;

/**
 *
 * @author milat
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException{
        Aplicacion a = Aplicacion.getInstancia();
        a.inicio();
    }
}
