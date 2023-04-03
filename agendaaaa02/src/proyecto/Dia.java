package proyecto;

/**
 *@author Felipe Bravo
 * @author Cristofer Contreras
 */

import java.util.*;


public class Dia {
    private String mes; // mes correspondiente
    private int nDia; //numero del dia
    private ArrayList<Reunion> reuniones;// coleccion de reuniones
    private HashMap<String, Reunion> reunionXDia; // reuniones por dia
    
    //instancia de HashMap y ArrayList
    public Dia(){
        reuniones = new ArrayList();
        reunionXDia = new HashMap();
    }
    
    //instancia de atributos
    public Dia(String mes,int nDia){
        this.mes = mes;
        this.nDia = nDia;
    }
    
    // instancia de atributos, ArrayList y HashMap 
    public Dia(int nDia, String mes){
        this.mes = mes;
        this.nDia = nDia;
        //inicializar reuniones
        reuniones = new ArrayList();
        reunionXDia = new HashMap();
    }

    //setters y getters de los atributos
    
    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public int getNDia() {
        return nDia;
    }

    public void setNDia(int nDia) {
        this.nDia = nDia;
    }
    
    //booleano para comprobar la existencia de una reunion
    public boolean agregarReunion(Reunion rr){
        int i;
        if(reunionXDia.containsKey(rr.getNombre())){
            System.out.println("Reunion ya existente");
            return false;
        }  
        // no esta repetida la reunion
        reunionXDia.put(rr.getNombre(), rr);
        reuniones.add(rr);
        return false;
    }
    
    public void agregarReunion(String nom, int prioridad){
        Reunion rr = new Reunion(nom,prioridad);
        this.agregarReunion(rr);
    }

    
    public void listarReuniones(){
        for(int i =0;i<reuniones.size();i++){
            System.out.println("Reunion "+(i+1)+":" +reuniones.get(i).getNombre()+" Prioridad: "+reuniones.get(i).getPrioridad());
        }
        System.out.println("");
    }
    
    public Reunion buscarReunion(String nom){
        if(!reunionXDia.containsKey(nom)){
            System.out.println("La reunion no existe");
            return null;
        }
        return reunionXDia.get(nom);
    }
}
