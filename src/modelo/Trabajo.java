package modelo;
import java.util.ArrayList;
import java.util.HashMap;

public class Trabajo {
    private String nombre; // Nombre del trabajo.
    private ArrayList<String> requisitos; // Lista de requisitos del puesto.
    private HashMap<Integer,Postulante> postulantes; // Lista de postulantes al puesto.
    
    // Constructor
    public Trabajo(String nombre){
        this.nombre = nombre;
        this.requisitos = new ArrayList<>();
        this.postulantes = new HashMap<>();
    }
    
    public Trabajo(){
        this.requisitos = new ArrayList<>();
        this.postulantes = new HashMap<>();
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
        this.postulantes.put(p.getRut(),p);
    }
    public void mostrarPostulantes(){ 
        if(postulantes.isEmpty())
            System.out.println("No hay postulantes.");
        else
            for (Postulante post : postulantes.values()) {
                System.out.println("Nombre: "+post.getNombre()+" Edad: "+post.getEdad()+" Rut: "+post.getRut());
            }
}
    

    public int cantPostulantes(){
        int temp = 0;
        if(postulantes.isEmpty())
            return temp;
        else
            temp = postulantes.size();
        return temp;
    }
}
