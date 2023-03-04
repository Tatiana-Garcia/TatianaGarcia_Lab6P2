/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tatianagarcia_lab6p2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author tatig
 */
public class admLanzamientos {
    private ArrayList<Lanzamiento> listaLanzamientos = new ArrayList();
    private File archivo = null;

    public admLanzamientos(String path) {
        archivo = new File(path);
    }

    public ArrayList<Lanzamiento> getListaLanzamientos() {
        return listaLanzamientos;
    }

    public void setListaLanzamientos(ArrayList<Lanzamiento> listaLanzamientos) {
        this.listaLanzamientos = listaLanzamientos;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    @Override
    public String toString() {
        return "admLanzamientos{" + "listaLanzamientos=" + listaLanzamientos + ", archivo=" + archivo + '}';
    }
    public void setLanzamiento(Lanzamiento p) {
        this.listaLanzamientos.add(p);
    }
    
    public void escribirArchivo() throws IOException {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(archivo, false);
            bw = new BufferedWriter(fw);
            for (Lanzamiento t : listaLanzamientos) {
                if (t instanceof Album) {
                    bw.write("Album|");
                    bw.write(((Album) t).getCant_canciones()+"|");
                    bw.write(((Album) t).getCanciones()+"|");
                }else if(t instanceof Single){
                    bw.write("Single|");
                    bw.write(((Single) t).getCancion().getTitulo()+",");
                    bw.write(((Single) t).getCancion().getDuracion()+",");
                    bw.write(((Single) t).getCancion().getReferencia()+"|");
                    
                    
                    //bw.write(((Artista) t).getNombre()+"|");
                }
                bw.write(t.getTitulo()+"|");
                bw.write(t.getFecha()+"|");
                bw.write(t.getCon_like()+"|");

            }
            bw.newLine();
            bw.flush();
        } catch (Exception ex) {
        }
        bw.close();
        fw.close();
    }

    public void cargarArchivo() {
        Scanner sc = null;
        int con =0;
        listaLanzamientos = new ArrayList();
        if (archivo.exists()) {
            try {
                sc = new Scanner(archivo);
                sc.useDelimiter("|");
                
                while (sc.hasNextLine()) {
                    String[]x=sc.nextLine().split("\\|");
                    if (x[0].equals("Album")) {
                        
                        listaLanzamientos.add(new Album(Integer.parseInt(x[1]), x[3], x[4], Integer.parseInt(x[5])));
                        //
                        String canciones[]=x[2].split(".");
                        for (int i = 0; i < canciones.length-2; i+=3) {
                            ((Album)listaLanzamientos.get(con)).getCanciones().add(new Canciones(
                                canciones[i],canciones[i+1], Integer.parseInt(canciones[i+2])));
                        }
                        //
                    }else{
                        //String accesorio[]=x[3].split(",");
                        String []single= x[1].split(",");
                        Canciones t = new Canciones(single[0], single[1], Integer.parseInt(single[2]));
                        listaLanzamientos.add(new Single(t, x[2], x[3], Integer.parseInt(x[4])));
                    }
                    con++;
                }
            } catch (Exception ex) {
            }
            sc.close();
        }//FIN IF
    }
    
}
