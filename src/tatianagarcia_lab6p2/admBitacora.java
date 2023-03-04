
package tatianagarcia_lab6p2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class admBitacora {
    private File archivo = null;
    private String user, tipo;
    private Date date;

    public admBitacora(String path,String user,String tipo) {
        archivo = new File(path);
        this.user   =user;
        this.tipo=tipo;
    }
    
    public void escribirArchivo() throws IOException {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(archivo, true);
            bw = new BufferedWriter(fw);
            date = new Date();
            bw.write(user+" -> "+tipo+" -> "+date);
            bw.newLine();
            bw.flush();
        } catch (Exception ex) {
        }
        bw.close();
        fw.close();
    }

//    public void cargarArchivo() {
//        Scanner sc = null;
//        //int con =0;
//        listaReproduccion = new ArrayList();
//        if (archivo.exists()) {
//            try {
//                sc = new Scanner(archivo);
//                sc.useDelimiter("|");
//                
//                while (sc.hasNextLine()) {
//                    String[]x=sc.nextLine().split("\\|");
//                        listaReproduccion.add(new Reproduccion(x[0],Integer.parseInt(x[1])) );
//                    
//                }
//            } catch (Exception ex) {
//            }
//            sc.close();
//        }//FIN IF
//    }
}
