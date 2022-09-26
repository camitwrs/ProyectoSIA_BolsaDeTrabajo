package controlador;

import vista.TipoUsuarioView;

public class TipoUsuarioController {
    public static TipoUsuarioView ventana = new TipoUsuarioView();
    
    public static void mostrar(){
        ventana.setVisible(true);
    }
    
    public static void ocultar(){
        ventana.setVisible(false);
    }
    
    public static void eventoBoton1(){ // Boton que muestra menu (ventana) persona
        MenuPersonaController.mostrar();
    }
    
    public static void eventoBoton2(){ // Boton que muestra menu (ventana) empresa
        MenuEmpresaController.mostrar();
    }
}
