
package tatianagarcia_lab6p2;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author tatig
 */
public class Artista extends Usuarios{
    private String nombre; 
    private ArrayList<Lanzamiento>lanzamiento = new ArrayList();
    //private ArrayList<Canciones>canciones = new ArrayList();//Lista de canciones que han subido a la plataforma
    //private ArrayList<Album>albumes = new ArrayList();//Lista de albumes publicados

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

    public ArrayList<Lanzamiento> getLanzamiento() {
        return lanzamiento;
    }

    public void setLanzamiento(ArrayList<Lanzamiento> lanzamiento) {
        this.lanzamiento = lanzamiento;
    }
    

//    public ArrayList<Canciones> getCanciones() {
//        return canciones;
//    }
//
//    public void setCanciones(ArrayList<Canciones> canciones) {
//        this.canciones = canciones;
//    }
//
//    public ArrayList<Album> getAlbumes() {
//        return albumes;
//    }
//    public void setAlbumes(ArrayList<Album> albumes) {
//        this.albumes = albumes;
//    }

    @Override
    public int getEdad() {
        return edad;
    }

    @Override
    public void setEdad(int edad) {
        if (edad>18) {
            this.edad = edad;
        }else{
            JOptionPane.showMessageDialog(null, "Edad no valida");
        }
        
        
    }
    

    

    @Override
    public String toString() {
        return "Artista{" + "nombre=" + nombre + ", lanzamiento=" + lanzamiento + '}'+super.toString();
    }
    
    
}
