/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author rodrigoperalta
 */
public class RutInvalidoException extends NumberFormatException{
    private String mensaje;
    public RutInvalidoException(String mensaje){
        super(mensaje);
        this.mensaje = mensaje;
        
    }

    public String getMensaje() {
        return mensaje;
    }
    
}
