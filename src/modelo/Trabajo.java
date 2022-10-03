package modelo;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Trabajo {
    private String nombre; // Nombre del trabajo.
    private int remuneracion; // Remuneracion del puesto.
    private ArrayList<String> requisitos; // Lista de requisitos del puesto.
    
    // Constructor
    public Trabajo(String nombre){
        this.nombre = nombre;
        this.requisitos = new ArrayList();
    }
    
    public Trabajo() throws FileNotFoundException{
        this.requisitos = new ArrayList();
        //this.postulantes = new HashMap();
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
    
    public void setRemuneracion(int remuneracion){
        this.remuneracion = remuneracion;
    }
    
    public int getRemuneracion(){
        return remuneracion;
    }
    @Override
    public String toString() {
        return this.nombre;
    }
    
    public ArrayList<String> getRequisitos(){
        return this.requisitos;
    }

    
    
}
