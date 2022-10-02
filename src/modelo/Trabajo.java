package modelo;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

public class Trabajo {
    private String nombre; // Nombre del trabajo.
    private ArrayList<String> requisitos; // Lista de requisitos del puesto.
    private HashMap<String,ArrayList<Postulante>> postulantes; // Lista de postulantes al puesto.
    private HashMap<String,ArrayList<Postulante>> contratados; // Lista de contratados en la empresa.
    
    // Constructor
    public Trabajo(String nombre){
        this.nombre = nombre;
        this.requisitos = new ArrayList();
        this.postulantes = new HashMap();
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
    
    @Override
    public String toString() {
        return this.nombre;
    }

    

    public int cantPostulantes(){
        int temp = 0;
        //Arreglar esto
        return temp;
    }
    
    
    public void agregarPostulante(Postulante aa){
        if(postulantes.containsKey(aa.getPuesto())){
            var lista = postulantes.get(aa.getPuesto());
            lista.add(aa);
        }else{
            var lista = new ArrayList<Postulante>();
            lista.add(aa);
            postulantes.put(aa.getPuesto(), lista);
        }
    }
}
