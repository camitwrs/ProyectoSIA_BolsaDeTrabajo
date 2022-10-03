package modelo;

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
