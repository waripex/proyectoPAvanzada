package com.mycompany.proyectoagenda;

import java.util.*;


/**
 *@author Felipe Bravo
 * @author Cristofer Contreras
 */


public class Reunion {
    private String nombre;
    private int prioridad;
    private ArrayList datos;
    private HashMap ddia;
    
    //instancia de los atributos
    public Reunion(String nombre, int prioridad){
        this.nombre = nombre;
        this.prioridad = prioridad;
        datos = new ArrayList();
        ddia = new HashMap();
    }
    
    public Reunion(){
        datos = new ArrayList();
        ddia = new HashMap();
    }
    
    //setters y getters de los atributos de la clase
    
    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public int getPrioridad() {return prioridad;}

    public void setPrioridad(int prioridad) {this.prioridad = prioridad;}
}
