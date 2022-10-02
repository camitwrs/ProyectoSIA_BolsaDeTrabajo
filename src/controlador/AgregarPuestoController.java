package controlador;

import vista.AgregarPuestoView;

public class AgregarPuestoController {
    public static AgregarPuestoView ventana;
    
    public static void mostrar(){
        ventana = new AgregarPuestoView();
        ventana.setVisible(true);
    }
    
    public static void eliminar(){
        ventana.dispose();
    }
    
    public static void ocultar(){
        ventana.setVisible(false);
    }
}
