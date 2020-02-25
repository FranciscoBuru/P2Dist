/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.io.Serializable;

/**
 *
 * @author sdist
 */
public class Task implements Serializable {
    String tarea;
    String tipo;
    int segundos;


    
    

    public Task(String tarea, String tipo, int segundos) {
        this.tarea = tarea;
        this.tipo = tipo;
        this.segundos = segundos;
    }

    public String getTarea() {
        return tarea;
    }

    public String getTipo() {
        return tipo;
    }

    public int getSegundos() {
        return segundos;
    }
    
    
    
}
