
package com.mycompany.proyectoagenda;

import com.opencsv.*;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import java.io.*;
import java.util.*;

/**
 *
 * @author felip
 */
public class Menu {
    
    static ArrayList<Dia> dias = new ArrayList();
    static HashMap<String,Dia> reunion = new HashMap();
    
    public static void crearMenu() throws IOException, CsvValidationException{
        // Menu
        System.out.println(" AGENDA");
        System.out.println(" =======");
        importarCsv();
        while(true){
            System.out.println("\nMenu de Opciones:");
            System.out.println("""
                           1: Listar reuniones
                           2: Agregar nueva reunion
                           3: Editar una reunion
                           4: Eliminiar una reunion
                           5: Motrar reuniones del dia
                           6: EXIT\n""");
        
        
            // Eleccion de opciones 
            BufferedReader cc = new BufferedReader (new InputStreamReader(System.in) );
            String choice = cc.readLine();
        
            switch(choice){
                case "1" -> listarReuniones();
                case "2" -> agregarReunion();
                case "3" -> editarReunion();
                case "4"  -> eliminarReunion();
                case "5" -> reunionesDelDia();
                case "6" -> { break;}
                
            }
            //opción para cerrar la agenda.
            if("6".equals(choice)){
                System.out.println("Cerrando Agenda... ");
                exportarCsv();
                break;
            }
        }
    }
    
    
    public static void agregarReunion() throws IOException{
        
        BufferedReader aa = new BufferedReader (new InputStreamReader(System.in) );
        int i=1;
        
        System.out.println("Ingrese el mes: ");
        String mes = aa.readLine();
        
        // Verificar si el mes ya existe en el HashMap de reuniones
        Dia rr = reunion.get(mes);
        if (rr == null) {
            // Si el mes no existe, crear una nueva instancia de Dia
            rr = new Dia();
            rr.setMes(mes);
        }
        
        //System.out.println("Ingrese el dia: ");
        //int dia = Integer.parseInt(aa.readLine());
        //rr.setNDia(dia);
        
        System.out.println("Ingrese el dia: ");
    int dia = 0;
    try {
        dia = Integer.parseInt(aa.readLine());
        if (dia > 31) {
            throw new IllegalArgumentException("Error: dia ingreado supera el máximo días de un mes");
        }
    } catch (NumberFormatException e) {
        System.out.println("Debe ingresar un valor numérico para el día.");
        return;
    } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
        return;
    }
        
        // Verificar si el día ya existe en el ArrayList de días
        boolean diaExiste = false;
        for (Dia d : dias) {
            if (d.getMes().equals(mes) && d.getNDia() == dia) {
                // Si el día existe, asignarlo a la variable rr y salir del loop
                rr = d;
                diaExiste = true;
                break;
            }
        }
        
        if (!diaExiste) {
            // Si el día no existe, agregarlo al ArrayList de días
            dias.add(rr);
        }
        
        reunion.put(mes, rr);
        
        //se crea más de una reunión por día, si el usuario quiere
        while(true){
            System.out.println("Ingrese el nombre de la Reunión " + i + " | Presione x para salir");
            String nombre = aa.readLine();
            if (nombre.equals("x" )) break;
            
            //instancia de la reunion
            Reunion ss = new Reunion();
            ss.setNombre(nombre);
            reunion.put(ss.getNombre(),rr);
            
            System.out.println("Ingrese la prioridad: ");
            ss.setPrioridad(Integer.parseInt(aa.readLine()));
            int priori = ss.getPrioridad();
            rr.agregarReunion(nombre, priori);//añadimos la reunión creada al día
            i++;
        }  
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
    
    
    public static void reunionesDelDia() throws IOException{
        
        BufferedReader aa = new BufferedReader (new InputStreamReader(System.in) );
        System.out.println("Ingrese el dia: ");
        int n = Integer.parseInt(aa.readLine());
        System.out.println("Ingrese el mes: ");
        String m = aa.readLine();
        System.out.println("Las reuniones del dia " +n +" del mes "+m+" son:");

        for (int i = 0; i < dias.size(); i++) {
            Dia dd = dias.get(i);
            if(dd.getMes().equals(m) && dd.getNDia() == n){
                dd.listarReuniones(true);
            }   
        }
}
   
    
    public static void importarCsv() throws CsvValidationException{
        
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
    
    public static void eliminarReunion() throws IOException{
        BufferedReader aa = new BufferedReader (new InputStreamReader(System.in) );
        System.out.println("Ingrese el mes: ");
        String mes = aa.readLine();
        System.out.println("Ingrese el dia: ");
        int dia = Integer.parseInt(aa.readLine());
        System.out.println("Ingrese el nombre de la Reunión: ");
        String nombre = aa.readLine();
        
        // Verificar si el mes ya existe en el HashMap de reuniones
        Dia rr = reunion.get(mes);
        if (rr == null) {
            // Si el mes no existe, crear una nueva instancia de Dia
            rr = new Dia();
            rr.setMes(mes);
        }
        
        rr.eliminarReunion(nombre);
    }
    
    public static void editarReunion(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el mes: ");
        String mes = sc.nextLine();
        System.out.println("Ingrese el dia: ");
        int dia = sc.nextInt();
        System.out.println("Ingrese el nombre de la Reunión: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese la prioridad: ");
        int prioridad = sc.nextInt();
        
        // Verificar si el mes ya existe en el HashMap de reuniones
        Dia rr = reunion.get(mes);
        if (rr == null) {
            // Si el mes no existe, crear una nueva instancia de Dia
            rr = new Dia();
            rr.setMes(mes);
        }
        
        rr.editarReunion(nombre, prioridad);
        
    }
    
    public static void llenadoReuniones(int day, String month, String title, int priority) {
    // verificar si ya esta dentro del arreglo
    boolean encontrado = false;
    for (int i = 0; i < dias.size(); i++) {
        Dia dd = dias.get(i);
        if (dd.getMes().equals(month) && dd.getNDia() == day) {
            dd.agregarReunion(title, priority);
            encontrado = true;
            break;
        }
    }
    if (!encontrado) {
        Dia dd = new Dia(day, month);
        reunion.put(month,dd);
        dd.agregarReunion(title, priority);
        dias.add(dd);
    }
}
    
    public static void exportarCsv() {
    // Escribir los datos en un archivo CSV
        String[] encabezado = {"Dia", "Mes", "Nombre Reunion", "Prioridad"};
        try {
            String csvFilePath = "ArReuniones.csv";
            CSVWriter writer = new CSVWriter(new FileWriter(csvFilePath));
            writer.writeNext(encabezado,false);

            for(int i=0;i< dias.size();i++){
                Dia dia = dias.get(i);
                ArrayList<Reunion> reuniones = dia.getReuniones();
                for (Reunion rr : reuniones) {
                    String[] fila = new String[4];

                    fila[0] = Integer.toString(dia.getNDia());
                    fila[1] = dia.getMes();
                    fila[2] = rr.getNombre();
                    fila[3] = Integer.toString(rr.getPrioridad());
                    writer.writeNext(fila, false);
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
