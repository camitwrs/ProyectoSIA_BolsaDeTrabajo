package controlador;

import vista.FiltrarXPuestoView;

public class FiltrarXPuestoController {
    public static FiltrarXPuestoView ventana;
    
    public static void mostrar(){
        ventana = new FiltrarXPuestoView();
        ventana.setVisible(true);
    }
    
    public static void ocultar(){
        ventana.setVisible(false);
    }
    
    public static void eliminar(){
        ventana.dispose();
    }
}
