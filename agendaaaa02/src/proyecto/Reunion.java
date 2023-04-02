package proyecto;

/**
 *@author Felipe Bravo
 * @author Cristofer Contreras
 */


public class Reunion {
    private String nombre;
    private int prioridad;
    
    public Reunion(String nombre, int prioridad){
        this.nombre = nombre;
        this.prioridad = prioridad;
    }
    

    Reunion(int prioridad, String nom) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }
    
    
}
