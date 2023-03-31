package Proyectoto;

import java.util.*;
public class Mainproyecto {
    public static void Main(String[] args){
        Reunion d1 = new Reunion("cita medico",1,1,"salud");
        
        
        Agenda sem1 = new Agenda(1);
        
        Map<Integer,Agenda> rr = new HashMap();
        rr.put(1,sem1);
        
        Agenda aa = rr.get(1);
        aa.agregaractividad(d1);
        
        System.out.print(rr.get(1));
    }
}
