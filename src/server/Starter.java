/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sdist
 */
public class Starter {
    public static void main(String[] args) {
        try {
            System.setProperty("java.security.policy","file:/C:/Users/sdist.ITAM/Documents/NetBeansProjects/JavaRMI/src/server/server.policy");
            
            if(System.getSecurityManager() == null){
                System.setSecurityManager(new SecurityManager());
            }
            LocateRegistry.createRegistry(1099);
            
            //Declarar los 3 esclavos
           SlaveNode esc1 = new SlaveNode();
           SlaveNode esc2 = new SlaveNode();
           SlaveNode esc3 = new SlaveNode();
           esc1.empieza("Bioinformatics");
           esc3.empieza("DataMining");
           esc2.empieza("ImageProcessing");
            
        } catch (RemoteException ex) {
            Logger.getLogger(Starter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
