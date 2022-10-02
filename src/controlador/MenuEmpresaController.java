package controlador;

import vista.MenuEmpresaView;

public class MenuEmpresaController {
    public static MenuEmpresaView ventana = new MenuEmpresaView();
    
    public static void mostrar(){
        ventana.setVisible(true);
    }
    
    public static void ocultar(){
        ventana.setVisible(false);
    }
    
    public static void eventoBoton1(){ // Boton que muestra menu (ventana) persona
        AgregarPuestoController.mostrar();
    }
    
    public static void eventoBoton2(){ // Boton que muestra menu (ventana) persona
        FiltrarXPuestoController.mostrar();
    }
    
    public static void eventoBoton3(){ // Boton que muestra menu (ventana) persona
        FiltrarXHabController.mostrar();
    }
    
    public static void eventoBoton4(){ // Boton que muestra menu (ventana) persona
        VerContratadosController.mostrar();
    }
}
