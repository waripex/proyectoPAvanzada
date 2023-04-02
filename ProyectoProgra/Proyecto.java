


package proyecto;

public class Proyecto {

    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    public static void llenadoReuniones(){
        Dia dd = new Dia("Dia 1",);
        DiasXReunion.put("Dia 1", dd);
        dd.agregarReunion("Visitar cliente", 1, 1, "trabajo");
        dd.agregarReunion("Reunion empresa", 1, 1, "trabajo");
        dd.agregarReunion("recoger hijos", 1, 1, "familia");
        dd.agregarReunion("futbol", 1, 1, "amigos");
        dias.add(dd);
        
        dd = new Dia("Dia 2",);
        DiasXReunion.put("Dia 2", dd);
        dd.agregarReunion("Almuerzo colegas", 2, 1, "amigos");
        Reunion rr = new Reunion();
        
    }
    
    public static void listarReuniones
}
