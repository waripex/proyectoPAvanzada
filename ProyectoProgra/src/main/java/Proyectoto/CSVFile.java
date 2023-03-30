package Proyectoto;

import java.util.*;
import java.io.*;

/**
 *
 * @author felip
 */
public class CSVFile {
    
    //Variables de instancia
    private BufferedReader file;
    private String currentLine;
    
    //constructor de clase CSVFile con nombre especifico
    public CSVFile (String name) throws FileNotFoundException{
        this.file =new BufferedReader(new FileReader("./"+name+".csv"));
    }
    
    //constructor de clase CSVFile con ruta y nombre especificos
    public CSVFile(String route,String archivo) throws FileNotFoundException{
        this.file = new BufferedReader(new FileReader(route+archivo));
    }
    
    //constructor de clase CSV
    public CSVFile (){   
    }
    
    //Metodos
    
    //Primera linea CSV
    public String firstLine() throws IOException{
        return nextLine();
    }
    
    //Siguiente linea del CSV
    public String nextLine() throws IOException{
        this.currentLine = this.file.readLine();
        return (this.currentLine);
    }
    
    // Dato del campo en una linea del CSV
    public String get_csvField(String line, int field){
        
        Scanner s = new Scanner(line);
        int index = (0);
        s.useDelimiter(",|\\n");
        String output;
    
    
        while(s.hasNext()){
            output = (s.next());
            if((output.charAt(0))==('\"')){
                while (true){
                    if((output.charAt((output.length())-1))==('\"')){
                        break;
                    }
                    output = (output+","+(s.next()));
                }
            }
            if (index == field){
                s.close();
                return(output);
            }
            index = (index+1);
        }
        //System.out.println("Campo "+field+" no Existe");
        s.close();
        return (null);
    }
    
    //Entrega del dato en una linea de CSV
    public String get_csvField(int field,String line){
        Scanner s = new Scanner(line);
        int index =(0);
        s.useDelimiter(",|\\n");
        String output;
        
        while(s.hasNext()){
            output =(s.next());
            if((output.charAt(0))==('\"')){
                while (true){
                    output =(output+","+(s.next()));
                    if ((output.charAt((output.length())-1))==('\"')){
                        break;
                    }
                }
            }
            
            if (index==field){
                return(output);
            }
            index =(index+1);
        }
        //System.out.println("Campo "+field+" no Existe");
        return(null);
    }
    
    // Cierre del archivo CSV
    public void close() throws IOException{
        file.close();
    }
}
