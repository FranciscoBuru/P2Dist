/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;
import interfaces.Task;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author sdist
 */
public class MasterNode {

    public static void main(String[] args) {
        try {
            System.setProperty("java.security.policy","file:/C:/Users/sdist.ITAM/Documents/NetBeansProjects/JavaRMI/src/client/client.policy");
            Task arreI[] = new Task[10];
            Task arreM[] = new Task[20];
            Task arreB[] = new Task[15];
            if(System.getSecurityManager() == null){
                System.setSecurityManager(new SecurityManager());
            }
            Task t1 = new Task("T1", "Imagenes", 5000);
            arreI[0] = [];
            
            
            /*
            
            
            
            
            */
            
            
            String nmB = "Bioinformatics";
            String nmD = "DataMining";
            String nmI = "ImageProcessing";
            Registry registry = LocateRegistry.getRegistry("localhost");
            //Arreglo
            
        } catch (RemoteException ex) {
            Logger.getLogger(MasterNode.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private static class hilos extends Thread{
        public hilos(){
        
        }
        @Override
        public void run(){
        
        }
        
    }



}


    
       


