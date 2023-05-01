
package com.mycompany.proyectoagenda;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.*;
import java.util.*;

/**
 *
 * @author felip
 */
public class Menu {
    
    static ArrayList<Dia> dias = new ArrayList();
    static HashMap<String,Dia> reunion = new HashMap();
    
    public static void crearMenu() throws IOException{
        // Menu
        System.out.println(" AGENDA");
        System.out.println(" =======");
        importarCsv();
        while(true){
            System.out.println("\nMenu de Opciones:");
            System.out.println("""
                           1: Listar reuniones
                           2: Agregar nueva reunion
                           3: EXIT\n""");
        
        
            // Eleccion de opciones 
            BufferedReader cc = new BufferedReader (new InputStreamReader(System.in) );
            String choice = cc.readLine();
        
            switch(choice){
                case "1" -> listarReuniones();
                case "2" -> agregarReunion();
                case "3" -> { break;
                }   
            }
            //opción para cerrar la agenda.
            if("3".equals(choice)){
                System.out.println("Cerrando Agenda... ");
                break;
            }
        }
    }
    

    
    public static void agregarReunion() throws IOException{
        
        BufferedReader aa = new BufferedReader (new InputStreamReader(System.in) );
        int i=1;
        
        System.out.println("ingrese el mes: ");
        String answer = aa.readLine();
        //instancia del dia
        Dia rr = new Dia();
        rr.setMes(answer);
        System.out.println("ingrese el dia: ");
        rr.setNDia(Integer.parseInt(aa.readLine()));
        reunion.put(rr.getMes(), rr);
        //se crea mas de una reunion por dia, si el usuario quiere
        while(true){
            System.out.println("ingrese el nombre de la Reunion: "+(i)+"| Presione x para salir");
            answer = aa.readLine();
            if (answer.equals("x" )) break;
            //instancia de la reunion
            Reunion ss = new Reunion();
            ss.setNombre(answer);
            reunion.put(ss.getNombre(),rr);
            String name = ss.getNombre();
            System.out.println("ingrese la prioridad: ");
            ss.setPrioridad(Integer.parseInt(aa.readLine()));
            int priori = ss.getPrioridad();
            rr.agregarReunion(name,priori );//añadimos la reunion creada al dia
            i++;
        }  
        dias.add(rr);// cerramos el dia, con los datos guardados
    }
   
    
    
    public static void listarReuniones() {
    System.out.println("List de reuniones");
    for (int i = 0; i < dias.size(); i++) {
        Dia dd = dias.get(i);
        System.out.printf("MES: %s| Dia: %d\n", dd.getMes(), dd.getNDia());
        System.out.println("Sus reuniones son: ");
        dd.listarReuniones();   
        
    }
}
    
   
    
    public static void importarCsv(){
        
        String csvFilePath = "ArReuniones.csv";
        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
            String[] header = reader.readNext(); // leer la primera línea (encabezado) y descartarla
            String[] row = null;
            while ((row = reader.readNext()) != null) {
                int day = Integer.parseInt(row[0]);
                String month = row[1];
                String nameReunion = row[2];
                int priority = Integer.parseInt(row[3]);
                llenadoReuniones(day, month, nameReunion, priority);
            }
            
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
    
    
    
    public static void llenadoReuniones(int day, String month, String title, int priority ){
        
        Dia dd = new Dia(day,month);
        reunion.put(month,dd);
        dd.agregarReunion(title,priority);
        dias.add(dd);
    }
    
}
