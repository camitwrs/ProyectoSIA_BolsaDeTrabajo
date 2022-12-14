package modelo;
import java.util.ArrayList;

public class Postulante {
    private String nombre; // Nombre del postulante (sin apellido)
    private int rut; // Rut del postulante (sin digito verificador)
    private int edad; // Edad del postulante
    private String correo; // Correo de contacto del postulante.
    private int experiencia; // Años de experiencia en el mundo laboral general.
    private String jornada; // Puede ser solo "fulltime" o "partime"
    private ArrayList<String> habilidades; // Lista de habilidades que posee el postulante.
    private String puesto;
    private int puntos;
    
    // Constructor
    public Postulante(String nombre, int rut, int edad, int experiencia, String jornada, String correo, String puesto){
        this.correo = correo;
        this.experiencia = experiencia;
        this.jornada = jornada;
        this.nombre = nombre;
        this.rut = rut;
        this.edad = edad;
        this.habilidades = new ArrayList<>();
        this.puesto = puesto;
        this.puntos = 0;
    }
    public Postulante(){
        this.habilidades = new ArrayList();
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
    
    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = this.puntos + puntos;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    
    public void setJornada(String jornada){
        this.jornada = jornada;
    }
    
    public String getJornada() {
        return jornada;
    }
        public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    @Override
    public String toString() {
        return "Postulante{" + "nombre=" + nombre + ", rut=" + rut + ", edad=" + edad + ", correo=" + correo + ", experiencia=" + experiencia + ", jornada=" + jornada + ", habilidades=" + habilidades + ", puesto=" + puesto + '}';
    }
    public ArrayList<String> getHabilidades(){
        return this.habilidades;
    }

}
