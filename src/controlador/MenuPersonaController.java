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
    
    public static void eventoBoton1(){ // Boton postular
        PostularController.mostrar();
    }
    
    public static void eventoBoton2(){ // Boton me contrataron?
        ContratadoController.mostrar();
    }
    
    public static void eventoBoton3(){ // Boton me contrataron?
        ContratadoController.mostrar();
    }
    
    public static void eventoBoton4(){ // Boton me contrataron?
        EliminarController.mostrar();
    }
}
