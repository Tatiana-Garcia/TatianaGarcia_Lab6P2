
package tatianagarcia_lab6p2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class admCanciones {
    private ArrayList<Canciones> listaCanciones = new ArrayList();
    private File archivo = null;

    public admCanciones(String path) {
        archivo = new File(path);
    }

    public ArrayList<Canciones> getListaCanciones() {
        return listaCanciones;
    }

    public void setListaCanciones(ArrayList<Canciones> listaCanciones) {
        this.listaCanciones = listaCanciones;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    @Override
    public String toString() {
        return "admCanciones{" + "listaCanciones=" + listaCanciones + ", archivo=" + archivo + '}';
    }
    
    public void setCanciones(Canciones p) {
        this.listaCanciones.add(p);
    }
    public void escribirArchivo() throws IOException {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(archivo, false);
            bw = new BufferedWriter(fw);
            for (Canciones t : listaCanciones) {
                
                bw.write(t.getTitulo()+"|");
                bw.write(t.getDuracion()+"|");
                bw.write(t.getReferencia()+"|");

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
        listaCanciones = new ArrayList();
        if (archivo.exists()) {
            try {
                sc = new Scanner(archivo);
                sc.useDelimiter("|");
                
                while (sc.hasNextLine()) {
                    String[]x=sc.nextLine().split("\\|");
                    listaCanciones.add(new Canciones(x[0], x[1], Integer.parseInt(x[2])));
                }
            } catch (Exception ex) {
            }
            sc.close();
        }//FIN IF
    }
    
    
}
