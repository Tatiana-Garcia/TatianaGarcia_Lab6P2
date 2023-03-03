
package tatianagarcia_lab6p2;

import java.util.ArrayList;

public class Oyentes extends Usuarios{
    private ArrayList<Canciones>canciones = new ArrayList();//Lista de canciones favoritas
    private ArrayList<Reproduccion>C_reproduccion = new ArrayList();//Lista de reproduccion creadas
    private ArrayList<Reproduccion>like_reproduccion = new ArrayList();//Lista de reproduccion dadas me gusta

    public Oyentes() {
        super();
    }

    public Oyentes(String user, String password, int edad) {
        super(user, password, edad);
    }

    public ArrayList<Canciones> getCanciones() {
        return canciones;
    }

    public void setCanciones(ArrayList<Canciones> canciones) {
        this.canciones = canciones;
    }

    public ArrayList<Reproduccion> getC_reproduccion() {
        return C_reproduccion;
    }

    public void setC_reproduccion(ArrayList<Reproduccion> C_reproduccion) {
        this.C_reproduccion = C_reproduccion;
    }

    public ArrayList<Reproduccion> getLike_reproduccion() {
        return like_reproduccion;
    }

    public void setLike_reproduccion(ArrayList<Reproduccion> like_reproduccion) {
        this.like_reproduccion = like_reproduccion;
    }

    @Override
    public String toString() {
        return "Oyentes{" + "canciones=" + canciones + ", C_reproduccion=" + C_reproduccion + ", like_reproduccion=" + like_reproduccion + '}'+super.toString();
    }
    
    
}
