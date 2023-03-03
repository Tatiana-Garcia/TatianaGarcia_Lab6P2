
package tatianagarcia_lab6p2;

import java.util.Date;

public class Lanzamiento {
    protected String titulo; 
    protected String fecha;
    protected int con_like; 

    public Lanzamiento() {
    }

    public Lanzamiento(String titulo, String fecha, int con_like) {
        this.titulo = titulo;
        this.fecha = fecha;
        this.con_like = con_like;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCon_like() {
        return con_like;
    }

    public void setCon_like(int con_like) {
        this.con_like = con_like;
    }

    @Override
    public String toString() {
        return "Lanzamiento{" + "titulo=" + titulo + ", fecha=" + fecha + ", con_like=" + con_like + '}';
    }
    
    
    
}
