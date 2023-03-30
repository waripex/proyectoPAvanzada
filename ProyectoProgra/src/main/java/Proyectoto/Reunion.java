package Proyectoto;

public class Reunion {
    private String nombre;
    private int dia;
    private int semana;
    private String etiqueta;// mapa 
    
    public Reunion (String nombre, int dia, int semana, String etiqueta){
        this.nombre = nombre;
        this.dia = dia;
        this.semana = semana;
        this.etiqueta = etiqueta;
    }
    // Setter &  getters 
    public void setNom(String nombre){
        this.nombre = nombre;
    }
    public void setDia(int dia){
        this.dia = dia;
    }
    public void setEtiqueta(String etiqueta){
        this.etiqueta = etiqueta;
    }
    public void setSemana(int semana){
        this.semana = semana;
    }
    
    
    public String getNom(){
        return nombre;
    }
    public int getDia(){
        return dia;
    }
    public String getEtiqueta(){
        return etiqueta;
    }
    public int getSemana(){
        return semana;
    }
}
