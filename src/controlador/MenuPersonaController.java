package controlador;

import vista.MenuPersonaView;

public class MenuPersonaController {
    public static MenuPersonaView ventana = new MenuPersonaView();
    
    public static void mostrar(){
        ventana.setVisible(true);
    }
    
    public static void ocultar(){
        ventana.setVisible(false);
    }
}
