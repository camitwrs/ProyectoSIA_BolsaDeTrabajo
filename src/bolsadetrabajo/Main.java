/*
Tema 10: Manejo de Bolsa de Trabajo.
*/

package bolsadetrabajo;
import java.util.ArrayList;
import java.util.HashMap;

public class Main{
    
    public static void main(String[] args) {
        
        // Se crean 3 puestos de trabajo.
        Trabajo puesto1 = new Trabajo("Desarrollador web");
        Trabajo puesto2 = new Trabajo("Analista de datos");
        Trabajo puesto3 = new Trabajo("Experto en ciberseguridad");
        
        // Se almacenan los puestos de trabajo en un HashMap.
        HashMap<String,Trabajo> puestos = new HashMap<>();
        if(puestos.containsKey(puesto1.getNombre()) || puestos.containsKey(puesto2.getNombre()) || puestos.containsKey(puesto3.getNombre()) ){
            System.out.println("Ya existe ese puesto en el mapa");
        }else{
            puestos.put(puesto1.getNombre(), puesto1);
            puestos.put(puesto2.getNombre(), puesto2);
            puestos.put(puesto3.getNombre(), puesto3);
        }
        
        // Se agregan los 3 requisitos de los puestos.
        puesto1.agregarRequisito("JavaScript");
        puesto1.agregarRequisito("SQL");
        puesto1.agregarRequisito("Angular");

        puesto2.agregarRequisito("Python");
        puesto2.agregarRequisito("Excel");
        puesto2.agregarRequisito("SQL");
        
        puesto3.agregarRequisito("Bash");
        puesto3.agregarRequisito("Cloud Security");
        puesto3.agregarRequisito("Firewall");
        
        // Se muestra el tamaño del HashMap y su contenido.
        System.out.println("Estado inicial de los puestos:");
        System.out.println("Hay "+ puestos.size() + " puestos de trabajo. Se mostraran a continuacion:");
        for(String key_nombre:puestos.keySet()){
            Trabajo value_puesto = puestos.get(key_nombre);
            System.out.println(value_puesto); 
        }
        
        // Se crean 2 postulantes.   
        Postulante post1 = new Postulante("Pepe", 11111111, 21, 2, "fulltime", "Desarrollador web");
        Postulante post2 = new Postulante("Maria", 50606333, 18, 0, "partime", "Desarrollador web");
        
        // Se agregan las habilidades de los postulantes.
        post1.agregarHabilidad("JavaScript");
        post1.agregarHabilidad("Python");
        
        post2.agregarHabilidad("Excel");
        post2.agregarHabilidad("Firewall");
        post2.agregarHabilidad("Bash");
        
        // Se agregan los postulantes al puesto de trabajo.
        puesto1.agregarPostulante(post1);
        puesto1.agregarPostulante(post2);
        
        // Se muestra el tamaño del ArrayList de postulantes.
        System.out.println("Hay "+ puesto1.cantPostulantes()+ " postulantes. Se mostraran a continuacion:");
       
        System.out.println("Estado final de los puestos luego de agregar postulantes:");
        System.out.println(puestos);
        
        // Listado de postulantes del puesto deseado.
        System.out.println("--- Mostrar postulantes de X trabajo---Ej: Desarrollador web");
        String nombre_del_puesto = "Desarrollador web";
        if(puestos.containsKey(nombre_del_puesto)){ // Si hay una key llamada Desarrollador web
            Trabajo puesto = puestos.get(nombre_del_puesto); // Guardo el struct Trabajo
            puesto.mostrarPostulantes();
        }else{
            System.out.println("No existe ese trabajo.");
        }
    }
    
}
