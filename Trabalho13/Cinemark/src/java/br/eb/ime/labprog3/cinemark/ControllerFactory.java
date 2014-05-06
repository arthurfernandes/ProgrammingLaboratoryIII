/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.eb.ime.labprog3.cinemark;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author arthurfernandes
 */
public class ControllerFactory {
    public static final Controller getControllerPorClasse(Class actionClass){
        try {
            Controller controller = (Controller) actionClass.newInstance();
            return controller;
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(ControllerFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static final Controller getControllerPorNomeDaClasse(String className){
        
        try {
            String name = "br.eb.ime.labprog3.cinemark." + className;
            Class actionClass = Class.forName(name);
            Controller controller = ControllerFactory.getControllerPorClasse(actionClass);
            return controller;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControllerFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
}
