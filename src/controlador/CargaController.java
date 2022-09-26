package controlador;

import java.io.File;
import vista.CargaView;
import modelo.*;

public class CargaController {
    public static CargaView ventana = new CargaView();
    
    public static void mostrar(){
        ventana.setVisible(true);
    }
    
    public static void ocultar(){
        ventana.setVisible(false);
    }
    
    public static void eventoBoton1(File archivo){ // Boton "Archivo CSV"
        // Código de carga a través de archivo 
        CargaModel c = new CargaModel();
        c.cargarArchivo(archivo);
        ocultar();
        TipoUsuarioController.mostrar();
    }
    
}
