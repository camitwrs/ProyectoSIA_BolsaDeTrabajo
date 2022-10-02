package modelo;

import controlador.Aplicacion;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class CargaModel {
    
    public static ArrayList<Trabajo> cargarPuestos ()throws FileNotFoundException {
        BufferedReader lector = new BufferedReader(new FileReader("./data/trabajos.csv"));
        String linea;
        ArrayList <Trabajo> puestos = new ArrayList();
        
        try {
            while((linea = lector.readLine()) != null){
                String arr[] = linea.split(",");
                if(arr.length >= 1){
                    Trabajo t = new Trabajo();
                    t.setNombre(arr[0].toLowerCase());
                    t.agregarRequisito(arr[1]);
                    t.agregarRequisito(arr[2]);
                    t.agregarRequisito(arr[3]);
                    puestos.add(t);
                }
                
            }
            return puestos;
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            try{
                if(lector != null)
                    lector.close(); 
            }
            catch (Exception e){
                e.printStackTrace(); 
            }
        }
        return null;
    }
    
    public static HashMap<String,ArrayList<Postulante>> cargarPostulantes(Aplicacion app) throws FileNotFoundException{
        BufferedReader lector = new BufferedReader(new FileReader("./data/postulantes.csv"));
        String linea;
        HashMap<String,ArrayList<Postulante>> postGenerales = new HashMap();
        
        try{
            while((linea = lector.readLine())!=null){
                String[] datoPostulante = linea.split(",");
                if(datoPostulante.length >= 1){
                    String nombre = datoPostulante[0];
                    int rut = Integer.parseInt(datoPostulante[1]);
                    int edad = Integer.parseInt(datoPostulante[2]);
                    int experiencia = Integer.parseInt(datoPostulante[3]);
                    String jornada = datoPostulante[4];
                    String puesto = datoPostulante[5];
                    String correo = datoPostulante[6];
                    String hab1 = datoPostulante[7];
                    String hab2 = datoPostulante[8];
                    String hab3 = datoPostulante[9];
                
                    Postulante p = new Postulante(nombre, rut, edad, experiencia, jornada, correo, puesto);
                    p.agregarHabilidad(hab1);
                    p.agregarHabilidad(hab2);
                    p.agregarHabilidad(hab3);
                    
                    //System.out.println(p);
                    //System.out.println("ANTESSSSS Nombre: "+p.getNombre()+" Rut: "+p.getRut()+" Edad: "+p.getEdad()+" Experiencia: "+p.getExperiencia()+" Jornada: "+p.getJornada()+" Puesto: "+p.getPuesto()+" Correo: "+p.getCorreo());
                    app.agregarPostulante(p);
                }
            }
            return postGenerales;
        }
        catch(IOException e){
            e.printStackTrace();
        }
        finally{
            try{
                if(lector != null)
                    lector.close(); 
            }
            catch (Exception e){
                e.printStackTrace(); 
            }
        }
        return null;
    }

}
