/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import vista.AgregarPuestoView;

/**
 *
 * @author MIEQUIPO
 */
public class AgregarPuestoController {
    public static AgregarPuestoView ventana;
    
    public static void mostrar(){
        ventana = new AgregarPuestoView();
        ventana.setVisible(true);
    }
    
    public static void ocultar(){
        ventana.dispose();
    }
}
