package com.mycompany.proyectoagenda;

import javax.swing.*;

/**
 *@author Felipe Bravo
 * @author Cristofer Contreras
 */


//import VentanaPrincipal;
import static com.mycompany.proyectoagenda.Menu.crearMenu;
import com.opencsv.exceptions.CsvValidationException;
import java.io.*;



public class ProyectoAgenda {
    
    public static void main(String[] args) throws IOException, CsvValidationException{
        
        // Crear y configurar la ventana principal
        VentanaPrincipall ventanaPrincipal = new VentanaPrincipall();
        ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaPrincipal.setSize(400, 300);
        
        // Hacer visible la ventana principal
        ventanaPrincipal.setVisible(true);
        // Menu
        crearMenu();
    }   
}