/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import vista.PostularView;

/**
 *
 * @author rodrigoperalta
 */
public class PostularController {
    public static PostularView ventana;
    
    public static void mostrar(){
        ventana = new PostularView();
        ventana.setVisible(true);
    }
    
    public static void ocultar(){
        ventana.dispose();
    }

    
}
