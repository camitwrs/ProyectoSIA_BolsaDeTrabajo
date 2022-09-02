package bolsadetrabajo;
import java.util.ArrayList;

public class Postulante {
    private String nombre; // Nombre del postulante (sin apellido)
    private int rut; // Rut del postulante (sin digito verificador)
    private int edad; // Edad del postulante
    private int experiencia; // Años de experiencia en el mundo laboral general.
    private String disponibilidad; // Puede ser solo "fulltime" o "partime"
    private ArrayList<String> habilidades; // Lista de habilidades que posee el postulante.
   
    // Constructor
    public Postulante(String nombre, int rut, int edad, int experiencia, String disponibilidad){
        setNombre(nombre);
        setRut(rut);
        setEdad(edad);
        this.experiencia = experiencia;
        setDisponibilidad(disponibilidad);
        this.habilidades = new ArrayList<>();
    }
    
    public void agregarHabilidad(String hab){
        this.habilidades.add(hab);
    }
    
    public void setDisponibilidad(String disponibilidad){
        if(disponibilidad.equalsIgnoreCase("fulltime") == true || disponibilidad.equalsIgnoreCase("partime") == true)
            this.disponibilidad = disponibilidad;
        else
            System.out.println("Jornada invalida.");
    }
    
    public String getDisponibilidad() {
        return disponibilidad;
    }
   
    public void setRut(int rut){    
        verificacion(rut);
    }
    
    // Sobrecarga de métodos
    private void verificacion(int rut){
        if(Integer.toString(rut).length() == 8)
            this.rut = rut;
        else
            System.out.println("Rut invalido.");
    }
    
    private boolean verificacion(String cadena){
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
        if (verificacion(nombre)) // Si contiene solo letras
            this.nombre = nombre;
        else
            System.out.println("Nombre invalido.");
    }
    
    public String getNombre() {
        return nombre;
    }
   
    public void setEdad(int edad){
        if (edad >= 18)
            this.edad = edad;
        else
            System.out.println("No puede postular.");
    }
    
    public int getEdad(){    
        return edad;
    }

    @Override
    public String toString() { // Estado para objetos postulante.
        return "Postulante{" + "nombre=" + nombre + ", rut=" + rut + ", edad=" + edad + ", experiencia=" + experiencia + ", disponibilidad=" + disponibilidad + ", habilidades=" + habilidades + '}';
    }
  
}
