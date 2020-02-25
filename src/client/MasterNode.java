/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;
import interfaces.Bioinformatics;
import interfaces.DataMining;
import interfaces.ImageProcessing;
import interfaces.Task;
import java.io.Serializable;
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
            Task t1 = new Task("T1", "ImageProcessing", 1000);
            arreI[0] = t1;
            t1 = new Task("T2", "ImageProcessing", 2000);
            arreI[1] = t1;
            
            t1 = new Task("T11", "DataMining", 1000);
            arreM[0] = t1;
            t1 = new Task("T12", "DataMining", 10);
            arreM[1] = t1;
            
            t1 = new Task("T31", "Bioinformatics", 2000);
            arreB[0] = t1;
            t1 = new Task("T32", "Bioinformatics", 10);
            arreB[1] = t1;
            
            
           
            Registry registry = LocateRegistry.getRegistry("localhost");
            
            hilo h1 = new hilo(arreM, registry);
            h1.start();
            hilo h2 = new hilo(arreB, registry);
            h2.start();
            //hilo h3 = new hilo(arreI, registry);
            //h3.start();
         
            
        } catch (RemoteException ex) {
            Logger.getLogger(MasterNode.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    private static class hilo extends Thread implements Serializable{
        Task arre[];
        Registry registry;
        
        public hilo(Task[] arre,Registry reg){
          this.arre = arre;
          this.registry = reg;
        }
        @Override
        public void run(){
            if(arre[0].getTipo().equals("DataMining")){
                try {
                    String name = "DataMining";
                    
                    for(int i =0; i<2; i++){
                        DataMining data = (DataMining) registry.lookup(name);
                        data.executeDataTask(arre[i]);
                    }
                    
                } catch (RemoteException ex) {
                    Logger.getLogger(MasterNode.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NotBoundException ex) {
                    Logger.getLogger(MasterNode.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if (arre[0].getTipo().equals("ImageProcessing")){
                try {
                    String name = "ImageProcessing";
                    
                    for(int i =0; i<2; i++){
                        ImageProcessing imag = (ImageProcessing) registry.lookup(name);
                        imag.executeImageTask(arre[i]);
                    }
                } catch (RemoteException ex) {
                    Logger.getLogger(MasterNode.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NotBoundException ex) {
                    Logger.getLogger(MasterNode.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
                try {
                    String name = "Bioinformatics";
                    
                    for(int i =0; i<2; i++){
                        Bioinformatics bio = (Bioinformatics) registry.lookup(name);
                        bio.executeBioTask(arre[i]);
                    }
                } catch (RemoteException ex) {
                    Logger.getLogger(MasterNode.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NotBoundException ex) {
                    Logger.getLogger(MasterNode.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    }



}


    
       


