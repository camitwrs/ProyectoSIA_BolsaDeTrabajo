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
}
