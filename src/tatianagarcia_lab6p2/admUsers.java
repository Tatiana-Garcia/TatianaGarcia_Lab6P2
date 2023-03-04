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
                    bw.write(((Artista) t).getLanzamiento()+"|");
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
        int con2 =0;
        listaUsuarios = new ArrayList();
        if (archivo.exists()) {
            try {
                sc = new Scanner(archivo);
                sc.useDelimiter("|");
                
                while (sc.hasNextLine()) {
                    String[]x=sc.nextLine().split("\\|");
                    if (x[0].equals("Artista")) {
                        listaUsuarios.add(new Artista(x[1], x[3], x[4], Integer.parseInt(x[5])));
                        //
                        String lanzamientos[]=x[2].split(",");
                        System.out.println(x[lanzamientos.length-5]);
                        int num = 0;
                        if (x[lanzamientos.length-5].equals("Single")) {
                            num=4;
                        }else{
                            num=5;
                        }
                        
                        for (int i = 0; i < lanzamientos.length-num; i+=3) {
                            if (lanzamientos[i].equals("Single")) {
                                String canciones []= lanzamientos[i+1].split(".");
                                Canciones c = new Canciones();
                                for (int j = 0; j < canciones.length-2; j+=3) {
                                    c = new Canciones(canciones[j],canciones[j+1], Integer.parseInt(canciones[j+2]));
                                    
                                }
                                Single s = new Single(c, lanzamientos[i+2], lanzamientos[i+3], 
                                        Integer.parseInt(lanzamientos[i+4]));
                                ((Artista)listaUsuarios.get(con)).getLanzamiento().add(s);
                                i+=2;
                            }else{
                                
                                String canciones []= lanzamientos[i+2].split(".");
                                for (int j = 0; j < canciones.length-2; j+=3) {
                                    ((Album)((Artista)listaUsuarios.get(con)).getLanzamiento().get(con2)).
                                            getCanciones().add(new Canciones( canciones[i],canciones[i+1], 
                                                    Integer.parseInt(canciones[i+2])));
                    
                                }
                                
                                Album a = new Album(Integer.parseInt(lanzamientos[i+1]),
                                        lanzamientos[i+3] , lanzamientos[i+4],Integer.parseInt( lanzamientos[i+5]));
                                ((Artista)listaUsuarios.get(con)).getLanzamiento().add(a);
                                
                                i+=3;
                            }
                            con2++;
                        }
                        
//                        ((Album)listaLanzamientos.get(con)).getCanciones().add(new Canciones(
//                                canciones[i],canciones[i+1], Integer.parseInt(canciones[i+2])));
                        //
                    }else{
                        listaUsuarios.add(new Oyentes(x[1], x[2], Integer.parseInt(x[3])));
                    }
                    con++;
                }
            } catch (Exception ex) {
            }
            sc.close();
        }//FIN IF
    }
    
    
}
