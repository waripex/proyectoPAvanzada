package proyecto;

/**
 *@author Felipe Bravo
 * @author Cristofer Contreras
 */


import java.io.*;
import java.util.*;

public class Proyecto {
    static ArrayList<Dia> dias = new ArrayList();
    static HashMap<String,Dia> reunion = new HashMap();
    
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        llenadoReuniones();
        System.out.println(" AGENDA");
        System.out.println(" =======");
        while(true){
            System.out.println("\nMenu de Opciones:");
            System.out.println("""
                           1: Listar reuniones
                           2: Agregar nueva reunion
                           3: EXIT\n""");
        
            //Llenado de reuniones
            llenadoReuniones();
        
            // Eleccion de opciones 
            BufferedReader cc = new BufferedReader (new InputStreamReader(System.in) );
            String choice = cc.readLine();
        
            switch(choice){
                case "1" -> listarReuniones();
                case "2" -> agregarReunion();
                case "3" -> { break;
                }   
            }
            
            if("3".equals(choice)){
                System.out.println("Cerrando Agenda... ");
                break;
            }
            
      
        }
    }
    
    public static void llenadoReuniones(){
        //Supongamos que enero dia 1 es lunes, y la persona trabaja solo 5 dias a la semana
        // 1 de enero feriado(por eso no agregado jejejeje xD).
        //Enero(1-5 / 8-12 / 15-19 / 22-26 / 29-31 / +FEBRERO(1-2))

        Dia dd = new Dia(2,"Enero");
        reunion.put("Enero", dd);
        dd.agregarReunion("Junta de la empresa", 4);
        dd.agregarReunion("Visitar cliente",4);
        dd.agregarReunion("Recoger hijos",6);
        dd.agregarReunion("Futbol",2);
        dias.add(dd);
        dd = new Dia(3,"Enero");
        reunion.put("Enero", dd);
        dd.agregarReunion("Junta jefe",5);
        dd.agregarReunion("Junta de la empresa", 4);
        dd.agregarReunion("Almuerzo colegas",3);
        dd.agregarReunion("Recoger hijos",6);
        dd.agregarReunion("Cena con Esposa",5);
        dias.add(dd);
    
        dd = new Dia(4,"Enero");
        reunion.put("Enero", dd);
        dd.agregarReunion("Junta trabajo", 4);
        dd.agregarReunion("Entregar informes",3);
        dd.agregarReunion("Recoger hijos",6);
        dd.agregarReunion("Cena familia",4);
        dias.add(dd);
        
        dd = new Dia(5,"Enero");
        reunion.put("Enero", dd);
        dd.agregarReunion("Medico", 5);
        dd.agregarReunion("Entregar informes",3);
        dd.agregarReunion("Recoger hijos",6);
        dd.agregarReunion("Comprar medicamentos",3);
        dias.add(dd);
        
    }
    public static void agregarReunion() throws IOException{
        
        BufferedReader aa = new BufferedReader (new InputStreamReader(System.in) );
        int i=1;
        while(true){
            
            System.out.println("ingrese el dia: "+(i)+" Escriba Exit para salir ");
            String answer = aa.readLine();
            if (answer.equals("Exit")) break;
            Dia rr = new Dia();
            rr.setMes(answer);
            System.out.println("ingrese el mes de la Reunion: "+(i));
            rr.setNDia(Integer.parseInt(aa.readLine()));
            reunion.put(rr.getMes(), rr);
            dias.add(rr);
        }
    }
    
    public static void listarReuniones(){
        //mostrar datos de las reuniones
        System.out.println("List de reuniones");
        for(int i =0;i<dias.size();i++){
            Dia dd = dias.get(i);
            System.out.println("MES: "+dd.getMes()+"| Dia: "+dd.getNDia());
            System.out.println("Sus reuniones son: ");
            dd.listarReuniones();
        }
    }
    
    // verificar si existe el dia
    public static void  listarReunionesDelDia(String diaSemana){
        // ver si el dia existe
        if(!reunion.containsKey(diaSemana)){
            System.out.println("No hay reuniones en el dia de hoy ");
            return;
        }
        //Dia si existe
        Dia dd = (Dia)reunion.get(diaSemana);
        System.out.println("Reuniones del dia: "+dd.getMes()+" Mes: "+dd.getNDia());
        System.out.println("Sus reuniones son: ");
        dd.listarReuniones();
    }
}
