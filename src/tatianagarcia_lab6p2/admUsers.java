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
public class admUsers {
    private ArrayList<Usuarios> listaUsuarios = new ArrayList();
    private File archivo = null;

    public admUsers(String path) {
        archivo = new File(path);
    }

    public ArrayList<Usuarios> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuarios> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    @Override
    public String toString() {
        return "admUsers{" + "listaUsuarios=" + listaUsuarios + ", archivo=" + archivo + '}';
    }
    public void setUsuario(Usuarios p) {
        this.listaUsuarios.add(p);
    }
    public void escribirArchivo() throws IOException {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(archivo, false);
            bw = new BufferedWriter(fw);
            for (Usuarios t : listaUsuarios) {
                if (t instanceof Oyentes) {
                    bw.write("Oyente|");
                }else if(t instanceof Artista){
                    bw.write("Artista|");
                    bw.write(((Artista) t).getNombre()+"|");
                }
                bw.write(t.getUser()+"|");
                bw.write(t.getPassword()+"|");
                bw.write(t.getEdad()+"|");

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
        listaUsuarios = new ArrayList();
        if (archivo.exists()) {
            try {
                sc = new Scanner(archivo);
                sc.useDelimiter("|");
                
                while (sc.hasNextLine()) {
                    String[]x=sc.nextLine().split("\\|");
                    if (x[0].equals("Artista")) {
                        listaUsuarios.add(new Artista(x[1], x[2], x[3], Integer.parseInt(x[4])));
                    }else{
                        listaUsuarios.add(new Oyentes(x[1], x[2], Integer.parseInt(x[3])));
                    }
                }
            } catch (Exception ex) {
            }
            sc.close();
        }//FIN IF
    }
    
    
}
