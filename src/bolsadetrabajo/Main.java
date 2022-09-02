/*
Tema 10: Manejo de Bolsa de Trabajo.
*/

package bolsadetrabajo;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
    
    public static void main(String[] args) throws IOException{
        
        // Creacion de un HashMap de objetos tipo Trabajo. <Key: Nombre del trabajo, Value: Objeto trabajo)
        HashMap<String,Trabajo> puestos = new HashMap<>();
        
        // ----------------------------- Menu ----------------------------------
        boolean exit = false;
        String linea;
        int opcion;
        BufferedReader lector = new BufferedReader (new InputStreamReader(System.in));
        while (exit != true){
            System.out.println("----MENU----");
            System.out.println("1: Agregar puesto de trabajo.");
            System.out.println("2: Postular a un puesto de trabajo. (agregar postulante a determinado puesto)");
            System.out.println("3: Mostrar postulantes de un puesto de trabajo.");
            System.out.println("0: Salir");
                
            opcion = leerOpcion();
                
            switch (opcion){
                case 1:
                    // Se crea el trabajo.
                    String nomb, req;
                    System.out.println("Ingrese el nombre del puesto de trabajo.");
                    nomb = lector.readLine();
                    Trabajo trab = new Trabajo(nomb);
                    for(int i = 0 ; i < 3 ; i++){
                        System.out.println("Ingrese el requisito "+(i+1)+":");
                        req = lector.readLine();
                        trab.agregarRequisito(req);
                    }
                    // Se almacena en el HashMap.
                    if(puestos.containsKey(trab.getNombre()))
                        System.out.println("Ya existe ese puesto en el mapa.");
                    else
                        puestos.put(trab.getNombre(), trab);
              
                    break;
                        
                case 2:
                    // Se crea el postulante
                    String nomb1, dispo, hab;
                    int rut,edad,exp;
                    System.out.println("Ingrese su nombre:");
                    nomb1=lector.readLine();
                    System.out.println("Ingrese su rut:");
                    rut=Integer.parseInt (lector.readLine());
                    System.out.println("Ingrese su edad:");
                    edad=Integer.parseInt(lector.readLine());
                    System.out.println("Ingrese sus anios de experiencia:");
                    exp=Integer.parseInt(lector.readLine());
                    System.out.println("Ingrese la jornada deseada (fulltime o partime):");
                    dispo=lector.readLine();
                    Postulante post = new Postulante(nomb1, rut, edad, exp, dispo); 
                    for(int i = 0 ; i < 3 ; i++){
                        System.out.println("Ingrese una habilidad/conocimiento:");
                        hab = lector.readLine();
                        post.agregarHabilidad(hab);
                    }
                    // Se muestran los trabajos disponibles
                    if(puestos.isEmpty()){
                        System.out.println("No hay puestos disponibles.");
                    }else{
                        int cont = 0;
                        System.out.println("Hay "+puestos.size()+" puestos de trabajos disponibles.");
                        for(String aux_nombre:puestos.keySet()){
                            Trabajo aux_puesto = puestos.get(aux_nombre);
                            System.out.println((cont+1)+". "+aux_puesto.getNombre());
                            cont++;
                        }
                    }
                    
                    // Pide el nombre del trabajo al que quiere postular.
                    System.out.println("Ingrese el nombre del puesto de trabajo.");
                    String nombre_del_puesto = lector.readLine();
                    if(puestos.containsKey(nombre_del_puesto)){ // Si existe ese puesto
                        Trabajo trab1 = puestos.get(nombre_del_puesto);
                        trab1.agregarPostulante(post);
                    }else
                        System.out.println("No existe ese trabajo.");
                        
                    break;
                        
                case 3:
                    System.out.println("Ingrese el nombre del puesto de trabajo.");
                    String aux_puesto = lector.readLine();
                    if(puestos.containsKey(aux_puesto)){ // Si existe ese puesto
                        Trabajo trab2 = puestos.get(aux_puesto);
                        trab2.mostrarPostulantes();
                    }else
                        System.out.println("No existe ese trabajo.");
                    break;
                    
                case 0:
                    exit = true;
                    break;
                    
            }
        }
    }
    
    public static int leerOpcion() throws IOException{
        String linea;
        int opcion;
        BufferedReader lector = new BufferedReader (new InputStreamReader(System.in));
        boolean trigger = false;
        
        
        while(trigger != true){
            System.out.println("Ingrese su opcion:");
            linea = lector.readLine();
            
            if (soloNumeros(linea) == true){
                trigger = true;
                opcion = Integer.parseInt(linea);
                return opcion;
            }
            else{
                System.out.println("Error, ha ingresado una opcion no valida, intente nuevamente.");
            }
        }
        return 0;
    }
    
        private static boolean soloNumeros(String line){
        boolean esNumero = line.matches("[0-9]+");
        if (esNumero)
            return esNumero;
        else
            return false;
    }
    
}
