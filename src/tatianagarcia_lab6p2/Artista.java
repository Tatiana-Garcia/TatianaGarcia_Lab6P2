
package tatianagarcia_lab6p2;

import java.util.ArrayList;

/**
 *
 * @author tatig
 */
public class Artista extends Usuarios{
    private String nombre; 
    private ArrayList<Canciones>canciones = new ArrayList();//Lista de canciones que han subido a la plataforma
    private ArrayList<Album>albumes = new ArrayList();//Lista de albumes publicados

    public Artista() {
        super();
    }

    public Artista(String nombre, String user, String password, int edad) {
        super(user, password, edad);
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Canciones> getCanciones() {
        return canciones;
    }

    public void setCanciones(ArrayList<Canciones> canciones) {
        this.canciones = canciones;
    }

    public ArrayList<Album> getAlbumes() {
        return albumes;
    }

    public void setAlbumes(ArrayList<Album> albumes) {
        this.albumes = albumes;
    }

    @Override
    public String toString() {
        return "Artista{" + "nombre=" + nombre + ", canciones=" + canciones + ", albumes=" + albumes + '}'+super.toString();
    }
    
    
}
