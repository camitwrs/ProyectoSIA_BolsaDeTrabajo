package controlador;

import vista.PostularView;

public class PostularController {
    public static PostularView ventana;
    
    public static void mostrar(){
        ventana = new PostularView();
        ventana.setVisible(true);
    }
    
    public static void ocultar(){
        ventana.setVisible(false);
    }
    
    public static void eliminar(){
        ventana.dispose();
    } 
}
