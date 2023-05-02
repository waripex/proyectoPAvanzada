
package com.mycompany.proyectoagenda;

/**
 *
 * @author felip
 */
public class AgendaException extends Exception {
    public AgendaException(String errorMessage) {
        super(errorMessage);
    }
    
    public static class IllegalArgumentException extends AgendaException {
        public IllegalArgumentException(String errorMessage) {
            super(errorMessage);
        }
        
        
    }
    
    
}