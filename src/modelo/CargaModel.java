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
                    t.setNombre(arr[0]);
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

}
