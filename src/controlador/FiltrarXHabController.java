/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import vista.FiltrarXHabView;

/**
 *
 * @author MIEQUIPO
 */
public class FiltrarXHabController {
    public static FiltrarXHabView ventana = new FiltrarXHabView();
    
    public static void mostrar(){
        ventana.setVisible(true);
    }
    
    public static void ocultar(){
        ventana.setVisible(false);
    }
}
