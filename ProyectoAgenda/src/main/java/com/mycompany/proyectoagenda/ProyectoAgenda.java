
package com.mycompany.proyectoagenda;

/**
 *@author Felipe Bravo
 * @author Cristofer Contreras
 */


import static com.mycompany.proyectoagenda.Menu.crearMenu;
import com.opencsv.exceptions.CsvValidationException;
import java.io.*;



public class ProyectoAgenda {
    
    public static void main(String[] args) throws IOException, CsvValidationException{
        // Menu
        //VentanaAgenda interfaz = new VentanaAgenda();
        //interfaz.main(args);
        crearMenu();
    }   
}
