package proyecto;

public class Reunion {
    private String nombre;
    private int dia;
    private String etiqueta;
    
    public Reunion(String nombre, int dia, String etiqueta){
        this.nombre = nombre;
        this.dia = dia;
        this.etiqueta = etiqueta;
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

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }
    
    
    
    
}
