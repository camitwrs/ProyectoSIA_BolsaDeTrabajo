package controlador;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import modelo.Trabajo;
import modelo.CargaModel;
import modelo.Contratado;
import modelo.Postulante;

/*
Desde el controlador Aplicacion se llaman a todas las demás funciones, ya que
contiene a: el ArrayList de trabajos, el HashMap de todos los postulantes y
el HashMap de todos los contratados.
*/

public class Aplicacion {
    private static Aplicacion instancia = null; // PATRON SINGLETON
    private ArrayList<Trabajo> trabajos; // Lista de todos los trabajos en la empresa.
    private HashMap<String,ArrayList<Postulante>> postulantes; // Lista de postulantes al puesto.
    private HashMap<String,Contratado> contratados; // Lista de contratados en la empresa.
    private Aplicacion(){ // PATRON SINGLETON
        postulantes = new HashMap();
        contratados = new HashMap();
    }
    public void inicio() throws FileNotFoundException{
        trabajos = CargaModel.cargar();
        CargaModel.cargar(this);
        TipoUsuarioController.mostrar();
        while(true){}
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

    public ArrayList<Trabajo> conseguirTrabajos() {
        return trabajos;
    }

    public HashMap<String, ArrayList<Postulante>> conseguirMapPostulantes() {
        return postulantes;
    }

    public HashMap<String, Contratado> conseguirContratados() {
        return contratados;
    }

    public boolean agregarTrabajo(Trabajo t){
        
        for(int i=0; i<trabajos.size();i++){
            if((trabajos.get(i).getNombre()).equals((t.getNombre()))){
                //EL TRABAJO YA EXISTE
                return false;
            }
        }
        trabajos.add(t);
        return true;
    }
    
    public boolean buscarPostulanteContratado(int rut,String puesto){
        Contratado aux;
        if(contratados.containsKey(puesto)){
            //se encontro el puesto
            aux=contratados.get(puesto);//OBTIENE LA ARRAYLIST DEL PUESTO
            if(aux.getRut()==rut){
                return true;
            }
        }
        return false;
    }
    
    public boolean eliminarPostulacion(int rut, String puesto){
        if(postulantes.containsKey(puesto)){
            var lista = postulantes.get(puesto);
            for(int i = 0 ; i < lista.size() ; i++){
                Postulante p = lista.get(i);
                if(p.getRut() == rut){
                    lista.remove(i);
                    return true;
                }
            }
        }
        return false;
    }
    
     // PATRON SINGLETON   
    public static Aplicacion getInstancia(){
        if(instancia == null){
            instancia = new Aplicacion();
        }
        return instancia;
    }
    
    public void contratarPostulantes(){
        for(int i = 0 ; i < trabajos.size() ; i++){
            Trabajo tt = trabajos.get(i);
            String nombrePuesto = tt.getNombre();
            ArrayList<Postulante> listaPostulantes = postulantes.get(nombrePuesto);
            for(int j = 0 ; j < listaPostulantes.size() ; j++){
                Postulante pp = listaPostulantes.get(j);
                ArrayList<String> habilidadesPostulante = pp.getHabilidades();
                ArrayList<String> requisitosTrabajo = tt.getRequisitos();
                pp.setPuntos(puntosXHabilidad(requisitosTrabajo, habilidadesPostulante));
                if(pp.getExperiencia() >= 2 && pp.getExperiencia() <= 4){
                    pp.setPuntos(1);
                }
                if(pp.getExperiencia() >= 5){
                    pp.setPuntos(2);
                }
            }
            Postulante postulanteMax = listaPostulantes.get(0);
            for(int n = 0; n < listaPostulantes.size(); n++){
                Postulante bb = listaPostulantes.get(n);
                if(bb.getPuntos() > postulanteMax.getPuntos()){
                    postulanteMax = bb;
                }
            }
            Contratado trabajador = new Contratado(postulanteMax, tt.getRemuneracion());
            contratados.put(nombrePuesto, trabajador);
            
        }
    }
    
    public int puntosXHabilidad(ArrayList<String> habs, ArrayList<String> reqs){
        int puntos = 0;
        for(int k = 0 ; k < reqs.size() ; k++){
            for(int l = 0 ; l < habs.size() ; l++){
                if(habs.get(l).equals(reqs.get(k))){
                    puntos = puntos + 2;
                }
            }   
        }
        return puntos;
    }
    
    public void exportar() throws IOException{
        try{
            File archivo = new File("reporte.txt");
            FileWriter aux = new FileWriter(archivo);
            try (BufferedWriter output = new BufferedWriter(aux)) {
                output.write(mostrarPuestos());
                output.write("---------------------------------------------------\n");
                //output.write(mostrarPostulantes());
                output.write("---------------------------------------------------\n");
            }
        }catch(IOException e){
            //e.getStackTrace();
            System.out.println("Exportación INVALIDA");
        }
    }
   public String mostrarPuestos() throws IOException{
       String cadena = "";
       String requisitos = "";
        for(int i = 0; i < trabajos.size() ; i++){
            Trabajo tt = trabajos.get(i);
            for(int j = 0 ; j < tt.getRequisitos().size() ; j++){
                requisitos = tt.getRequisitos().toString();
            }
            System.out.println(requisitos);
            cadena = "Nombre: "+cadena+tt.getNombre()+" Remuneracion: "+tt.getRemuneracion()+" Requisitos: "+requisitos;
        }
        return cadena;
    }
    
    public String mostrarPostulantes(){
        String cadena = "";
        String habilidades = "";
        for (Object value : postulantes.values()) {
            ArrayList<Postulante> listaP = (ArrayList<Postulante>)value;
            for(int i = 0 ; i < listaP.size() ; i++){
                Postulante pp = listaP.get(i);
                for(int j = 0 ; j < pp.getHabilidades().size() ; j++){
                    habilidades = habilidades+pp.getHabilidades().get(i);
                }
                cadena = "Nombre: "+pp.getNombre()+" Rut: "+pp.getRut()+" Edad: "+pp.getEdad()+" Correo: "+pp.getCorreo()+" Puesto: "+pp.getPuesto()+" Años de experiencia: "+pp.getExperiencia()+" Puntos: "+pp.getPuntos()+" Jornada: "+pp.getJornada()+habilidades;
            }
        }
        return cadena;
        
    }
}

/*
    Habría que codificar en este controlador las funciones.
*/
