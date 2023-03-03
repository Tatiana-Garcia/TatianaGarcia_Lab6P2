/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tatianagarcia_lab6p2;

import java.util.Date;

/**
 *
 * @author tatig
 */
public class Single extends Lanzamiento{
    private Canciones cancion; 

    public Single() {
        super();
    }

    public Single(Canciones cancion, String titulo, String fecha, int con_like) {
        super(titulo, fecha, con_like);
        this.cancion = cancion;
    }

    public Canciones getCancion() {
        return cancion;
    }

    public void setCancion(Canciones cancion) {
        this.cancion = cancion;
    }

    @Override
    public String toString() {
        return "Single{" + "cancion=" + cancion + '}'+super.toString();
    }
    
    

    
    
}
