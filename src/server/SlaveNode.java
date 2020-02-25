/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import interfaces.Bioinformatics;
import interfaces.DataMining;
import interfaces.ImageProcessing;
import interfaces.Task;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sdist
 */
public class SlaveNode implements Bioinformatics, DataMining, ImageProcessing  {

    @Override
    public double executeBioTask(Task aTask) throws RemoteException {
        try {
            Thread.sleep(aTask.getSegundos());
        } catch (InterruptedException ex) {
            Logger.getLogger(SlaveNode.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 1;
    }

    @Override
    public double executeDataTask(Task aTask) throws RemoteException {
        try {
            Thread.sleep(aTask.getSegundos());
        } catch (InterruptedException ex) {
            Logger.getLogger(SlaveNode.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 1;
    }

    @Override
    public double executeImageTask(Task aTask) throws RemoteException {
        try {
            Thread.sleep(aTask.getSegundos());
        } catch (InterruptedException ex) {
            Logger.getLogger(SlaveNode.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 1;
    }

    public void empieza(String tipo) throws RemoteException {
        try {
            System.setProperty("java.security.policy","file:/C:/Users/sdist.ITAM/Documents/NetBeansProjects/JavaRMI/src/server/server.policy");
            if(System.getSecurityManager() == null){
                System.setSecurityManager(new SecurityManager());
            }
            SlaveNode engine = new SlaveNode();
            
            String name;
            if(tipo.equals("Bioinformatics")){
                name = "Bioinformatics";
                Bioinformatics stub = (Bioinformatics)UnicastRemoteObject.exportObject(engine, 0);
                Registry registry = LocateRegistry.getRegistry();
                registry.rebind(name, stub);
            }else if(tipo.equals("DataMining")){
                name = "DataMining";
                DataMining stub = (DataMining)UnicastRemoteObject.exportObject(engine, 0);
                Registry registry = LocateRegistry.getRegistry();
                registry.rebind(name, stub);
            }else{
                name = "ImageProcessing";
                ImageProcessing stub = (ImageProcessing)UnicastRemoteObject.exportObject(engine, 0);
                Registry registry = LocateRegistry.getRegistry();
                registry.rebind(name, stub);
            }
            
            
        } catch (RemoteException ex) {
            Logger.getLogger(SlaveNode.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public SlaveNode() {
        super();
    }
    
    
    
    
}
