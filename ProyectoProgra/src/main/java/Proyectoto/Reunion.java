package Proyectoto;

public class Reunion {
    private String nombre;
    private String fecha;
    private String etiqueta;
    
    public Reunion(String nombre, String fecha, String etiqueta){
    this.nombre = nombre;
    this.fecha = fecha;
    this.etiqueta = etiqueta;
    }
    
    public void setNom(String nombre){
        this.nombre = nombre;
    }
    public void setFecha(String fecha){
        this.fecha = fecha;
    }
    public void setEtiqueta(String etiqueta){
        this.etiqueta = etiqueta;
    }
    
    public String getNom(){
        return nombre;
    }
    public String getFecha(){
        return fecha;
    }
    public String getEtiqueta(){
        return etiqueta;
    }
}
