package controlador;

import vista.EliminarView;

public class EliminarController {
    
    public static EliminarView ventana;
    
    public static void mostrar(){
        ventana = new EliminarView();
        ventana.setVisible(true);
    }
    
    public static void ocultar(){
        ventana.setVisible(false);
    }
    
    public static void eliminar(){
        ventana.dispose();
    }
}
