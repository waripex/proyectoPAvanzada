package proyecto;

import java.io.*;
import java.util.*;

public class Proyecto {
    static ArrayList<Dia> dias = new ArrayList();
    static HashMap reunion = new HashMap();
    
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        llenadoReuniones();
        
        listarReuniones();
    }
    
    public static void llenadoReuniones(){
        Dia dd = new Dia("Lunes",1);
        reunion.put("Dia 1", dd);
        dd.agregarReunion("Junta de la empresa", 1);
        dd.agregarReunion("Visitar cliente",1);
        dd.agregarReunion("Recoger hijos",1);
        dd.agregarReunion("Futbol",1);
        dias.add(dd);
        
        dd = new Dia("Martes",1);
        reunion.put("Martes", dd);
        dd.agregarReunion("Junta jefe",2);
        Reunion rr = new Reunion(2,"Visitar cliente");
        dd.agregarReunion(rr);
        dd.agregarReunion(new Reunion(2,"Recoger hijos"));
        dias.add(dd);
    
        /*dd = new Dia(Miercoles,1);
        dias.add(dd);
        reunion.put("Miercoles",dd);*/
        
    
        dd = new Dia("Miercoles",1);
        reunion.put("Miercoles", dd);
        dd.agregarReunion("Junta almuerzo", 3);
        dd.agregarReunion("Entregar informes",3);
        dd.agregarReunion("Recoger hijos",3);
        dd.agregarReunion("cenar con familia",3);
        dias.add(dd);
        
    }
    public static void agregarReunion() throws IOException{
        
        BufferedReader aa = new BufferedReader (new InputStreamReader(System.in) );
        int i=1;
        while(true){
            // nombre = Lunes, Martes, Miercoles, etc.
            
            System.out.println("ingrese nombre del dia: "+(i)+" Escriba Exit para salir ");
            String answer = aa.readLine();
            if (answer.equals("Exit")) break;
            Dia rr = new Dia();
            rr.setDiaSemana(answer);
            // mes = 1, 2, 3, 4, etc. corresponde al numero del mes: "mes 1"
            System.out.println("ingrese el mes de la Reunion: "+(i));
            rr.setMes(Integer.parseInt(aa.readLine()));
            reunion.put(rr.getDiaSemana(), rr);
            dias.add(rr);
        }
    }
    
    
    public static void listarReuniones(){
        //mostrar datos de las reuniones
        System.out.println("List de reuniones");
        for(int i =0;i<dias.size();i++){
            Dia dd = dias.get(i);
            System.out.println("Dia: "+dd.getDiaSemana()+" Mes; "+dd.getMes());
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
        System.out.println("Reuniones del dia: "+dd.getDiaSemana()+" Mes: "+dd.getMes());
        System.out.println("Sus reuniones son: ");
        dd.listarReuniones();
    }
}
