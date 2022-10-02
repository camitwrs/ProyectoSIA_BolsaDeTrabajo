package controlador;

import vista.TipoUsuarioView;

public class TipoUsuarioController {
    
    public static TipoUsuarioView ventana;
    
    public static void mostrar(){
        ventana = new TipoUsuarioView();
        ventana.setVisible(true);
    }
    
    public static void ocultar(){
        ventana.setVisible(false);
    }
    
    public static void eliminar(){
        ventana.dispose();
    }
    
    public static void eventoBoton1(){ // Boton que muestra menu (ventana) persona
        MenuPersonaController.mostrar();
        TipoUsuarioController.ocultar();
    }
    
    public static void eventoBoton2(){ // Boton que muestra menu (ventana) empresa
        MenuEmpresaController.mostrar();
        TipoUsuarioController.ocultar();
    }
}
