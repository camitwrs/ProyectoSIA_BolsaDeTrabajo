package bolsadetrabajo;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

public class MetodosMenu {
    
    public void agregarPuestoTrabajo(BufferedReader entrada, HashMap puestos) throws IOException{
        // Se crea el trabajo
        String nombre, requisito;
        
        System.out.println("Ingrese el nombre del puesto de trabajo:");
        nombre = entrada.readLine();
        Trabajo trab = new Trabajo(nombre);
        for(int i = 0 ; i < 3 ;i++){ // Porque sabemos que el limite de requisitos es 3
            System.out.println("Ingrese el requisito "+(i+1)+":");
            requisito = entrada.readLine();
            trab.agregarRequisito(requisito);
        }
        // Se almacena en el HashMap
        if(puestos.containsKey(trab.getNombre()))
            System.out.println("Ya existe ese puesto de trabajo.");
        else{
            puestos.put(trab.getNombre(),trab);
            System.out.println("Se agrego el puesto de trabajo correctamente.");
        }
    }
    
    public void postularPuestoTrabajo(BufferedReader entrada, HashMap puestos) throws IOException{
        // Se crea el postulante
        String nombre, jornada, habilidad;
        int rut, edad, experiencia;
        
        System.out.println("Ingrese su nombre:");
        nombre=entrada.readLine();
        System.out.println("Ingrese su rut:");
        rut=Integer.parseInt (entrada.readLine());
        System.out.println("Ingrese su edad:");
        edad=Integer.parseInt(entrada.readLine());
        System.out.println("Ingrese sus anios de experiencia:");
        experiencia=Integer.parseInt(entrada.readLine());
        System.out.println("Ingrese la jornada deseada (fulltime o partime):");
        jornada=entrada.readLine();
        Postulante post = new Postulante(nombre, rut, edad, experiencia, jornada); 
        for(int i = 0 ; i < 3 ; i++){
            System.out.println("Ingrese una habilidad/conocimiento:"); // Porque sabemos que el limite de habilidades/conocmientos es 3
            habilidad = entrada.readLine();
            post.agregarHabilidad(habilidad);
        }
        // Se muestran los trabajos disponibles
        if(puestos.isEmpty()){
            System.out.println("No hay puestos disponibles.");
        }else{
            int cont = 0;
            System.out.println("Hay "+puestos.size()+" puestos de trabajos disponibles.");
            for(Object key:puestos.keySet()){
                Trabajo aux_puesto = (Trabajo) puestos.get(key);
                System.out.println((cont+1)+". "+aux_puesto.getNombre());
                cont++;
            }
            // Pide el nombre del trabajo al que quiere postular.
            System.out.println("Ingrese el nombre del puesto de trabajo:");
            String nombre_del_puesto = entrada.readLine();
            if(puestos.containsKey(nombre_del_puesto)){ // Si existe ese puesto
                Trabajo puesto = (Trabajo) puestos.get(nombre_del_puesto);
                puesto.agregarPostulante(post);
                System.out.println("Tu postulacion ha sido agregada.");
            }else
                System.out.println("No existe ese trabajo.");
            }
    }
    
    public void mostrarPostulantesPuesto(BufferedReader entrada, HashMap puestos) throws IOException{
        // Busca el puesto de trabajo y muestra los postulantes.
        System.out.println("Ingrese el nombre del puesto de trabajo:");
        String aux_puesto = entrada.readLine();
        if(puestos.containsKey(aux_puesto)){ // Si existe ese puesto
            Trabajo trab = (Trabajo) puestos.get(aux_puesto);
            trab.mostrarPostulantes();
        }else
            System.out.println("No existe ese trabajo.");
    }
            
}
