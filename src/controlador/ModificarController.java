package controlador;

import vista.ModificarView;

public class ModificarController {
    public static ModificarView ventana;
    
    public static void mostrar(){
        ventana = new ModificarView();
        ventana.setVisible(true);
    }
    
    public static void eliminar(){
        ventana.dispose();
    }
    
    public static void ocultar(){
        ventana.setVisible(false);
    }
}
