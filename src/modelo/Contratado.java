package modelo;

public class Contratado extends Postulante{
    private int remuneracion;

    public Contratado(Postulante p, int remuneracion){
        super(p.getNombre(), p.getRut(), p.getEdad(), p.getExperiencia(), p.getJornada(), p.getCorreo(), p.getPuesto());
        this.remuneracion = remuneracion;
        
    }
    public int getRemuneracion() {
        return remuneracion;
    }

    public void setRemuneracion(int remuneracion) {
        this.remuneracion = remuneracion;
    }
    
}