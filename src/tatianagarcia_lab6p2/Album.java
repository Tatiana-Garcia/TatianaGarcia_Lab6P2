/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tatianagarcia_lab6p2;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author tatig
 */
public class Album extends Lanzamiento{
    private ArrayList<Canciones>canciones = new ArrayList();//Lista de canciones pertenecientes al mismo
    private int cant_canciones;

    public Album() {
        super();
    }

    public Album(int cant_canciones, String titulo, String fecha, int con_like) {
        super(titulo, fecha, con_like);
        this.cant_canciones = cant_canciones;
    }

    public ArrayList<Canciones> getCanciones() {
        return canciones;
    }

    public void setCanciones(ArrayList<Canciones> canciones) {
        this.canciones = canciones;
    }

    public int getCant_canciones() {
        return cant_canciones;
    }

    public void setCant_canciones(int cant_canciones) {
        this.cant_canciones = cant_canciones;
    }

    @Override
    public String toString() {
        return "Album{" + "canciones=" + canciones + ", cant_canciones=" + cant_canciones + '}'+super.toString();
    }
    
    
}
