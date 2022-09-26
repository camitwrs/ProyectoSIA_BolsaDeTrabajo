package modelo;
import java.util.ArrayList;

public class Trabajo {
    private String nombre; // Nombre del trabajo.
    private ArrayList<String> requisitos; // Lista de requisitos del puesto.
    private ArrayList<Postulante> postulantes; // Lista de postulantes al puesto.
    
    // Constructor
    public Trabajo(String nombre){
        this.nombre = nombre;
        this.requisitos = new ArrayList<>();
        this.postulantes = new ArrayList<>();
    }
    
    public Trabajo(){
        this.requisitos = new ArrayList<>();
        this.postulantes = new ArrayList<>();
    }
    
    public void agregarRequisito(String req){
        this.requisitos.add(req);
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    // Metodo para mostrar el estado del objeto
    @Override
    public String toString() {
        return "Trabajo{" + "nombre=" + nombre + ", requisitos=" + requisitos + ", postulantes=" + postulantes + '}';
    }
    
    public void agregarPostulante(Postulante p){
        this.postulantes.add(p);
    }
    
    public int cantPostulantes(){
        int temp = 0;
        if(postulantes.isEmpty())
            return 0;
        else
            for (Postulante post : postulantes) { // Por cada postulante en la colección de postulantes...
                temp++;
            }
        return temp;
    }
}
