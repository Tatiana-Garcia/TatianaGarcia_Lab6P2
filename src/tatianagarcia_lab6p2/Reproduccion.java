
package tatianagarcia_lab6p2;

import java.util.ArrayList;

public class Reproduccion {
    private String nombre; 
    private int cont; 
    private ArrayList<Canciones>canciones = new ArrayList();//Lista de canciones que se iran agregando

    public Reproduccion() {
    }

    public Reproduccion(String nombre, int cont) {
        this.nombre = nombre;
        this.cont = cont;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }

    public ArrayList<Canciones> getCanciones() {
        return canciones;
    }

    public void setCanciones(ArrayList<Canciones> canciones) {
        this.canciones = canciones;
    }

    @Override
    public String toString() {
        return "Reproduccion{" + "nombre=" + nombre + ", cont=" + cont + ", canciones=" + canciones + '}';
    }
    
}
