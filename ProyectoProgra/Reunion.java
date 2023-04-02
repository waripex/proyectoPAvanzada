package proyecto;

public class Reunion {
    private String nombre;
    private int dia;
    
    public Reunion(String nombre, int dia, String etiqueta){
        this.nombre = nombre;
        this.dia = dia;
    }

    Reunion(int dia, String nom) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }
    
    
}
