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
    private HashMap<String,ArrayList<Contratado>> contratados; // Lista de contratados en la empresa.
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
    // borrar luego el print
    public void mostrarPostulantes(){
        postulantes.entrySet().forEach(entry ->{
            var lista = entry.getValue();
            for(Postulante p: lista){
                System.out.println("Nombre: "+p.getNombre()+" Edad: "+p.getEdad()+" Correo: "+p.getCorreo()+" Jornada: "+p.getJornada());
            }
        });
    }
    
    public void agregarTrabajo(Trabajo t){
        
        for(int i=0; i<trabajos.size();i++){
            if((trabajos.get(i).getNombre()).equals((t.getNombre()))){
                //EL TRABAJO YA EXISTE
                break;
            }
        }
        trabajos.add(t);
        
    }
     // PATRON SINGLETON   
    public static Aplicacion getInstancia(){
        if(instancia == null){
            instancia = new Aplicacion();
        }
        return instancia;
    }
}

/*
    Habría que codificar en este controlador las funciones.
*/
