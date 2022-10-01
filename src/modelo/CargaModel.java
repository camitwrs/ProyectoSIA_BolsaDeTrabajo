package modelo;

import java.io.*;
import java.util.ArrayList;

public class CargaModel {
    private ArrayList<Trabajo> puestos;
    
    public CargaModel(){
        this.puestos = new ArrayList<>();
    }
    
    public void cargarArchivo(File archivo){
        FileReader fr = null;
        BufferedReader br = null;
        
        try {
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String linea;
            while((linea = br.readLine()) != null){
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
            System.out.println(puestos);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            try{
                if(fr != null)
                    fr.close(); 
            }
            catch (Exception e){
                e.printStackTrace(); 
            }
        }
    }
    
    public void cargarPostulantes() throws FileNotFoundException{
        BufferedReader lector = new BufferedReader(new FileReader("./data/postulantes.csv"));
        String separador = ",";
        String linea;
        
        try{
            while((linea = lector.readLine())!=null){
                String[] datoPostulante = linea.split(separador);
                String nombre = datoPostulante[0];
                int rut = Integer.parseInt(datoPostulante[1]);
                int edad = Integer.parseInt(datoPostulante[2]);
                int experiencia = Integer.parseInt(datoPostulante[3]);
                String jornada = datoPostulante[4];
                String hab1 = datoPostulante[5];
                String hab2 = datoPostulante[6];
                String hab3 = datoPostulante[7];
                String puesto = datoPostulante[8];
                String correo = datoPostulante[9];
                
                Postulante p = new Postulante(nombre, rut, edad, experiencia, jornada, correo, puesto);
                p.agregarHabilidad(hab1);
                p.agregarHabilidad(hab2);
                p.agregarHabilidad(hab3);
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

}
