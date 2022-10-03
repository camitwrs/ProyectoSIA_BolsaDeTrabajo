/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import modelo.Trabajo;
import modelo.CargaModel;
import modelo.Contratado;
import modelo.Postulante;

/**
 *
 * @author javi_
 */

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
        trabajos = CargaModel.cargarPuestos();
        CargaModel.cargarPostulantes(this);
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
            Postulante postulanteMax = new Postulante();
            for(int n = 0; n < listaPostulantes.size()-1 ; n++){
                Postulante aa = listaPostulantes.get(n+1);
                Postulante bb = listaPostulantes.get(n);
                if(aa.getPuntos() > bb.getPuntos()){
                    postulanteMax = aa;
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
}

/*
    Habría que codificar en este controlador las funciones.
*/
