/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.Serializable;

/**
 *
 * @author sdist
 */
public class Credential implements Serializable{
    int id;
    String nombre;

    public Credential(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Credential() {
        this.id = 10;
        this.nombre = "Juan";
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
    
    
    
}
