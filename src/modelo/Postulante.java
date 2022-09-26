package modelo;
import java.util.ArrayList;

public class Postulante {
    private String nombre; // Nombre del postulante (sin apellido)
    private int rut; // Rut del postulante (sin digito verificador)
    private int edad; // Edad del postulante
    private int experiencia; // Años de experiencia en el mundo laboral general.
    private String jornada; // Puede ser solo "fulltime" o "partime"
    private ArrayList<String> habilidades; // Lista de habilidades que posee el postulante.
 
    // Constructor
    public Postulante(String nombre, int rut, int edad, int experiencia, String jornada){
        this.nombre = nombre;
        this.rut = rut;
        this.edad = edad;
        this.experiencia = experiencia;
        this.jornada = jornada;
        this.habilidades = new ArrayList<>();
    }
    
    public void agregarHabilidad(String hab){
        this.habilidades.add(hab);
    }
    
    public boolean verificarJornada(String jornada){
        if(jornada.equalsIgnoreCase("fulltime") == true || jornada.equalsIgnoreCase("partime") == true)
            return true;
        else
            return false;
    }
    
    public void setJornada(String jornada){
        this.jornada = jornada;
    }
    
    public String getJornada() {
        return jornada;
    }
    
    public void setRut(int rut){
        this.rut = rut;
    }
    
    // Sobrecarga de métodos
    private boolean verificacion(int n){
        if(n > 5){ // verifica rut
            if(Integer.toString(rut).length() == 8)
                return true;
            else
            return false;
        } else{ // verifica edad
            if (edad >= 18)
                return true;
            else
                return false;
        }
    }
    
    private boolean verificacion(String cadena){ // Verificar nombre
        for (int x = 0; x < cadena.length(); x++) {
            char c = cadena.charAt(x);
            // Si no está entre a y z, ni entre A y Z, ni es un espacio
            if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == ' ')) {
                return false;
            }
        }
        return true;
    }

    public int getRut() {
        return rut;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return nombre;
    }
   
    public void setEdad(int edad){
        this.edad = edad;
    }
    
    public int getEdad(){    
        return edad;
    }

    @Override
    public String toString() { // Estado para objetos postulante.
        return "Postulante{" + "nombre=" + nombre + ", rut=" + rut + ", edad=" + edad + ", experiencia=" + experiencia + ", jornada=" + jornada + ", habilidades=" + habilidades + '}';
    }
  
}
