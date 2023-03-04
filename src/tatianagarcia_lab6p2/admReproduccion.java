
package tatianagarcia_lab6p2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class admReproduccion {
    private ArrayList<Reproduccion> listaReproduccion = new ArrayList();
    private File archivo = null;

    public admReproduccion(String path) {
        archivo = new File(path);
    }

    public ArrayList<Reproduccion> getListaReproduccion() {
        return listaReproduccion;
    }

    public void setListaReproduccion(ArrayList<Reproduccion> listaReproduccion) {
        this.listaReproduccion = listaReproduccion;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    @Override
    public String toString() {
        return "admReproduccion{" + "listaReproduccion=" + listaReproduccion + ", archivo=" + archivo + '}';
    }
    
    public void setReproduccion(Reproduccion p) {
        this.listaReproduccion.add(p);
    }
    
    public void escribirArchivo() throws IOException {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(archivo, false);
            bw = new BufferedWriter(fw);
            for (Reproduccion t : listaReproduccion) {
                
                bw.write(t.getNombre()+"|");
                bw.write(t.getCont()+"|");
                for (int i = 0; i < t.getCanciones().size(); i++) {
                    Canciones a = t.getCanciones().get(i);
                    
                    if (i==t.getCanciones().size()-1) {
                        bw.write(a.getTitulo()+","+a.getDuracion()+","+a.getReferencia());
                    }else{
                        bw.write(a.getTitulo()+","+a.getDuracion()+","+a.getReferencia()+",");
                    }
                }
                bw.write("|");

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
        listaReproduccion = new ArrayList();
        if (archivo.exists()) {
            try {
                sc = new Scanner(archivo);
                sc.useDelimiter("|");
                
                while (sc.hasNextLine()) {
                    String[]x=sc.nextLine().split("\\|");
                        listaReproduccion.add(new Reproduccion(x[0],Integer.parseInt(x[1])) );
                    String canciones[]=x[2].split(",");
                    for (int i = 0; i < canciones.length-2; i+=3) {
                        listaReproduccion.get(con).getCanciones().add(new Canciones(
                                canciones[i],canciones[i+1], Integer.parseInt(canciones[i+2])));
                    }
                    con++;
                }
            } catch (Exception ex) {
            }
            sc.close();
        }//FIN IF
    }
    
}
