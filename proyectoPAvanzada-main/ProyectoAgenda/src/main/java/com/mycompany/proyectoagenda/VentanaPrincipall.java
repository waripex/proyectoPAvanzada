package com.mycompany.proyectoagenda;

import javax.swing.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author rikia
 */
class VentanaPrincipall extends JFrame {
    
    public VentanaPrincipall() {
        
        // Configurar la ventana principal
        super("Agenda");
        // Crear los componentes de la ventana
        JButton btnListar = new JButton("Listar reuniones");
        JButton btnAgregar = new JButton("Agregar");
        JButton btnEditar = new JButton("Editar");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnMostrar = new JButton("Mostrar reuniones del dia");
        JButton btnCerrar = new JButton("Cerrar");
        
        // Agregar los componentes a la ventana
        JPanel panel = new JPanel();
        panel.add(btnListar);
        panel.add(btnAgregar);
        panel.add(btnEditar);
        panel.add(btnEliminar);
        panel.add(btnMostrar);
        panel.add(btnCerrar);
        
        getContentPane().add(panel);
    }   
}