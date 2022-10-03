package controlador;

import java.io.FileNotFoundException;
import java.io.IOException;

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
