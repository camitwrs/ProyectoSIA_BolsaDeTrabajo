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
    public static void eventoBoton1(){ // Boton postular
        PostularController.mostrar();
        MenuPersonaController.ocultar();
    }
    
    public static void eventoBoton2(){ // Boton me contrataron?
        ContratadoController.mostrar();
        MenuPersonaController.ocultar();
    }
}
