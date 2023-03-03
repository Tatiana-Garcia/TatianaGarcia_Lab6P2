/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tatianagarcia_lab6p2;

/**
 *
 * @author tatig
 */
public class Canciones {
    private String titulo; 
    private String duracion; 
    private Album referencia;//referencia al album que pertence

    public Canciones() {
    }

    public Canciones(String titulo, String duracion, Album referencia) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.referencia = referencia;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public Album getReferencia() {
        return referencia;
    }

    public void setReferencia(Album referencia) {
        this.referencia = referencia;
    }

    @Override
    public String toString() {
        return "Canciones{" + "titulo=" + titulo + ", duracion=" + duracion + ", referencia=" + referencia + '}';
    }
    
}
