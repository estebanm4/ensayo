package leer;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Leer {
    
    public static void main(String[] args) {
    File miArchivo;
    FileReader lectura; //Variable para leer
    String cadena;
    String ventana = "";  
    
    miArchivo = new File("ejemploLectura.txt");
    
    if ( !miArchivo.exists()){
        try {
            miArchivo.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }   
    }
    
        try {
            lectura = new FileReader(miArchivo);
            BufferedReader almacenamiento = new BufferedReader (lectura);
            cadena = "";
            while(cadena != null){
                try {
                    cadena = almacenamiento.readLine(); //Almacena una línea de Texto
                    if(cadena != null){
                        System.out.println(cadena);
                        ventana = ventana + cadena + "\n";
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Leer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        try {
            almacenamiento.close();
            lectura.close();
        } catch (IOException ex) {
            Logger.getLogger(Leer.class.getName()).log(Level.SEVERE, null, ex);
        }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Leer.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, ventana, "Datos del archivo", 1 );
    }   
}
