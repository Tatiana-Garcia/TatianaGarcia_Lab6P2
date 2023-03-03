
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
                //bw.write(t.getEdad()+"|");

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
        //int con =0;
        listaReproduccion = new ArrayList();
        if (archivo.exists()) {
            try {
                sc = new Scanner(archivo);
                sc.useDelimiter("|");
                
                while (sc.hasNextLine()) {
                    String[]x=sc.nextLine().split("\\|");
                        listaReproduccion.add(new Reproduccion(x[0],Integer.parseInt(x[1])) );
                    
                }
            } catch (Exception ex) {
            }
            sc.close();
        }//FIN IF
    }
    
}
