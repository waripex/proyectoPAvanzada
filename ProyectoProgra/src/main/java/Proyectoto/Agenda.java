package Proyectoto;
import java.util.*;
/**
 *
 * @author Cristofer
 */
public class Agenda {
    private int idSemana;
    
    private ArrayList<Reunion> actividades;
    
    public Agenda(int idSemana){
        this.idSemana = idSemana;
        actividades = new ArrayList();
    }
    public Agenda(int idSemana, ArrayList ra){
        this.idSemana = idSemana;
        actividades = new ArrayList();
        actividades.addAll(ra);
    }
    
    public int getIdSemana(){
        return idSemana;
    }
    public void setIdSemana(int idSemana){
        this.idSemana = idSemana;
    }
    public void agregaractividad(Reunion rr){
        //validar no estar repetido
        actividades.add(rr);
    }
}
