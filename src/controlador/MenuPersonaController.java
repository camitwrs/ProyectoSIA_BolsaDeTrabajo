package controlador;

import vista.MenuPersonaView;

public class MenuPersonaController {
    public static MenuPersonaView ventana;
    
    public static void mostrar(){
        ventana = new MenuPersonaView();
        ventana.setVisible(true);
    }
    
    public static void ocultar(){
        ventana.setVisible(false);
    }
    
    public static void eliminar(){
        ventana.dispose();
    }
    
}
