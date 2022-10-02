package controlador;

import vista.VerContratadosView;

public class VerContratadosController {
    public static VerContratadosView ventana;
    
    public static void mostrar(){
        ventana = new VerContratadosView();
        ventana.setVisible(true);
    }
    
    public static void ocultar(){
        ventana.setVisible(false);
    }
    
    public static void eliminar(){
        ventana.dispose();
    }
}
