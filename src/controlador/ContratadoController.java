package controlador;

import vista.ContratadoView;

public class ContratadoController {
    public static ContratadoView ventana;
    
    public static void mostrar(){
        ventana = new ContratadoView();
        ventana.setVisible(true);
    }
    
    public static void ocultar(){
        ventana.setVisible(false);
    }
    
    public static void eliminar(){
        ventana.dispose();
    }
}
