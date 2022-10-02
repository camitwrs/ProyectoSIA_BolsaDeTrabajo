package controlador;

import vista.MenuEmpresaView;

public class MenuEmpresaController {
    public static MenuEmpresaView ventana;
    
    public static void mostrar(){
        ventana = new MenuEmpresaView();
        ventana.setVisible(true);
    }
    
    public static void ocultar(){
        ventana.setVisible(false);
    }
    
    public static void eliminar(){
        ventana.dispose();
    }
    
    public static void eventoBoton1(){ 
        AgregarPuestoController.mostrar();
    }
    
    public static void eventoBoton2(){ 
        FiltrarXPuestoController.mostrar();
    }
    
    public static void eventoBoton4(){ 
        VerContratadosController.mostrar();
    }
}
