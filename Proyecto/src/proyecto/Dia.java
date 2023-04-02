package proyecto;

import java.util.*;


public class Dia {
    private String diaSemana;
    private int mes;
    private ArrayList<Reunion> reuniones;
    private HashMap<String, Reunion> reunionXDia;
    
    public Dia(){
        reuniones = new ArrayList();
        reunionXDia = new HashMap();
    }
    public Dia(String diaSemana,int mes){
        this.diaSemana = diaSemana;
        this.mes = mes;
    }
    public Dia(int meses, String dSem){
        diaSemana = dSem;
        mes = meses;
        //inicializar reuniones
        reuniones = new ArrayList();
        reunionXDia = new HashMap();
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }
    
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
    
    public void agregarReunion(String nom, int dia){
        Reunion rr =  new Reunion(dia,nom);
        this.agregarReunion(rr);
    }

    
    public void listarReuniones(){
        for(int i =0;i<reuniones.size();i++){
            System.out.println("Reunion: "+reuniones.get(i).getNombre()+" Dia: "+reuniones.get(i).getDia());
        }
    }
    
    public Reunion buscarReunion(String nom){
        if(!reunionXDia.containsKey(nom)){
            System.out.println("La reunion no existe");
            return null;
        }
        return reunionXDia.get(nom);
    }
}
