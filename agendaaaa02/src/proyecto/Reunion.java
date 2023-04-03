package proyecto;

/**
 *@author Felipe Bravo
 * @author Cristofer Contreras
 */


public class Reunion {
    private String nombre;
    private int prioridad;
    
    //instancia de los atributos
    public Reunion(String nombre, int prioridad){
        this.nombre = nombre;
        this.prioridad = prioridad;
    }
    
    //setters y getters de los atributos de la clase
    
    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public int getPrioridad() {return prioridad;}

    public void setPrioridad(int prioridad) {this.prioridad = prioridad;}
}
