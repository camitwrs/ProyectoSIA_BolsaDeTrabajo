/*
Tema 10: Manejo de Bolsa de Trabajo.
*/

package bolsadetrabajo;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
    
    public static void main(String[] args) throws IOException{
        
        // Creacion de un HashMap de objetos tipo Trabajo. <Key: Nombre del trabajo, Value: Objeto trabajo)
        HashMap<String,Trabajo> puestos = new HashMap<>();
        
        // SIA 1.4 Ingreso de datos iniciales en duro.
        Trabajo ejemplo = new Trabajo("Desarrollador web");
        puestos.put(ejemplo.getNombre(), ejemplo);
        
        // ----------------------------- Menu ----------------------------------
        boolean exit = false;
        
        while (exit != true){
            System.out.println(" ----------------------------------------------------------------------");
            System.out.println("|                                                                      |");
            System.out.println("|         MENU OPCIONES                                                |");
            System.out.println("|                                                                      |");
            System.out.println("|         1: Agregar un puesto de trabajo.                             |");
            System.out.println("|         2: Postular a un puesto de trabajo.                          |");
            System.out.println("|         3: Mostrar postulantes de un puesto de trabajo.              |");
            System.out.println("|         0: Salir                                                     |");
            System.out.println("|                                                                      |");
            System.out.println(" ----------------------------------------------------------------------");
            
            int opcion;
            BufferedReader lector = new BufferedReader (new InputStreamReader(System.in));
            opcion = leerOpcion();
            
            MetodosMenu conexion = new MetodosMenu();
            
            switch (opcion){
                case 1:
                    conexion.agregarPuestoTrabajo(lector, puestos); 
                    break;
                        
                case 2:
                    conexion.postularPuestoTrabajo(lector, puestos);
                    break;
                        
                case 3:
                    conexion.mostrarPostulantesPuesto(lector, puestos);
                    break;
                    
                case 0:
                    exit = true;
                    break;
                    
            }
        }
    }
    
    // Privados porque son sub-metodos que utiliza el metodo main.
    
    private static int leerOpcion() throws IOException{
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
